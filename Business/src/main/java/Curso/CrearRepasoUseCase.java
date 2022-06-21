package Curso;

import Curso.Commands.CrearRepaso;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;

public class CrearRepasoUseCase  extends UseCase<RequestCommand<CrearRepaso>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<CrearRepaso> input) {
        var command = input.getCommand();
        var curso = Curso.from(command.getCursoId(),repository().getEventsBy(command.getCursoId().value()));
        curso.agregarRepaso(command.getLessonFactory());
        emit().onResponse(new ResponseEvents(curso.getUncommittedChanges()));
    }
}
