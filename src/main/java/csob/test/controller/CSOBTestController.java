package csob.test.controller;

import csob.test.dto.UserDto;
import csob.test.model.User;
import csob.test.service.RestService;
import jakarta.validation.constraints.NotEmpty;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import static java.util.stream.Collectors.toMap;

@RestController
@RequestMapping("interests-of-users")
@RequiredArgsConstructor
public class CSOBTestController {

    final RestService restService;

    @GetMapping
    public ResponseEntity<Map<String, List<UserDto>>> getInterestUsers(@RequestParam @NotEmpty List<String> interests) {
        return ResponseEntity.ok(map(restService.getUserInterests(interests)));
    }

    private Map<String, List<UserDto>> map(Map<String, List<User>> userInterests) {
        return userInterests.entrySet().stream()
                .collect(toMap(Entry::getKey, entry -> map(entry.getValue())));
    }

    private List<UserDto> map(List<User> users) {
        return users.stream()
                .map(user -> new UserDto(user.getUserId(), user.getName()))
                .toList();
    }
}
