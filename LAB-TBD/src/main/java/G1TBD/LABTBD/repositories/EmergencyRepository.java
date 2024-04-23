package G1TBD.LABTBD.repositories;

import G1TBD.LABTBD.entities.EmergencyEntity;

import java.util.List;

public interface EmergencyRepository {

    EmergencyEntity create(EmergencyEntity emergency);

    List<EmergencyEntity> getAll();

    EmergencyEntity getById(long id);
    
    List<EmergencyEntity> getAllActive();

    boolean update(EmergencyEntity emergency);

    boolean delete(long id);

    List<EmergencyEntity> getClosedEmergencies();
}

