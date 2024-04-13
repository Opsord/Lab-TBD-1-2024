package G1TBD.LABTBD.repositories;

import G1TBD.LABTBD.entities.TareaEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import java.util.List;

@Repository
public class TareaRepository {
    @Autowired
    private Sql2o sql2o;

    public List<TareaEntity> obtenerTodasLasTareas() {
        try(Connection conn = sql2o.open()) {
            return conn.createQuery("SELECT * FROM TareaEntity ORDER BY idTarea ASC")
                    .executeAndFetch(TareaEntity.class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
}
