package G1TBD.LABTBD.services;

import G1TBD.LABTBD.entities.VolunteerEntity;
import G1TBD.LABTBD.repositories.VolunteerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VolunteerService {

    @Autowired
    private VolunteerRepository volunteerRepository;

    public VolunteerEntity create(VolunteerEntity volunteer) {
        return volunteerRepository.create(volunteer);
    }

    public List<VolunteerEntity> getAll() {
        return volunteerRepository.getAll();
    }

    public VolunteerEntity getByRut(String rut) {
        return volunteerRepository.getByRut(rut);
    }

    public VolunteerEntity getByEmail(String email) {
        return volunteerRepository.getByEmail(email);
    }

    public VolunteerEntity getById(long id) {
        return volunteerRepository.getById(id);
    }

    public boolean update(VolunteerEntity volunteer) {
        return volunteerRepository.update(volunteer);
    }

    public boolean delete(String rut) {
        return volunteerRepository.delete(rut);
    }

    public List<VolunteerEntity> getByEmergencyId(long id){return volunteerRepository.getByEmergencyId(id);}
}
