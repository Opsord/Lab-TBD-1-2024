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
        return institucionRepository.crear(institucion);
    }

    public List<InstitucionEntity> obtenerTodasLasInstituciones() {
        return institucionRepository.obtenerTodos();
    }

    public InstitucionEntity obtenerInstitucionPorId(long id) {
        return institucionRepository.obtenerPorId(id);
    }

    public boolean actualizarInstitucion(InstitucionEntity institucion) {
        return institucionRepository.actualizar(institucion);
    }

    public boolean eliminarInstitucion(long id) {
        return institucionRepository.eliminar(id);
    }
}
