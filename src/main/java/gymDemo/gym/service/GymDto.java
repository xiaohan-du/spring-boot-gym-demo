package gymDemo.gym.service;

import lombok.AllArgsConstructor;
import lombok.Value;

@Value
@AllArgsConstructor
public class GymDto {
    private String name;
    private String id;
    private String location;
    private Double fee;
    private Boolean isApproved;
}
