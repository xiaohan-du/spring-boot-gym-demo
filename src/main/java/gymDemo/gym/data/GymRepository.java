package gymDemo.gym.data;

import gymDemo.gym.domain.Gym;
import gymDemo.gym.domain.Member;

import java.util.List;
import java.util.Optional;

public interface GymRepository {
    List<Gym> getGyms();
    Optional<Gym> getGymById(Integer id);
    void add(Gym newGym);
    List<Gym> getGymBySearch(String query);
    List<Member> getMembers();
}
