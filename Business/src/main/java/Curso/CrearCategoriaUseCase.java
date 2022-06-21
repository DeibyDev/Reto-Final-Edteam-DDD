package Curso;

import Curso.Commands.AgregarCategoria;
import Curso.Identitis.CategoriaId;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;

public class CrearCategoriaUseCase extends UseCase<RequestCommand<AgregarCategoria>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<AgregarCategoria> input) {
         AgregarCategoria command= input.getCommand();
         var Curso = new Curso(new CategoriaId(),command.getTipoCategorias(),command.getDescripcion());
         this.emit().onResponse(new ResponseEvents(Curso.getUncommittedChanges()));
    }
}
