package Estudiante;

import Estudiante.Commands.CrearEstudianteCommand;
import Estudiante.Identities.EstudianteId;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;

public class CrearEstudianteUseCase extends UseCase<RequestCommand<CrearEstudianteCommand>, ResponseEvents>  {
    @Override
    public void executeUseCase(RequestCommand<CrearEstudianteCommand> input) {
        var command = input.getCommand();
        var Estudiante = new Estudiante(command.getEstudianteId(),command.getCorreo(),command.getFullname(),command.getSuscripcionId(),command.getIdentificacion());
        emit().onResponse(new ResponseEvents(Estudiante.getUncommittedChanges()));
    }
}
