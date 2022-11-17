package gymDemo.gym.service;

import gymDemo.gym.domain.Gym;
import gymDemo.gym.domain.Manager;
import gymDemo.gym.domain.Member;

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
                gym.getIsApproved(),
                gym.getManagers()
        );
    }

    public static GymAndManagerDto toDtoWithManagers(Gym gym) {
        List<ManagerDto> managers = gym.getManagers()
                .stream()
                .map(m -> new ManagerDto(m.getId(), m.getName(), m.getAddress(), m.getRole().getId()))
                .collect(Collectors.toList());
        GymAndManagerDto dto = new GymAndManagerDto(gym.getName(), gym.getId(), gym.getLocation(), gym.getFee(), gym.getIsApproved(), managers);
        return dto;
    }

    public static MemberDto toDto(Member member) {
        return new MemberDto(
                member.getId(),
                member.getName(),
                member.getAddress(),
                member.getTier(),
                member.getGym_id()
        );
    }

    public static List<MemberDto> toMemberDto(List<Member> members) {
        return members.stream().map(m -> toDto(m)).collect(Collectors.toList());
    }
}
