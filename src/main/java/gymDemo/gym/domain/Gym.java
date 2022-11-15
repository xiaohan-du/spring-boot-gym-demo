package gymDemo.gym.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
public class Gym {
    private String name;
    private Integer id;
    private String location;
    private Double fee;
    private Boolean isApproved;
    private List<Manager> managers;

    public Gym(String name, Integer id, String location, Double fee, Boolean isApproved) {
        this.name = name;
        this.id = id;
        this.location = location;
        this.fee = fee;
        this.isApproved = isApproved;
        this.managers = null;
    }
}
