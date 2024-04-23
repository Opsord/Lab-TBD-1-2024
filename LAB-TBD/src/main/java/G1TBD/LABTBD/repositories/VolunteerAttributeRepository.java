package G1TBD.LABTBD.repositories;

import G1TBD.LABTBD.entities.VolunteerAttributeEntity;

import java.util.List;

public interface VolunteerAttributeRepository {

    VolunteerAttributeEntity create(VolunteerAttributeEntity volunteerAttribute);

    List<VolunteerAttributeEntity> getAll();

    VolunteerAttributeEntity getById(long id);

    boolean update(VolunteerAttributeEntity volunteerAttribute);

    boolean delete(long id);
}
