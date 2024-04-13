package G1TBD.LABTBD.repositories;
import G1TBD.LABTBD.entities.VoluntarioEntity;

public interface VoluntarioRepository {

    void create(VoluntarioEntity voluntario);

    VoluntarioEntity conseguirPorId(Integer id);

    void update(VoluntarioEntity voluntario);

    void delete(Integer id);

}
