package G1TBD.LABTBD.repositories;
import G1TBD.LABTBD.entities.VolunteerEntity;

import java.util.List;

public interface VolunteerRepository {

    VolunteerEntity create(VolunteerEntity volunteer);

    List<VolunteerEntity> getAll();

    VolunteerEntity getByRut(String rut);

    VolunteerEntity getByEmail(String email);

    VolunteerEntity getById(long id);

    boolean update(VolunteerEntity volunteer);

    boolean delete(String rut);

    List<VolunteerEntity> getByEmergencyId(long idEmergency);

}
