package G1TBD.LABTBD.repositories;

import G1TBD.LABTBD.entities.InstitucionEntity;

import java.util.List;

public interface InstitucionRepository {

    InstitucionEntity crearInstitucion(InstitucionEntity institucion);

    List<InstitucionEntity> obtenerTodasLasInstituciones(InstitucionEntity institucion);

    InstitucionEntity obtenerInstitucionPorId(long id);

    void actualizarInstitucion(InstitucionEntity institucion);

    void eliminarInstitucion(long id);
}
