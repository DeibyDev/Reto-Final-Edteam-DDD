package Estudiante.Events;

import Estudiante.Identities.EstudianteId;
import Estudiante.Identities.SuscripcionId;
import Genericos.Correo;
import Genericos.Fullname;
import Genericos.Identificacion;
import co.com.sofka.domain.generic.DomainEvent;

public class estudianteCreado extends DomainEvent {

    private SuscripcionId suscripcionId;
    private Correo correo;
    private Fullname fullname;
    private Identificacion identificacion;
    private EstudianteId estudianteId;


    public estudianteCreado(EstudianteId estudianteId, Correo correo , Fullname fullname , SuscripcionId suscripcionId
            ,Identificacion identificacion){
        super("Sofka.Estudiante.estudianteCreado");
        this.correo=correo;
        this.fullname=fullname;
        this.estudianteId=estudianteId;
        this.suscripcionId=suscripcionId;
        this.identificacion=identificacion;

    }

    public SuscripcionId getSuscripcionId() {
        return suscripcionId;
    }

    public Correo getCorreo() {
        return correo;
    }

    public Fullname getFullname() {
        return fullname;
    }

    public Identificacion getIdentificacion() {
        return identificacion;
    }

    public EstudianteId getEstudianteId() {
        return estudianteId;
    }
}
