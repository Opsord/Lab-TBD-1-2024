package G1TBD.LABTBD.repositories;

import G1TBD.LABTBD.entities.EmergencyAttributeEntity;

import java.util.List;

public interface EmergencyAttributeRepository {

    EmergencyAttributeEntity create(EmergencyAttributeEntity emergencyAttribute);

    List<EmergencyAttributeEntity> getAll();

    EmergencyAttributeEntity getById(long id);

    boolean update(EmergencyAttributeEntity emergencyAttribute);

    boolean delete(long id);
}
