package Estudiante;

import Estudiante.Commands.ActualizarEstudianteCommand;
import Estudiante.Events.estudianteEditado;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.business.support.TriggeredEvent;

public class EliminarEstudianteUseCase extends UseCase<TriggeredEvent<estudianteEditado>, ResponseEvents>  {
    @Override
    public void executeUseCase(TriggeredEvent<estudianteEditado> input) {
        var command = input.getDomainEvent();
        var estudiante =Estudiante.from(command.getEstudianteId(),repository().getEventsBy(command.getEstudianteId().value()));

        estudiante.eliminarEstudiante(command.getEstudianteId(),command.getCorreo(),command.getFullname(),command.getSuscripcionId(),command.getIdentificacion());
        emit().onResponse(new ResponseEvents(estudiante.getUncommittedChanges()));
    }
}
