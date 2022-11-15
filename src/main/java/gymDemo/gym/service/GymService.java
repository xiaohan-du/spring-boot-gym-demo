package gymDemo.gym.service;

import java.util.List;
import java.util.Optional;

public interface GymService {
    List<GymDto> getGyms();
    Optional<GymDto> getGymById(Integer id);
    void addNewGym(GymDto gymDto);
    List<GymDto> getGymsBySearch(String query);
}
