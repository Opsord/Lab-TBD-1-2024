package G1TBD.LABTBD.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.sql2o.Sql2o;

@Configuration
public class DatabaseContext {
    @Value("${spring.datasource.url}")
    private String dbUrl;

    @Value("lab1tbd")
    private String dbUser;

    @Value("12345678")
    private String dbPassword;

    @Bean
    public Sql2o sql2o(){
        return new Sql2o(dbUrl,dbUser,dbPassword);
    }
}
