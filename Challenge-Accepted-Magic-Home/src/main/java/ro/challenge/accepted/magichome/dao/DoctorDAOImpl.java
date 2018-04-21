package ro.challenge.accepted.magichome.dao;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import ro.challenge.accepted.magichome.domain.Doctor;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class DoctorDAOImpl implements DoctorDAO{

    private JdbcTemplate jdbcTemplate;

    private DoctorDAOImpl (DataSource dataSource){
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public List<Doctor> getAll() {
        return jdbcTemplate.query("select * from doctors", new RowMapper<Doctor>() {
            @Override
            public Doctor mapRow(ResultSet resultSet, int i) throws SQLException {

                Doctor result = new Doctor();

                result.setFirstName(resultSet.getString(1));
                result.setLastName(resultSet.getString(2));

                return result;
            }
        });
    }

    @Override
    public Doctor create(Doctor doctor) {
        jdbcTemplate.update("inset into doctors(first_name, last_name)" + " value(?, ?) returning id");
        doctor.getId();
        return doctor;
    }
}
