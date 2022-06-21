package Curso;

import Curso.Commands.EditorCurso;
import Estudiante.Commands.ActualizarEstudianteCommand;
import Estudiante.Estudiante;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;

public class EditarCursoUseCase extends UseCase<RequestCommand<EditorCurso>, ResponseEvents>  {
    @Override
    public void executeUseCase(RequestCommand<EditorCurso> input) {
        var command = input.getCommand();
        var curso = Curso.from(command.getCursoId(),repository().getEventsBy(command.getCursoId().value()));

        curso.actualizarCurso(command.getCategoriaId(),command.getCursoId(),command.getDescripcion(),command.getIdioma(),command.getDuracion(),command.getDocenteId());
        emit().onResponse(new ResponseEvents(curso.getUncommittedChanges()));
    }
}
