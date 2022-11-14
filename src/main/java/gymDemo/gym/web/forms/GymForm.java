package gymDemo.gym.web.forms;

import gymDemo.gym.web.UniqueId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GymForm {
    @NotEmpty(message = "{name.invalid}")
    private String name;
    @Pattern(regexp = "\\(|\\)|\\d{3}", message = "{id.invalid}")
    @UniqueId
    private String id;
    private String location;
    @Pattern(regexp=".*[0-9].*", message = "{fee.invalid}")
    private String fee;
    private Boolean isApproved;
}
