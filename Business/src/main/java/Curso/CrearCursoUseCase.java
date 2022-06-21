package Curso;

import Curso.Commands.AgregarCategoria;
import Curso.Commands.AgregarCurso;
import Curso.Identitis.CategoriaId;
import Curso.Identitis.CursoId;
import Docente.Identities.DocenteId;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;

public class CrearCursoUseCase extends UseCase<RequestCommand<AgregarCurso>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<AgregarCurso> input) {
        AgregarCurso command= input.getCommand();
         var Curso = new Curso(CategoriaId.of("0001"),new CursoId(),command.getDescripcion(),command.getIdioma(),command.getDuracion(),
                 DocenteId.of("0001"));
         this.emit().onResponse(new ResponseEvents(Curso.getUncommittedChanges()));
    }
}
