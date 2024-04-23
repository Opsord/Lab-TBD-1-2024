package G1TBD.LABTBD.repositories;

import G1TBD.LABTBD.entities.TaskEntity;

import java.util.List;

public interface TaskRepository {

    TaskEntity create(TaskEntity task);

    List<TaskEntity> getAll();

    TaskEntity getById(long id);

    boolean update(TaskEntity task);

    boolean delete(long id);

    List<TaskEntity> getByEmergencyId(long idEmergency);
}
