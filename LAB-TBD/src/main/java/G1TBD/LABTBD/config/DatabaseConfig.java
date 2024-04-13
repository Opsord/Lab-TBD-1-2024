package G1TBD.LABTBD.config;

import org.springframework.context.annotation.Configuration;
import org.sql2o.Sql2o;

@Configuration
public class DatabaseConfig {

    private static Sql2o sql2o;

    static{
        sql2o = new Sql2o("jdbc:mysql://localhost:3306/LabTBD-1-2024", "postgres", "1502");
    }
}
