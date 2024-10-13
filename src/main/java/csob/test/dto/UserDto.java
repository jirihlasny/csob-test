package csob.test.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public record UserDto(
        @JsonProperty(value = "user_id", index = 0) String userId,
        @JsonProperty(index = 1) String name) {
}
