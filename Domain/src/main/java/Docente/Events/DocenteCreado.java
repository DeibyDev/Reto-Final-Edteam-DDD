package Docente.Events;

import Docente.Entities.Especialidad;
import Docente.Values.Correo;
import Docente.Values.Fullname;
import Docente.Values.Identificacion;
import co.com.sofka.domain.generic.DomainEvent;

public class DocenteCreado extends DomainEvent {



    private  Correo correo;
    private  Fullname fullname;
    private  Identificacion identificacion;
    private  Especialidad especialidad;


    public DocenteCreado( Correo correo, Fullname fullname, Identificacion identificacion, Especialidad especialidad) {
        super("Sofka.Docente.DocenteCreado");
    }
}
