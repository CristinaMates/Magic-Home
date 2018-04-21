package ro.challenge.accepted.magichome;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.SingleConnectionDataSource;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.TransactionManagementConfigurer;
import ro.challenge.accepted.magichome.dao.PatientDAO;
import ro.challenge.accepted.magichome.dao.PatientDAOImpl;

import javax.sql.DataSource;

@EnableTransactionManagement
@Configuration
public class ApplicationConfiguration implements TransactionManagementConfigurer {

    @Bean
    PatientDAO patientDAO(){
        return new PatientDAOImpl(dataSource());
    }

    @Bean
    public DataSource dataSource() {
        String url = new StringBuilder()
                .append("jdbc:")
                .append("postgresql")
                .append("://")
                .append("localhost")
                .append(":")
                .append("5432")
                .append("/")
                .append("magic-home")
                .append("?user=")
                .append("postgres")
                .append("&password=")
                .append("test").toString();

        return  new SingleConnectionDataSource(url, false);
    }
    @Bean(name="txn")
    public DataSourceTransactionManager txName() {
        return new DataSourceTransactionManager(dataSource());
    }

    @Override
    public PlatformTransactionManager annotationDrivenTransactionManager() {
        return txName();
    }
}
