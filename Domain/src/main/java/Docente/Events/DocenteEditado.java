package Docente.Events;

import Docente.Entities.Especialidad;
import Docente.Identities.DocenteId;
import Docente.Values.Correo;
import Docente.Values.Fullname;
import Docente.Values.Identificacion;
import co.com.sofka.domain.generic.DomainEvent;


public class DocenteEditado extends DomainEvent {
    private Correo correo;
    private Fullname fullname;
    private Identificacion identificacion;
    private DocenteId docenteId;

    private Especialidad especialidad;

   public DocenteEditado (DocenteId docenteId, Correo correo,Fullname fullname,Identificacion identificacion){
       super("Sofka.Docente.DocenteEditado");
       this.docenteId=docenteId;
       this.correo=correo;
       this.fullname=fullname;
       this.identificacion=identificacion;

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

    public DocenteId getDocenteId() {
        return docenteId;
    }


}
