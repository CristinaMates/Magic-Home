package ro.challenge.accepted.magichome.dao;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import ro.challenge.accepted.magichome.domain.Doctor;
import ro.challenge.accepted.magichome.domain.Patient;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class PatientDAOImpl implements PatientDAO {

    public static final RowMapper<Patient> PATIENT_ROW_MAPPER = new RowMapper<Patient>() {
        @Override
        public Patient mapRow(ResultSet resultSet, int i) throws SQLException {
            Patient result = new Patient();
               result.setFirstName(resultSet.getString("first_name"));
                result.setLastName(resultSet.getString("last_name"));
                result.setDisability(resultSet.getBoolean("disability"));
                result.setAge(resultSet.getInt("age"));
                result.setDiagnosis(resultSet.getString("diagnosis"));
                result.setDoctorId(resultSet.getLong("doctor_id"));
                result.setId(resultSet.getLong("id"));
                return result;
            }

    };
    private JdbcTemplate jdbcTemplate;


    public PatientDAOImpl(DataSource dataSource) {

        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public List<Patient> getAll() {

        return jdbcTemplate.query("select * from patient", PATIENT_ROW_MAPPER);
    }



    @Override
    public Patient create(Patient patient) {
        long newPatientId =  jdbcTemplate.queryForObject("insert into patient(first_name, last_name, disability, age, diagnosis, doctor_id) values(?, ?, ?, ?, ?, ?) returning id",

                new RowMapper<Long>() {
                    @Override
                    public Long mapRow(ResultSet resultSet, int i) throws SQLException {
                        return resultSet.getLong(1);
                    }
                }, patient.getFirstName(), patient.getLastName(), patient.isDisability(), patient.getAge(), patient.getDiagnosis(), patient.getDoctor().getId());


        patient.setId(newPatientId);

        return patient;
    }

    @Override
    public Patient findById(long id) {
        return jdbcTemplate.queryForObject("select * from patient where id = ?",

                PATIENT_ROW_MAPPER, id);
    }

//    private JdbcTemplate jdbcTemplate;
//
//    public PatientDAOImpl (DataSource dataSource){
//        jdbcTemplate = new JdbcTemplate(dataSource);
//
//    }
//
//    @Override
//    public List<Patient> getAll() {
//        return jdbcTemplate.query("select * from patient", new RowMapper<Patient>() {
//            @Override
//            public Patient mapRow(ResultSet resultSet, int i) throws SQLException {
//                Patient result = new Patient();
//                result.setFirstName(resultSet.getString("first_name"));
//                result.setLastName(resultSet.getString("last_name"));
//                result.setDisability(resultSet.getBoolean("disability"));
//                result.setAge(resultSet.getInt("age"));
//                result.setDiagnosis(resultSet.getString("diagnosis"));
//                result.setDoctorId(resultSet.getLong("doctor_id"));
//                return result;
//            }
//        });
//    }
//
//    @Override
//    public Patient create(Patient p) {
//        long newDoctorId =  jdbcTemplate.queryForObject("insert into patient(first_name, last_name, disability, age, diagnosis, doctor_id) values(?, ?, ?, ?, ?, ?) returning id",
//                new RowMapper<Long>() {
//                    @Override
//                    public Long mapRow(ResultSet resultSet, int i) throws SQLException {
//
//                        return resultSet.getLong(1);
//                    }
//                },  p.getFirstName(), p.getLastName(), p.isDisability(), p.getAge(), p.getDiagnosis());
//
//
//        p.setId(newDoctorId);
//
//        return p;
//
//    }
//
//    @Override
//    public Patient findById(long id) {
//        return jdbcTemplate.queryForObject("select * from patient where id = ?",
//
//                PATIENT_ROW_MAPPER, id);
//    }
}
