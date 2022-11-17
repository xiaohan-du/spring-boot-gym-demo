package gymDemo.gym.service;

import gymDemo.gym.domain.Manager;
import lombok.AllArgsConstructor;
import lombok.Value;

import java.util.List;

@Value
@AllArgsConstructor
public class GymAndManagerDto {
    private String name;
    private Integer id;
    private String location;
    private Double fee;
    private Boolean isApproved;
    private List<ManagerDto> managers;

    public GymAndManagerDto(String name, Integer id, String location, Double fee, Boolean isApproved) {
        this(name, id, location, fee, isApproved, null);
    }
}
