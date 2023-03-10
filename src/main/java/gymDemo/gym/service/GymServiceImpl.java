package gymDemo.gym.service;

import gymDemo.gym.data.GymRepository;
import gymDemo.gym.domain.Gym;
import gymDemo.gym.domain.Member;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    @Override
    public List<MemberDto> getMembers() {
        List<Member> members = gymRepository.getMembers();
        return GymAssembler.toMemberDto(members);
    }

    @Override
    public Optional<GymDto> getGymById(Integer id) {
        Optional<Gym> aGym = gymRepository.getGymById(id);
        if (aGym.isPresent()) {
            return Optional.of(GymAssembler.toDto(aGym.get()));
        } else {
            return Optional.empty();
        }
    }

    @Override
    public Optional<GymAndManagerDto> getGymByIdWithManagers(Integer id) {
        Optional<Gym> aGym = gymRepository.getGymById(id);
        if (aGym.isPresent()) {
            return Optional.of(GymAssembler.toDtoWithManagers(aGym.get()));
        } else {
            return Optional.empty();
        }
    }

    @Override
    public void addNewGym(GymDto gymDto) {
        Gym newGym = new Gym(
                gymDto.getName(),
                gymDto.getId(),
                gymDto.getLocation(),
                gymDto.getFee(),
                false
        );
        gymRepository.add(newGym);
    }

    @Override
    public List<GymDto> getGymsBySearch(String query) {
        List<Gym> gyms = gymRepository.getGymBySearch(query);
        return GymAssembler.toDto(gyms);
    }
}
