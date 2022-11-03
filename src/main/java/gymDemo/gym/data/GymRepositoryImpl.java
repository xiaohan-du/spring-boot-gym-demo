package gymDemo.gym.data;

import gymDemo.gym.domain.Gym;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
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
}
