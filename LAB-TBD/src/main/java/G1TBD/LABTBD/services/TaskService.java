package G1TBD.LABTBD.services;

import G1TBD.LABTBD.entities.TaskEntity;
import G1TBD.LABTBD.repositories.TaskRepositoryImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {

    @Autowired
    TaskRepositoryImp taskRepository;

    public TaskEntity create(TaskEntity task) {
        return taskRepository.create(task);
    }

    public List<TaskEntity> getAll() {
        return taskRepository.getAll();
    }

    public TaskEntity getById(long id) {
        return taskRepository.getById(id);
    }

    public List<TaskEntity> getByEmergencyId(long id) {
        return taskRepository.getByEmergencyId(id);
    }

    public boolean update(TaskEntity task) {
        return taskRepository.update(task);
    }

    public boolean delete(long id) {
        return taskRepository.delete(id);
    }

}
