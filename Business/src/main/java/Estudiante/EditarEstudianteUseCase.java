package Estudiante;

import Estudiante.Commands.ActualizarEstudianteCommand;
import Estudiante.Commands.CrearEstudianteCommand;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;

public class EditarEstudianteUseCase extends UseCase<RequestCommand<ActualizarEstudianteCommand>, ResponseEvents>  {
    @Override
    public void executeUseCase(RequestCommand<ActualizarEstudianteCommand> input) {
        var command = input.getCommand();
        var estudiante =Estudiante.from(command.getEstudianteId(),repository().getEventsBy(command.getEstudianteId().value()));

        estudiante.actualizarEstudiante(command.getEstudianteId(),command.getCorreo(),command.getFullname(),command.getSuscripcionId(),command.getIdentificacion());
        emit().onResponse(new ResponseEvents(estudiante.getUncommittedChanges()));
    }
}
