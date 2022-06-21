    package Estudiante.Commands;

import Docente.Identities.DocenteId;
import Docente.Values.Correo;
import Docente.Values.Fullname;
import Docente.Values.Identificacion;
import Estudiante.Entities.Suscripcion;
import Estudiante.Values.Descripcion;
import Estudiante.Values.TipoSuscripcion;
import co.com.sofka.domain.generic.Command;

import java.util.Objects;

    public class EditarSuscripcionCommand extends Command {

        private final Descripcion descripcion;
        private final TipoSuscripcion tipoSuscripcion;

        private final Suscripcion suscripcionId;




     public EditarSuscripcionCommand(Descripcion descripcion, TipoSuscripcion tipoSuscripcion, Suscripcion suscripcionId){

            this.descripcion = descripcion;
            this.tipoSuscripcion = tipoSuscripcion;
            this.suscripcionId = suscripcionId;
        }

        public Descripcion getDescripcion() {
            return descripcion;
        }

        public TipoSuscripcion getTipoSuscripcion() {
            return tipoSuscripcion;
        }

        public Suscripcion getSuscripcionId() {
            return suscripcionId;
        }
    }
