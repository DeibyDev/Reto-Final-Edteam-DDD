package Curso;

import Curso.Commands.AgregarCategoria;
import Curso.Commands.AgregarCurso;
import Curso.Events.CategoriaCreada;
import Curso.Events.CursoCreado;
import Curso.Identitis.CategoriaId;
import Curso.Identitis.CursoId;
import Curso.Values.Descripcion;
import Curso.Values.Duracion;
import Curso.Values.Idioma;
import Curso.Values.TipoCategorias;
import Docente.Docente;
import Docente.Identities.DocenteId;
import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static Curso.Values.TipoCategorias.Types.DESARROLLO;

@ExtendWith({MockitoExtension.class})
public class CrearCursoUseCaseTest {

    @InjectMocks
    private CrearCategoriaUseCase useCase;

    @Mock
    private DomainEventRepository repository;

    public CrearCursoUseCaseTest() {
    }

    @Test
    void crearCategoria() {
        CategoriaId categoriaId = new CategoriaId();
        CursoId cursoId= new CursoId();
        Descripcion descripcion = new Descripcion("Curso fundamentos de programacion");
        Idioma idioma = new Idioma("Español");
        Duracion duracion= new Duracion("10h");
        DocenteId docenteId= new DocenteId();


        AgregarCurso command = new AgregarCurso(categoriaId,cursoId,descripcion,idioma,duracion,docenteId);
        CrearCursoUseCase Usecase = new CrearCursoUseCase();

        //act
        List<DomainEvent> events = UseCaseHandler.getInstance()
                .syncExecutor(Usecase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();


        //assert
        CursoCreado event = (CursoCreado) events.get(0);
        Assertions.assertEquals("sofka.Curso.CursoCreado", event.type);



    }



}
