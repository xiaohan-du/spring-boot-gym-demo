package gymDemo.gym.web.forms;

import gymDemo.gym.web.UniqueId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GymForm {
    @NotEmpty(message = "{name.invalid}")
    private String name;
    @UniqueId
    @NotNull(message = "{id.invalid}")
    private Integer id;
    private String location;
    @NotNull(message = "{fee.invalid}")
    private Double fee;
    private Boolean isApproved;
}
