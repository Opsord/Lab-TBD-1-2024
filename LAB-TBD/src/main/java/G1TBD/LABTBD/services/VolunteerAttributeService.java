package G1TBD.LABTBD.services;

import G1TBD.LABTBD.entities.VolunteerAttributeEntity;
import G1TBD.LABTBD.repositories.VolunteerAttributeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VolunteerAttributeService {

    @Autowired
    private VolunteerAttributeRepository volunteerAttributeRepository;

    public VolunteerAttributeEntity create(VolunteerAttributeEntity volunteerAttribute) {
        return volunteerAttributeRepository.create(volunteerAttribute);
    }

    public List<VolunteerAttributeEntity> getAll() {
        return volunteerAttributeRepository.getAll();
    }

    public VolunteerAttributeEntity getById(long id) {
        return volunteerAttributeRepository.getById(id);
    }

    public boolean update(VolunteerAttributeEntity volunteerAttribute) {
        return volunteerAttributeRepository.update(volunteerAttribute);
    }

    public boolean delete(long id) {
        return volunteerAttributeRepository.delete(id);
    }
}
