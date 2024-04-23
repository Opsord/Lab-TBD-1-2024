package G1TBD.LABTBD.repositories;

import G1TBD.LABTBD.entities.InstitutionEntity;

import java.util.List;

public interface InstitutionRepository {

    InstitutionEntity create(InstitutionEntity institucion);

    List<InstitutionEntity> getAll();

    InstitutionEntity getById(long id);

    boolean update(InstitutionEntity institucion);

    boolean delete(long id);
}
