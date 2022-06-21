package Estudiante;

import Estudiante.Events.estudianteCreado;
import Estudiante.Events.suscripcionCreada;
import Estudiante.Entities.Suscripcion;
import Estudiante.Events.suscripcionEditada;
import Estudiante.Identities.EstudianteId;
import Estudiante.Identities.SuscripcionId;
import Estudiante.Values.Descripcion;
import Estudiante.Values.TipoSuscripcion;
import Genericos.Correo;
import Genericos.Fullname;
import Genericos.Identificacion;
import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.generic.DomainEvent;

import java.util.List;

public class Estudiante extends AggregateEvent<EstudianteId> {

    protected TipoSuscripcion tipoSuscripcion;
    protected Descripcion descripcion;
    protected SuscripcionId suscripcionId;
    protected Suscripcion suscripcion;

    public Estudiante(EstudianteId entityId){
        super(entityId);
        subscribe(new EstudianteChange(this));
    }

    public Estudiante(EstudianteId entityId, TipoSuscripcion tipoSuscripcion, Descripcion descripcion, SuscripcionId suscripcionId, Suscripcion suscripcion) {
        super(entityId);

    }

    public Estudiante(SuscripcionId suscripcionId, Descripcion descripcion, TipoSuscripcion tipoSuscripcion , Suscripcion suscripcion) {
        super(new EstudianteId());
        appendChange(new suscripcionCreada(tipoSuscripcion, descripcion, suscripcionId)).apply();


    }

    public Estudiante(SuscripcionId identity, Descripcion descripcion, TipoSuscripcion tipoSuscripcion) {
        super(new EstudianteId());
        appendChange(new suscripcionEditada(tipoSuscripcion, descripcion, identity )).apply();
    }

    public Estudiante(EstudianteId entityId, Correo correo, Fullname fullname, SuscripcionId suscripcionId, Identificacion identificacion) {
        super(entityId);
        appendChange(new estudianteCreado(entityId,correo,fullname,suscripcionId,identificacion)).apply();

    }

    public static Estudiante from(EstudianteId entityId, List<DomainEvent> events) {
        var estudiante = new Estudiante(entityId);
        events.forEach(estudiante::applyEvent);
        return estudiante;
    }


    public void crearSuscripcion(){
        appendChange(new suscripcionCreada(tipoSuscripcion, descripcion, suscripcionId)).apply();
    }

    public void editarSuscripcion(TipoSuscripcion tipoSuscripcion, Descripcion descripcion,  SuscripcionId identity){
        appendChange(new suscripcionEditada(tipoSuscripcion, descripcion, identity)).apply();
    }






}
