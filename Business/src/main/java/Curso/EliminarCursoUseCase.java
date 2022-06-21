package Curso;

import Curso.Commands.EditorCurso;
import Curso.Events.CursoEditado;
import Curso.Events.CursoEliminado;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.business.support.TriggeredEvent;

public class EliminarCursoUseCase extends UseCase<TriggeredEvent<CursoEditado>, ResponseEvents>  {
    @Override
    public void executeUseCase(TriggeredEvent<CursoEditado> input) {
        var command = input.getDomainEvent();
        var curso = Curso.from(command.getCursoId(),repository().getEventsBy(command.getCursoId().value()));

        curso.eliminarCurso(command.getCategoriaId(),command.getCursoId(),command.getDocenteId());
        emit().onResponse(new ResponseEvents(curso.getUncommittedChanges()));
    }
}
