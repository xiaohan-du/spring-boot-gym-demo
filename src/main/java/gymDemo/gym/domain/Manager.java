package gymDemo.gym.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Manager {
    private Integer id;
    private String name;
    private String address;
    private ManagerRole role;
}
