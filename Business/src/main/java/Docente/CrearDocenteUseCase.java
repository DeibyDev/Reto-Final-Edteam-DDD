package Docente;

import Docente.Commands.CrearDocenteCommand;
import Docente.Identities.DocenteId;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;

public class CrearDocenteUseCase extends UseCase<RequestCommand<CrearDocenteCommand>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<CrearDocenteCommand> input) {
        var command = input.getCommand();
        var docente = new Docente(new DocenteId(), command.getCorreo(), command.getFullname(),
                command.getIdentificacion(),command.getEspecialidad());
        emit().onResponse(new ResponseEvents(docente.getUncommittedChanges()));
    }
}
