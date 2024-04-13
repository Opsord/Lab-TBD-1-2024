package G1TBD.LABTBD.repositories;

import G1TBD.LABTBD.entities.InstitucionEntity;

import java.util.List;

public interface InstitucionRepository {

    InstitucionEntity crearInstitucion(InstitucionEntity institucion);

    public List<InstitucionEntity> obtenerTodasLasInstituciones(InstitucionEntity institucion);

    void actualizarInstitucion(InstitucionEntity institucion);

    void eliminarInstitucion(long id);
}
