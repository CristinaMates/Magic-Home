package ro.challenge.accepted.magichome.dao;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import ro.challenge.accepted.magichome.domain.Patient;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class PatientDAOImpl implements PatientDAO {

    private JdbcTemplate jdbcTemplate;

    public PatientDAOImpl (DataSource dataSource){
        jdbcTemplate = new JdbcTemplate(dataSource);

    }

    @Override
    public List<Patient> getAll() {
        return jdbcTemplate.query("select * from patient", new RowMapper<Patient>() {
            @Override
            public Patient mapRow(ResultSet resultSet, int i) throws SQLException {
                Patient result = new Patient();
                result.setFirstName(resultSet.getString(1));
                result.setLastName(resultSet.getString(2));
                result.setDisability(resultSet.getBoolean(3));
                result.setAge(resultSet.getInt(4));
                result.setDiagnosis(resultSet.getString(5));
                return result;
            }
        });
    }

    @Override
    public Patient create(Patient p) {
        jdbcTemplate.update("insert into patient(first_name, last_name, disability, age, diagnosis) values(?, ?, ?, ?, ?) returning id",
                p.getFirstName(), p.getLastName(), p.isDisability(), p.getAge(), p.getDiagnosis());
        return p;

    }
}
