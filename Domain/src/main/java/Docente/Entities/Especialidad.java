package Docente.Entities;

import Docente.Identities.EspecialidadId;
import Docente.Values.tipoEspecialidad;
import co.com.sofka.domain.generic.Entity;

import java.util.Objects;

public class Especialidad extends Entity<EspecialidadId> {

    private tipoEspecialidad tipoEspecialidad;

    public Especialidad(EspecialidadId entityId) {
        super(entityId);
        this.tipoEspecialidad = tipoEspecialidad;
    }


    // Comportamientos
     public void crearEspecialidad(tipoEspecialidad tipoEspecialidad){
        this.tipoEspecialidad= Objects.requireNonNull(tipoEspecialidad);
     }

    public tipoEspecialidad TipoEspecialidad() {
        return tipoEspecialidad;
    }
}
