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
                result.setCustodianID(resultSet.getLong(1));
                result.setPatientID(resultSet.getLong(2));
                result.setNumberOfCustodians(resultSet.getInt(3));
                result.setDoctorID(resultSet.getLong(4));
                result.setEntranceDate(resultSet.getDate(5));
                result.setDays(resultSet.getInt(6));
                result.setNeedsPsychologicalCounseling(resultSet.getBoolean(7));
                return result;
            }
        });
    }

    @Override
    public Reservation create(Reservation reservation) {
        long newClientId = jdbcTemplate.queryForObject("insert into reservation(custodianID, patientID, numberOfCustodians, doctorID, entranceDate, days, needsPsychologicalCounseling) values(?, ?, ?, ?, ?, ?, ?, ?) returning id",
                new RowMapper<Long>() {
                    @Override
                    public Long mapRow(ResultSet resultSet, int i) throws SQLException {

                        return resultSet.getLong(1);
                    }
                }, reservation.getCustodianID(),
                reservation.getPatientID(), reservation.getNumberOfCustodians(), reservation.getDoctorID(), reservation.getEntranceDate(), reservation.getDays(), reservation.isNeedsPsychologicalCounseling());

        return reservation;