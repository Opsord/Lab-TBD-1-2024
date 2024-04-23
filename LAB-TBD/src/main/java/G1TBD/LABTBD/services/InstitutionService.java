package G1TBD.LABTBD.services;

import G1TBD.LABTBD.entities.InstitutionEntity;
import G1TBD.LABTBD.repositories.InstitutionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InstitutionService {

    @Autowired
    private InstitutionRepository institutionRepository;

    public InstitutionEntity create(InstitutionEntity institution) {
        return institutionRepository.create(institution);
    }

    public List<InstitutionEntity> getAll() {
        return institutionRepository.getAll();
    }

    public InstitutionEntity getById(long id) {
        return institutionRepository.getById(id);
    }

    public boolean update(InstitutionEntity institution) {
        return institutionRepository.update(institution);
    }

    public boolean delete(long id) {
        return institutionRepository.delete(id);
    }
}
