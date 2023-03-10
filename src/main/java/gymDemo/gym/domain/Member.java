package gymDemo.gym.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Member {
    private Integer id;
    private String name;
    private String address;
    private Integer tier;
    private Integer gym_id;
}
