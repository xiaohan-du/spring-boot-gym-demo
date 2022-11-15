package gymDemo.gym.domain;

import lombok.AllArgsConstructor;
import lombok.Value;

@Value
@AllArgsConstructor
public class ManagerRole {
    private final Integer id;
    private final String title;
}
