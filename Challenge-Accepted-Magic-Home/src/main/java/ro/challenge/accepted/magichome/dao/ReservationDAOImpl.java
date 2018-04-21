package ro.challenge.accepted.magichome.dao;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import ro.challenge.accepted.magichome.domain.Reservation;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class ReservationDAOImpl implements ReservationDAO {
    private JdbcTemplate jdbcTemplate;

    public ReservationDAOImpl(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }


    @Override
    public List<Reservation> getAll() {
        return jdbcTemplate.query("select * from reservation", new RowMapper<Reservation>() {
            @Override
            public Reservation mapRow(ResultSet resultSet, int i) throws SQLException {
                Reservation result = new Reservation();
                result.setId(resultSet.getInt(1));
                result.setNumberOfCustodians(resultSet.getInt(2));
                result.setEntranceDate(resultSet.getDate(3));
                result.setDays(resultSet.getInt(4));
                result.setNeedsPsychologicalCounseling(resultSet.getBoolean(5));
                return result;
            }
        });
    }

    @Override
    public Reservation create(Reservation c) {
        jdbcTemplate.update("insert into reservation ()");
        return null;
    }
}
