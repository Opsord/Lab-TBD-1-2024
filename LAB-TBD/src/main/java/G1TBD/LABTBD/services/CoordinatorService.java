package G1TBD.LABTBD.services;

import G1TBD.LABTBD.entities.CoordinatorEntity;
import G1TBD.LABTBD.repositories.CoordinatorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CoordinatorService {

    @Autowired
    private CoordinatorRepository coordinatorRepository;

    public CoordinatorEntity create(CoordinatorEntity coordinator) {
        return coordinatorRepository.create(coordinator);
    }

    public List<CoordinatorEntity> getAll() {
        return coordinatorRepository.getAll();
    }

    public CoordinatorEntity getByRut(String rut) {
        return coordinatorRepository.getByRut(rut);
    }

    public CoordinatorEntity getByEmail(String email) {
        return coordinatorRepository.getByEmail(email);
    }

    public boolean update(CoordinatorEntity coordinator) {
        return coordinatorRepository.update(coordinator);
    }

    public boolean delete(String rut) {
        return coordinatorRepository.delete(rut);
    }
}
