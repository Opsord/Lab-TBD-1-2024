package G1TBD.LABTBD.repositories;

import G1TBD.LABTBD.entities.InstitucionEntity;

import java.util.List;

public interface InstitucionRepository {

    InstitucionEntity crearInstitucion(InstitucionEntity institucion);

    List<InstitucionEntity> obtenerTodasLasInstituciones();

    InstitucionEntity obtenerInstitucionPorId(long id);

    boolean actualizarInstitucion(InstitucionEntity institucion);

    boolean eliminarInstitucion(long id);
}
