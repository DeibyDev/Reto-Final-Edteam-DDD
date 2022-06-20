package Docente;

import Docente.Entities.Especialidad;
import Docente.Events.DocenteCreado;
import Docente.Events.DocenteEditado;
import Docente.Identities.DocenteId;
import Docente.Values.Correo;
import Docente.Values.Fullname;
import Docente.Values.Identificacion;
import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.generic.DomainEvent;

import java.util.List;

public class Docente extends AggregateEvent<DocenteId> {

    protected Correo correo;
    protected Fullname fullname;
    protected Identificacion identificacion;
    protected Especialidad especialidad;

    public Docente(DocenteId entityId){
        super(entityId);
        subscribe(new DocenteChange(this));
    }

    public Docente(DocenteId docenteId, Correo correo, Fullname fullname, Identificacion identificacion) {
        super(docenteId);
        appendChange(new DocenteEditado(docenteId,correo,fullname,identificacion)).apply();
    }

    public static Docente from(DocenteId entityId, List<DomainEvent> events) {
        var docente = new Docente(entityId);
        events.forEach(docente::applyEvent);
        return docente;
    }



    public Docente(DocenteId docenteId , Correo correo,Fullname fullname,Identificacion identificacion , Especialidad especialidad){
        super(docenteId);
        appendChange(new DocenteCreado(correo,fullname,identificacion,especialidad)).apply();

    }
    public void editarDocente(DocenteId docenteId, Correo correo,Fullname fullname,Identificacion identificacion) {
        appendChange(new DocenteEditado(docenteId,correo, fullname, identificacion)).apply();
    }




}
