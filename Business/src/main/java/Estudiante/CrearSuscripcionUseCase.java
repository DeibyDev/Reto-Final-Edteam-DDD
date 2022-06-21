package Estudiante;

import Docente.Commands.CrearDocenteCommand;
import Docente.Docente;
import Docente.Identities.DocenteId;
import Estudiante.Commands.CrearSuscripcionCommand;
import Estudiante.Entities.Suscripcion;
import Estudiante.Identities.EstudianteId;
import Estudiante.Identities.SuscripcionId;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;

public class CrearSuscripcionUseCase extends UseCase<RequestCommand<CrearSuscripcionCommand>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<CrearSuscripcionCommand> input) {
        var command = input.getCommand();
        var Estudiante = new Estudiante(new SuscripcionId(),command.getDescripcion(),command.getTipoSuscripcion());
        emit().onResponse(new ResponseEvents(Estudiante.getUncommittedChanges()));
    }
}
