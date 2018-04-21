package ro.challenge.accepted.magichome.dao;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import ro.challenge.accepted.magichome.domain.Custodian;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class CustodianDAOImpl implements CustodianDAO {

    private JdbcTemplate jdbcTemplate;

    private CustodianDAOImpl(DataSource dataSource){
        jdbcTemplate = new JdbcTemplate(dataSource);
    }
    @Override
    public List<Custodian> getAll() {
        return jdbcTemplate.query("select * from custodians", new RowMapper<Custodian>() {
            @Override
            public Custodian mapRow(ResultSet resultSet, int i) throws SQLException {

                Custodian result = new Custodian();

                result.setFirstName(resultSet.getString(1));
                result.setLastName(resultSet.getString(2));
               // result.se

                return result;
            }
        });
    }

    @Override
    public Custodian create(Custodian c) {
        return null;
    }
}
