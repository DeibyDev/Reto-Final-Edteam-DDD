package Estudiante;


import Estudiante.Commands.ActualizarEstudianteCommand;
import Estudiante.Commands.CrearEstudianteCommand;
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
public class EditarEstudianteUseCaseTest {
    @InjectMocks
    private EditarEstudianteUseCase useCase;

    @Mock
    private DomainEventRepository repository;

    @Test
    void editarEstudiante() {
        SuscripcionId suscripcionId= new SuscripcionId();
        Correo correo = new Correo("diegomilito@gmail.com");
        Fullname fullname= new Fullname("Diego Milito");
        Identificacion identificacion = new Identificacion("1003948223");
        EstudianteId estudianteId = EstudianteId.of("0002");

        ActualizarEstudianteCommand command = new ActualizarEstudianteCommand(estudianteId,correo,fullname,suscripcionId,identificacion);

        when(repository.getEventsBy("0002")).thenReturn(history());
        useCase.addRepository(repository);


        //act
        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor(command.getEstudianteId().value())
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();


        //assert
        estudianteEditado event = (estudianteEditado) events.get(0);
        Assertions.assertEquals("Sofka.Estudiante.estudianteEditado", event.type);
        Assertions.assertEquals("diegomilito@gmail.com" , event.getCorreo().value());
        Assertions.assertEquals(estudianteId.value(),event.aggregateRootId());


    }

    private List<DomainEvent> history() {

        SuscripcionId suscripcionId= new SuscripcionId();
        Correo correo = new Correo("prueba2@gmail.com");
        Fullname fullname= new Fullname("Prueba2");
        Identificacion identificacion = new Identificacion("1003948223");
        EstudianteId estudianteId = EstudianteId.of("0003");
        var evento = new estudianteCreado(
                estudianteId,correo,fullname,suscripcionId,identificacion);
        evento.setAggregateRootId("Root");
        return List.of(evento);
    }



}
