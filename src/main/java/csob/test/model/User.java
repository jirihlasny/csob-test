package csob.test.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class User {

    @JsonProperty("user_id")
    private String userId;

    @JsonProperty("username")
    private String name;

    private List<String> interests;
}
