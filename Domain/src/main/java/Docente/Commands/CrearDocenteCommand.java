package Docente.Commands;

import Docente.Entities.Especialidad;
import Docente.Identities.DocenteId;
import Docente.Values.Correo;
import Docente.Values.Fullname;
import Docente.Values.Identificacion;
import co.com.sofka.domain.generic.Command;

public class CrearDocenteCommand extends Command {
    private final Correo correo;
    private final Fullname fullname;
    private final Identificacion identificacion;
    private final Especialidad especialidad;

    private  final DocenteId docenteId;


    public CrearDocenteCommand(Correo correo, Fullname fullname, Identificacion identificacion, Especialidad especialidad, DocenteId docenteId) {
        this.correo = correo;
        this.fullname = fullname;
        this.identificacion = identificacion;
        this.especialidad = especialidad;
        this.docenteId = docenteId;
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

    public Especialidad getEspecialidad() {
        return especialidad;
    }

    public DocenteId getDocenteId() {
        return docenteId;
    }
}
