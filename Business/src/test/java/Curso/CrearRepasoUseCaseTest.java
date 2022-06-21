package Curso;


import Curso.Commands.CrearRepaso;
import Curso.Events.CursoCreado;
import Curso.Events.RepasoCreado;
import Curso.Identitis.CategoriaId;
import Curso.Identitis.CursoId;
import Curso.Identitis.RefuerzosId;
import Curso.Values.*;
import Docente.Identities.DocenteId;
import Factory.LessonFactory;
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
 class CrearRepasoUseCaseTest {
    @Mock
    DomainEventRepository repository;

    @InjectMocks
    CrearRepasoUseCase useCase;

    @Test
    void agregarRepasoCurso(){
        //arrange
        LessonFactory factory = LessonFactory.getInstance()
                .add(RefuerzosId.of("R001"), new Contenido("Refuerzo clase de programacion"), new TipoCategorias(TipoCategorias.Types.DESARROLLO));

        CursoId id = new CursoId();
        var command = new CrearRepaso(factory, id);
        when(repository.getEventsBy(id.value())).thenReturn(history());
        useCase.addRepository(repository);


        //act
        var events = UseCaseHandler.getInstance()
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        //assert
        Assertions.assertEquals(1, events.size());

    }

    private List<DomainEvent> history() {
        CursoId cursoId= new CursoId();
        CategoriaId categoriaId= new CategoriaId();
        Descripcion descripcion=new Descripcion("Para desarrolladores");
        Idioma idioma=new Idioma("Español");
        Duracion duracion=new Duracion("10h");
        DocenteId docenteId=DocenteId.of("d0001");

        return List.of(
                new CursoCreado(cursoId,categoriaId,idioma,descripcion, duracion,docenteId),
                new RepasoCreado(RefuerzosId.of("R001"),
                        new Contenido("Refuerzo clase de programacion"),
                        new TipoCategorias(TipoCategorias.Types.DESARROLLO)
                ));
    }

}
