package Estudiante;


import Estudiante.Commands.ActualizarEstudianteCommand;
import Estudiante.Events.estudianteCreado;
import Estudiante.Events.estudianteEditado;
import Estudiante.Events.estudianteEliminado;
import Estudiante.Identities.EstudianteId;
import Estudiante.Identities.SuscripcionId;
import Genericos.Correo;
import Genericos.Fullname;
import Genericos.Identificacion;
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
public class EliminarEstudianteUseCaseTest {
    @InjectMocks
    private EliminarEstudianteUseCase useCase;

    @Mock
    private DomainEventRepository repository;

    @Test
    void eliminarEstudiante() {
        SuscripcionId suscripcionId= new SuscripcionId();
        Correo correo = new Correo("diegomilito@gmail.com");
        Fullname fullname= new Fullname("Diego Milito");
        Identificacion identificacion = new Identificacion("1003948223");
        EstudianteId estudianteId = EstudianteId.of("0002");

       var event =new estudianteEditado(estudianteId,correo,fullname,suscripcionId,identificacion);

        when(repository.getEventsBy("0002")).thenReturn(history());
        useCase.addRepository(repository);
        var events = UseCaseHandler.getInstance()
                .syncExecutor(useCase, new TriggeredEvent<>(event))
                .orElseThrow()
                .getDomainEvents();

        var estudianteEliminado = (estudianteEliminado)events.get(0);
        Assertions.assertEquals("0002",estudianteEliminado.getEstudianteId().value());


    }

    private List<DomainEvent> history() {

        SuscripcionId suscripcionId= new SuscripcionId();
        Correo correo = new Correo("prueba2@gmail.com");
        Fullname fullname= new Fullname("Prueba3");
        Identificacion identificacion = new Identificacion("1003948223");
        EstudianteId estudianteId = EstudianteId.of("0003");
        var evento = new estudianteCreado(
                estudianteId,correo,fullname,suscripcionId,identificacion);
        evento.setAggregateRootId("Root");
        return List.of(evento);
    }



}
