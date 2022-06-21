package Estudiante.Entities;

import Estudiante.Identities.SuscripcionId;
import Estudiante.Values.Descripcion;
import Estudiante.Values.TipoSuscripcion;
import co.com.sofka.domain.generic.Entity;

import java.util.Objects;

public class Suscripcion extends Entity<SuscripcionId> {
    private  Descripcion descripcion;
    private TipoSuscripcion tipoSuscripcion;

    private SuscripcionId suscripcionId;

    public Suscripcion(SuscripcionId entityId , Descripcion descripcion, TipoSuscripcion tipoSuscripcion) {
        super(entityId);
        this.descripcion= descripcion;
        this.tipoSuscripcion = tipoSuscripcion;
    }

    public Suscripcion(SuscripcionId entityId) {
        super(entityId);
    }

    public void crearSuscripcion(SuscripcionId suscripcionId ,Descripcion descripcion ,TipoSuscripcion tipoSuscripcion){
        this.descripcion= descripcion;
        this.tipoSuscripcion=tipoSuscripcion;
        this.suscripcionId=suscripcionId;
    }
}
