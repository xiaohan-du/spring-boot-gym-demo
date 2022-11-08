package gymDemo.gym.data;

import gymDemo.gym.domain.Gym;

import java.util.List;
import java.util.Optional;

public interface GymRepository {
    List<Gym> getGyms();
    Optional<Gym> getGymById(String id);
    void add(Gym newGym);
}
