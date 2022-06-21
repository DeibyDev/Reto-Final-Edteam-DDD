package Curso;


import Curso.Commands.EditorCurso;
import Curso.Events.CursoEditado;
import Curso.Identitis.CategoriaId;
import Curso.Identitis.CursoId;
import Curso.Values.Descripcion;
import Curso.Values.Duracion;
import Curso.Values.Idioma;
import Docente.Identities.DocenteId;
import Estudiante.Commands.ActualizarEstudianteCommand;
import Estudiante.EditarEstudianteUseCase;
import Estudiante.Events.estudianteCreado;
import Estudiante.Events.estudianteEditado;
import Estudiante.Identities.EstudianteId;
import Estudiante.Identities.SuscripcionId;
import Genericos.Correo;
import Genericos.Fullname;
import Genericos.Identificacion;
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

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class EditarCursoUseCaseTest {
    @InjectMocks
    private EditarCursoUseCase useCase;

    @Mock
    private DomainEventRepository repository;

    @Test
    void editarCurso() {
        CategoriaId categoriaId = new CategoriaId();
        CursoId cursoId= CursoId.of("0002");
        Descripcion descripcion = new Descripcion("Curso fundamentos de programacion");
        Idioma idioma = new Idioma("Español");
        Duracion duracion= new Duracion("10h");
        DocenteId docenteId= new DocenteId();

        EditorCurso command = new EditorCurso(categoriaId,cursoId,descripcion,idioma,duracion,docenteId);

        when(repository.getEventsBy("0002")).thenReturn(history());
        useCase.addRepository(repository);


        //act
        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor(command.getCursoId().value())
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();


        //assert
        CursoEditado event = (CursoEditado) events.get(0);
        Assertions.assertEquals("sofka.Curso.Editado", event.type);
        Assertions.assertEquals("Curso fundamentos de programacion" , event.getIdioma().value());
        Assertions.assertEquals(cursoId.value(),event.aggregateRootId());


    }

    private List<DomainEvent> history() {

        CategoriaId categoriaId = new CategoriaId();
        CursoId cursoId= CursoId.of("0003");
        Descripcion descripcion = new Descripcion("Curso fundamentos de programacion");
        Idioma idioma = new Idioma("Español");
        Duracion duracion= new Duracion("10h");
        DocenteId docenteId= new DocenteId();
        var evento = new CursoEditado(
                categoriaId,cursoId,descripcion,idioma,duracion,docenteId);
        evento.setAggregateRootId("Root");
        return List.of(evento);
    }



}
