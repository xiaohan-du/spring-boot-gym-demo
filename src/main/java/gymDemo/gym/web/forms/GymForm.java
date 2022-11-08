package gymDemo.gym.web.forms;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GymForm {
    private String name;
    private String id;
    private String location;
    private Double fee;
    private Boolean isApproved;
}
