package Curso.Entities;

import Curso.Identitis.ValoracionesId;
import Curso.Values.Descripcion;
import Curso.Values.Fecha;
import Docente.Identities.EspecialidadId;
import Docente.Values.tipoEspecialidad;
import co.com.sofka.domain.generic.Entity;

import java.util.Objects;

public class Valoraciones extends Entity<ValoracionesId> {

    private Fecha fecha;
    private Descripcion descripcion;

    public Valoraciones(ValoracionesId entityId, Fecha fecha,Descripcion descripcion) {
        super(entityId);
      this.fecha=fecha;
      this.descripcion=descripcion;
    }

}
