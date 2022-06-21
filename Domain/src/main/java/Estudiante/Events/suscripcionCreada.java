package Estudiante.Events;

import Estudiante.Identities.SuscripcionId;
import Estudiante.Values.Descripcion;
import Estudiante.Values.TipoSuscripcion;
import co.com.sofka.domain.generic.DomainEvent;

public class suscripcionCreada extends DomainEvent {

    private  TipoSuscripcion tipoSuscripcion;
    private Descripcion descripcion;
    private SuscripcionId suscripcionId;

    public suscripcionCreada(TipoSuscripcion tipoSuscripcion, Descripcion descripcion, SuscripcionId suscripcionId){
        super("Sofka.Estudiante.suscripcionCreada");
        this.tipoSuscripcion=tipoSuscripcion;
    }

    public TipoSuscripcion getTipoSuscripcion() {
        return tipoSuscripcion;
    }

    public Descripcion getDescripcion() {
        return descripcion;
    }

    public SuscripcionId getSuscripcionId() {
        return suscripcionId;
    }
}
