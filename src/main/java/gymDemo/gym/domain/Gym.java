package gymDemo.gym.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
public class Gym {
    private String name;
    private String id;
    private String location;
    private Double fee;
    private Boolean isApproved;

    public Gym(String name, String id, String location, Double fee, Boolean isApproved) {
        this.name = name;
        this.id = id;
        this.location = location;
        this.fee = fee;
        this.isApproved = isApproved;
    }
}
