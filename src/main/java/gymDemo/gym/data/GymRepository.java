package gymDemo.gym.data;

import gymDemo.gym.domain.Gym;

import java.util.List;

public interface GymRepository {
    List<Gym> getGyms();
}
