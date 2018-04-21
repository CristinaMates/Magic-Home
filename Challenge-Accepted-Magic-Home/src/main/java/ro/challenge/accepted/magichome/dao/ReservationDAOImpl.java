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
                result.setId(resultSet.getInt("id"));
                result.setCustodianID(resultSet.getLong("custodianID"));
                result.setPatientID(resultSet.getLong("patientID"));
                result.setNumberOfCustodians(resultSet.getInt("numberOfCustodians"));
                result.setDoctorID(resultSet.getLong("doctorID"));
                result.setEntranceDate(resultSet.getDate("entranceDate"));
                result.setDays(resultSet.getInt("days"));
                result.setNeedsPsychologicalCounseling(resultSet.getBoolean("needsPsychologicalCounseling"));
                return result;
            }
        });
    }

    @Override
    public Reservation create(Reservation reservation) {
        long newClientId = jdbcTemplate.queryForObject("insert into reservation(custodianID, patientID, numberOfCustodians, doctorID, entranceDate, days, needsPsychologicalCounseling) values(?, ?, ?, ?, ?, ?, ?) returning id",
                new RowMapper<Long>() {
                    @Override
                    public Long mapRow(ResultSet resultSet, int i) throws SQLException {

                        return resultSet.getLong(1);
                    }
                }, reservation.getCustodian().getId(),
                reservation.getPatient().getId(), reservation.getNumberOfCustodians(), reservation.getDoctor().getId(), reservation.getEntranceDate(), reservation.getDays(), reservation.isNeedsPsychologicalCounseling());

        reservation.setId(newClientId);
        return reservation;
    }
}