package G1TBD.LABTBD.services;

import G1TBD.LABTBD.entities.InstitucionEntity;
import G1TBD.LABTBD.repositories.InstitucionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InstitucionService {

    @Autowired
    private InstitucionRepository institucionRepository;

    public InstitucionEntity crearInstitucion(InstitucionEntity institucion) {
        return institucionRepository.crearInstitucion(institucion);
    }

    public List<InstitucionEntity> obtenerTodasLasInstituciones() {
        return institucionRepository.obtenerTodasLasInstituciones();
    }

    public InstitucionEntity obtenerInstitucionPorId(long id) {
        return institucionRepository.obtenerInstitucionPorId(id);
    }

    public boolean actualizarInstitucion(InstitucionEntity institucion) {
        return institucionRepository.actualizarInstitucion(institucion);
    }

    public boolean eliminarInstitucion(long id) {
        return institucionRepository.eliminarInstitucion(id);
    }
}
