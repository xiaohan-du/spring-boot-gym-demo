package gymDemo.gym.service;

import lombok.AllArgsConstructor;
import lombok.Value;

@Value
@AllArgsConstructor
public class MemberDto {
    private Integer id;
    private String name;
    private String address;
    private Integer tier;
    private Integer gym_id;
}
