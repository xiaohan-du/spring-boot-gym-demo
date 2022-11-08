package gymDemo.gym.data;

import gymDemo.gym.domain.Gym;
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

    public GymRepositoryImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
        setGymRowMapper();
    }

    private void setGymRowMapper() {
        gymRowMapper = (rm, index) -> new Gym(
                rm.getString("name"),
                rm.getString("id"),
                rm.getString("location"),
                rm.getDouble("fee"),
                (rm.getString("is_approved").equals("1")) ? Boolean.TRUE : Boolean.FALSE
        );
    }

    @Override
    public List<Gym> getGyms() {
        String getGymsSQL = "SELECT * FROM gym";
        return jdbcTemplate.query(getGymsSQL, gymRowMapper);
    }

    @Override
    public Optional<Gym> getGymById(String id) {
        String getGymByCodeSQL = "SELECT * FROM gym WHERE id = ?";
        try {
            return Optional.of(jdbcTemplate.queryForObject(getGymByCodeSQL, gymRowMapper, id));
        } catch (IncorrectResultSizeDataAccessException e) {
            return Optional.empty();
        }
    }

    @Override
    public void add(Gym newGym) {
        String addGymSQL = "INSERT INTO gym (name, id, location, fee, is_approved) values (?, ?, ?, ?, ?)";
        jdbcTemplate.update(addGymSQL, newGym.getName(), newGym.getId(), newGym.getLocation(), newGym.getFee(), newGym.getIsApproved() ? '1' : '0');
    }
}
