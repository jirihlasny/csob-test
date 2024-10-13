package csob.test.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import csob.test.model.User;
import csob.test.model.UserPage;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import java.util.List;
import java.util.Map;

import static java.util.function.Function.identity;
import static java.util.stream.Collectors.toMap;

@Service
@RequiredArgsConstructor
public class RestService {

    private final RestClient restClient;
    private final ObjectMapper objectMapper;

    public Map<String, List<User>> getUserInterests(List<String> interests) {
        List<User> usersWithInterests = getUsers();

        return interests.stream()
                .collect(toMap(identity(), interest -> usersWithInterests.stream()
                        .filter(user -> user.getInterests().contains(interest))
                        .toList()));
    }

    public List<User> getUsers() {
        String response = restClient.get()
                .retrieve()
                .body(String.class);

        if (response == null) {
            throw new UsersNotReceivedException("No users were received using REST service.");
        }

        try {
            return objectMapper.readValue(response, UserPage.class).getUsers();

        } catch (JsonProcessingException e) {
            throw new UsersNotReadableException("Can't process list of users from REST service.", e);
        }
    }
}
