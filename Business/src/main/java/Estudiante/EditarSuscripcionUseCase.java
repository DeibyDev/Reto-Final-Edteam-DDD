package Estudiante;

import Estudiante.Commands.CrearSuscripcionCommand;
import Estudiante.Commands.EditarSuscripcionCommand;
import Estudiante.Identities.SuscripcionId;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;

public class EditarSuscripcionUseCase extends UseCase<RequestCommand<EditarSuscripcionCommand>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<EditarSuscripcionCommand> input) {
        var command = input.getCommand();
        var Estudiante = new Estudiante(command.getSuscripcionId().identity(), command.getDescripcion(),command.getTipoSuscripcion());
        emit().onResponse(new ResponseEvents(Estudiante.getUncommittedChanges()));
    }
}
