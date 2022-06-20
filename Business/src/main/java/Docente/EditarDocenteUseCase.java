package Docente;

import Docente.Commands.CrearDocenteCommand;
import Docente.Commands.EditarDocenteCommand;
import Docente.Identities.DocenteId;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;

public class EditarDocenteUseCase extends UseCase<RequestCommand<EditarDocenteCommand>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<EditarDocenteCommand> input) {
        var command = input.getCommand();
        var docente = new Docente(command.getDocenteId() , command.getCorreo(),command.getFullname(),command.getIdentificacion());
        emit().onResponse(new ResponseEvents(docente.getUncommittedChanges()));
    }
}
