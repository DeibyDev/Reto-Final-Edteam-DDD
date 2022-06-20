    package Docente.Commands;

import Docente.Entities.Especialidad;
import Docente.Identities.DocenteId;
import Docente.Values.Correo;
import Docente.Values.Fullname;
import Docente.Values.Identificacion;
import co.com.sofka.domain.generic.Command;

import java.util.Objects;

    public class EditarDocenteCommand extends Command {
    private final Correo correo;
    private final Fullname fullname;
    private final Identificacion identificacion;

    private  final DocenteId docenteId;



    public EditarDocenteCommand(Correo correo, Fullname fullname, Identificacion identificacion, DocenteId docenteId ) {
        Objects.requireNonNull(correo);
        Objects.requireNonNull(fullname);
        Objects.requireNonNull(identificacion);
        Objects.requireNonNull(docenteId);
        this.correo = correo;
        this.fullname = fullname;
        this.identificacion = identificacion;
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

    public DocenteId getDocenteId() {
        return docenteId;
    }


    }
