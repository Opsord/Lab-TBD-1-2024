package G1TBD.LABTBD.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.sql2o.Sql2o;

@Configuration
public class DatabaseConfig {
    @Value("jdbc:postgresql://localhost:5432/LabTBD-1-2024")
    private String dbUrl;

    @Value("postgres")
    private String dbUser;

    @Value("12345678")
    private String dbPass;

    @Bean
    public Sql2o sql2o() {
        return new Sql2o(dbUrl, dbUser, dbPass);
    }
}
