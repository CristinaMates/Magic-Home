package ro.challenge.accepted.magichome.dao;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import ro.challenge.accepted.magichome.domain.Doctor;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class DBDoctorDAO implements DoctorDAO{

    public static final RowMapper<Doctor> DOCTOR_ROW_MAPPER = new RowMapper<Doctor>() {
        @Override
        public Doctor mapRow(ResultSet resultSet, int i) throws SQLException {
            Doctor result = new Doctor();
            result.setFirstName(resultSet.getString("first_name"));
            result.setLastName(resultSet.getString("last_name"));

            return result;
        }
    };
    private JdbcTemplate jdbcTemplate;


    public DBDoctorDAO(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public List<Doctor> getAll() {
        return jdbcTemplate.query("select * from doctor", DOCTOR_ROW_MAPPER);
    }

    @Override
    public Doctor create(Doctor doctor) {
        long newDoctorId =  jdbcTemplate.queryForObject("insert into doctor(first_name, last_name) values(?, ?)",
                new RowMapper<Long>() {
                    @Override
                    public Long mapRow(ResultSet resultSet, int i) throws SQLException {

                        return resultSet.getLong(1);
                    }
                }, doctor.getFirstName(), doctor.getLastName());


        doctor.setId(newDoctorId);

//        if (true) {
//            throw new RuntimeException("Force rollback");
//        }
        return doctor;
    }

    @Override
    public Doctor findById(long id) {
        return jdbcTemplate.queryForObject("select * from doctor where id = ?",

                DOCTOR_ROW_MAPPER, id);
    }
}
