package Estudiante.Commands;

import Estudiante.Identities.EstudianteId;
import Estudiante.Identities.SuscripcionId;
import Genericos.Correo;
import Genericos.Fullname;
import Genericos.Identificacion;
import co.com.sofka.domain.generic.Command;

public class CrearEstudianteCommand extends Command {

    private final Correo correo;
    private final Fullname fullname;

    private final Identificacion identificacion;
    private final SuscripcionId suscripcionId;

    private final EstudianteId estudianteId;


    public CrearEstudianteCommand(EstudianteId estudianteId,Correo correo, Fullname fullname, SuscripcionId suscripcionId,Identificacion identificacion) {
        this.correo = correo;
        this.fullname = fullname;
        this.suscripcionId = suscripcionId;
        this.identificacion=identificacion;
        this.estudianteId=estudianteId;
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

    public SuscripcionId getSuscripcionId() {
        return suscripcionId;
    }

    public EstudianteId getEstudianteId() {
        return estudianteId;
    }
}
