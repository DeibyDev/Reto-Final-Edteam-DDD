package Curso;


import Curso.Commands.EditorCurso;
import Curso.Events.CursoEditado;
import Curso.Events.CursoEliminado;
import Curso.Identitis.CategoriaId;
import Curso.Identitis.CursoId;
import Curso.Values.Descripcion;
import Curso.Values.Duracion;
import Curso.Values.Idioma;
import Docente.Identities.DocenteId;
import Estudiante.Events.estudianteEliminado;
import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.TriggeredEvent;
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
public class EliminarCursoUseCaseTest {
    @InjectMocks
    private EliminarCursoUseCase useCase;

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

       var event= new CursoEditado(categoriaId,cursoId,descripcion,idioma,duracion,docenteId);

        when(repository.getEventsBy("0002")).thenReturn(history());
        useCase.addRepository(repository);
        var events = UseCaseHandler.getInstance()
                .syncExecutor(useCase, new TriggeredEvent<>(event))
                .orElseThrow()
                .getDomainEvents();


        //assert

        var cursoEliminado = (CursoEliminado)events.get(0);
        Assertions.assertEquals("0002",cursoEliminado.getCursoId().value());

    }


    private List<DomainEvent> history() {


        CategoriaId categoriaId = CategoriaId.of("0001");
        CursoId cursoId= CursoId.of("0001");
        DocenteId docenteId= new DocenteId();
        var evento = new CursoEliminado(
                categoriaId,cursoId,docenteId);
        evento.setAggregateRootId("Root");
        return List.of(evento);
    }



}
