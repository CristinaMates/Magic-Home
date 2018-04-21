package ro.challenge.accepted.magichome.dao;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import ro.challenge.accepted.magichome.domain.Patient;
import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class PatientDAOImpl implements PatientDAO {

    public static final RowMapper<Patient> CLIENT_ROW_MAPPER = new RowMapper<Patient>() {
        @Override
        public Patient mapRow(ResultSet resultSet, int i) throws SQLException {
            Patient result = new Patient();
            result.setFirstName(resultSet.getString("first_name"));
            result.setPatientLastName(resultSet.getString("last_name"));
            result.setDisability(resultSet.getBoolean("disability"));
            result.setAge(resultSet.getInt("age"));
            result.setDiagnosis(resultSet.getString("diagnosis"));
            return result;
        }
    };
    private JdbcTemplate jdbcTemplate;


    public PatientDAOImpl(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public List<Patient> getAll() {
        return jdbcTemplate.query("select * from patient", CLIENT_ROW_MAPPER);
    }


    @Override
    public Patient create(Patient p) {
        long newPatientId =  jdbcTemplate.queryForObject("insert into patient(first_name, last_name, disability, age, diagnosis, doctor_id) values (?, ?, ?, ?, ?, ?) returning id",
                new RowMapper<Long>() {
                    @Override
                    public Long mapRow(ResultSet resultSet, int i) throws SQLException {

                        return resultSet.getLong(1);
                    }
                }, p.getFirstName(), p.getPatientLastName(),
                p.isDisability(), p.getAge(), p.getDiagnosis(), p.getDoctorId());

        p.setId(newPatientId);

//        if (true) {
//            throw new RuntimeException("Force rollback");
//        }
        return p;
    }
}
