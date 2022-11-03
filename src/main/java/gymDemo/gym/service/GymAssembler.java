package gymDemo.gym.service;

import gymDemo.gym.domain.Gym;

import java.util.List;
import java.util.stream.Collectors;

public class GymAssembler {

    public static List<GymDto> toDto(List<Gym> gyms) {
        return gyms.stream().map(g -> toDto(g)).collect(Collectors.toList());
    }
    public static GymDto toDto(Gym gym) {
        return new GymDto(
                gym.getName(),
                gym.getId(),
                gym.getLocation(),
                gym.getFee(),
                gym.getIsApproved()
        );
    }
}
