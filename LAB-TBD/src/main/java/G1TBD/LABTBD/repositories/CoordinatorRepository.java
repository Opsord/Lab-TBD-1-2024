package G1TBD.LABTBD.repositories;

import G1TBD.LABTBD.entities.CoordinatorEntity;

import java.util.List;

public interface CoordinatorRepository {

    CoordinatorEntity create(CoordinatorEntity coordinator);

    List<CoordinatorEntity> getAll();

    CoordinatorEntity getByRut(String rut);

    CoordinatorEntity getByEmail(String email);

    boolean update(CoordinatorEntity coordinator);

    boolean delete(String rut);
}
