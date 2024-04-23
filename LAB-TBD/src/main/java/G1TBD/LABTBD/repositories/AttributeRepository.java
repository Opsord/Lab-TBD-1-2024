package G1TBD.LABTBD.repositories;

import G1TBD.LABTBD.entities.AttributeEntity;

import java.util.List;

public interface AttributeRepository {

    AttributeEntity create(AttributeEntity attribute);

    List<AttributeEntity> getAll();

    AttributeEntity getById(long id);

    boolean update(AttributeEntity attribute);

    boolean delete(long id);
}