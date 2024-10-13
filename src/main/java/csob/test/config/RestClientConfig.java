package csob.test.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestClient;

@Configuration
public class RestClientConfig {

    @Bean
    RestClient restClient() {
        return RestClient.builder()
                .baseUrl("https://raw.githubusercontent.com/sustacek/java_spring_interview_assignment/refs/heads/main/server/get-users.json")
                .build();
    }
}
