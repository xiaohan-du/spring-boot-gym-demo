package gymDemo.gym.data;

import gymDemo.gym.domain.Gym;
import gymDemo.gym.domain.Manager;
import gymDemo.gym.domain.ManagerRole;
import gymDemo.gym.domain.Member;
import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class GymRepositoryImpl implements GymRepository{
    private final JdbcTemplate jdbcTemplate;
    private RowMapper<Gym> gymRowMapper;
    private RowMapper<Manager> managerRowMapper;

    private RowMapper<Member> memberRowMapper;

    public GymRepositoryImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
        setGymRowMapper();
        setMemberRowMapper();
        setManagerRowMapper();
    }

    private void setManagerRowMapper() {
        managerRowMapper = (rm, index) -> new Manager(
                rm.getInt("id"),
                rm.getString("name"),
                rm.getString("address"),
                new ManagerRole(rm.getInt("id"), rm.getString("title"))
        );
    }
    private void setGymRowMapper() {
        gymRowMapper = (rm, index) -> new Gym(
                rm.getString("name"),
                rm.getInt("id"),
                rm.getString("location"),
                rm.getDouble("fee"),
                (rm.getString("is_approved").equals("1")) ? Boolean.TRUE : Boolean.FALSE
        );
    }

    private void setMemberRowMapper() {
        memberRowMapper = (rm, index) -> new Member(
                rm.getInt("id"),
                rm.getString("name"),
                rm.getString("address"),
                rm.getInt("tier"),
                rm.getInt("gym_id")
        );
    }

    @Override
    public List<Gym> getGyms() {
        String getGymsSQL = "SELECT * FROM gym";
        return jdbcTemplate.query(getGymsSQL, gymRowMapper);
    }

    @Override
    public Optional<Gym> getGymById(Integer id) {
        String getGymByIdSQL = "SELECT * FROM gym WHERE id = ?";
        Optional<Gym> theGym;

        try {
            theGym = Optional.of(jdbcTemplate.queryForObject(getGymByIdSQL, gymRowMapper, id));
            addManagerToGym(theGym);
            return theGym;
        } catch (IncorrectResultSizeDataAccessException e) {
            return Optional.empty();
        }
    }

    @Override
    public void add(Gym newGym) {
        String addGymSQL = "INSERT INTO gym (name, id, location, fee, is_approved) values (?, ?, ?, ?, ?)";
        jdbcTemplate.update(addGymSQL, newGym.getName(), newGym.getId(), newGym.getLocation(), newGym.getFee(), newGym.getIsApproved() ? '1' : '0');
    }

    @Override
    public List<Gym> getGymBySearch(String query) {
        String searchQuery = "%" + query + "%";
        String searchSQL = "SELECT * FROM gym WHERE name LIKE ?";
        return jdbcTemplate.query(searchSQL, gymRowMapper, searchQuery);
    }

    @Override
    public List<Member> getMembers() {
        String getMemberSQL = "SELECT * FROM member";
        return jdbcTemplate.query(getMemberSQL, memberRowMapper);
    }

    private void addManagerToGym(Optional<Gym> theGym) {
        String managerForGymSQL = "SELECT m.id, m.name, m.address, r.title FROM manager m JOIN manager_role r ON m.role_id = r.id WHERE m.gym_id = ?";
        List<Manager> managers = jdbcTemplate.query(managerForGymSQL, managerRowMapper, theGym.get().getId());
        theGym.get().setManagers(managers);
    }
}
