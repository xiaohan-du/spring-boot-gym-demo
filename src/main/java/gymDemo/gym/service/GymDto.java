package gymDemo.gym.service;

import gymDemo.gym.domain.Manager;
import lombok.AllArgsConstructor;
import lombok.Value;

import java.util.List;

@Value
@AllArgsConstructor
public class GymDto {
    private String name;
    private Integer id;
    private String location;
    private Double fee;
    private Boolean isApproved;
    private List<Manager> managers;
}
