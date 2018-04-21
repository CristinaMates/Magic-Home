package ro.challenge.accepted.magichome.dao;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import ro.challenge.accepted.magichome.domain.Custodian;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class CustodianDAOImpl implements CustodianDAO {

    public static final RowMapper<Custodian> CUSTODIAN_ROW_MAPPER = new RowMapper<Custodian>() {
        @Override
        public Custodian mapRow(ResultSet resultSet, int i) throws SQLException {
            Custodian result = new Custodian();
            result.setFirstName(resultSet.getString("first_name"));
            result.setLastName(resultSet.getString("last_name"));
            result.setTelephone(resultSet.getString("telephone"));
            result.setId(resultSet.getLong("id"));

            return result;
        }
    };
    private JdbcTemplate jdbcTemplate;


    public CustodianDAOImpl(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public List<Custodian> getAll() {
        return jdbcTemplate.query("select * from custodian", CUSTODIAN_ROW_MAPPER);
    }

    @Override
    public Custodian create(Custodian custodian) {
        long newCustodianId = jdbcTemplate.queryForObject("insert into custodian(first_name, last_name, telephone) values(?, ?, ?) returning id",
                new RowMapper<Long>() {
                    @Override
                    public Long mapRow(ResultSet resultSet, int i) throws SQLException {

                        return resultSet.getLong(1);
                    }
                }, custodian.getFirstName(), custodian.getLastName(),
                custodian.getTelephone());

        custodian.setId(newCustodianId);

//        if (true) {
//            throw new RuntimeException("Force rollback");
//        }
        return custodian;
    }

    @Override
    public Custodian findById(long id) {
        return jdbcTemplate.queryForObject("select * from custodian where id = ?",

                CUSTODIAN_ROW_MAPPER,    id);
    }
}
