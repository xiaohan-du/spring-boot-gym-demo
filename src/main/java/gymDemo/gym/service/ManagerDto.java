package gymDemo.gym.service;

import lombok.AllArgsConstructor;
import lombok.Value;

@Value
@AllArgsConstructor
public class ManagerDto {
    private Integer id;
    private String name;
    private String address;
    private Integer roleId;
}
