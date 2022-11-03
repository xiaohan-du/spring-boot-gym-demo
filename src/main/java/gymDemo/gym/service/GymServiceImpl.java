package gymDemo.gym.service;

import gymDemo.gym.data.GymRepository;
import gymDemo.gym.domain.Gym;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GymServiceImpl implements GymService {
    private final GymRepository gymRepository;
    public GymServiceImpl(GymRepository repo) {
        this.gymRepository = repo;
    }
    @Override
    public List<GymDto> getGyms() {
        List<Gym> gyms = gymRepository.getGyms();
        return GymAssembler.toDto(gyms);
    }
}
