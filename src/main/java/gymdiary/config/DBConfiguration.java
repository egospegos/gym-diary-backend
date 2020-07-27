package gymdiary.config;

import org.mariadb.jdbc.MariaDbDataSource;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.sql.SQLException;

@Configuration
public class DBConfiguration {
    @Bean
    public DataSource mysqlDataSource() throws SQLException {
        MariaDbDataSource mdb = new MariaDbDataSource();
        mdb.setUserName("root");
        mdb.setPassword("123");
        mdb.setUrl("jdbc:mariadb://localhost:3306/gymdiary?createDatabaseIfNotExist=true");
        return mdb;
    }
}
