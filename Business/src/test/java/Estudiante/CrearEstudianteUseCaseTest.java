package Estudiante;



import Estudiante.Commands.CrearEstudianteCommand;
import Estudiante.Events.estudianteCreado;
import Estudiante.Identities.EstudianteId;
import Estudiante.Identities.SuscripcionId;
import Genericos.*;
import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class CrearEstudianteUseCaseTest {
    @Test
    void crearEstudiante() {
        SuscripcionId suscripcionId= new SuscripcionId();
        Correo correo = new Correo("diegomilito@gmail.com");
        Fullname fullname= new Fullname("Diego Milito");
        Identificacion identificacion = new Identificacion("1003948223");
        EstudianteId estudianteId = EstudianteId.of("0001");

        CrearEstudianteCommand command = new CrearEstudianteCommand(estudianteId,correo,fullname,suscripcionId,identificacion);
        CrearEstudianteUseCase Usecase = new CrearEstudianteUseCase();

        //act
        List<DomainEvent> events = UseCaseHandler.getInstance()
                .syncExecutor(Usecase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();


        //assert
        estudianteCreado event = (estudianteCreado) events.get(0);
        Assertions.assertEquals("Sofka.Estudiante.estudianteCreado", event.type);
        Assertions.assertEquals("diegomilito@gmail.com" , event.getCorreo().value());
        Assertions.assertEquals(estudianteId.value(),event.aggregateRootId());


    }



}
