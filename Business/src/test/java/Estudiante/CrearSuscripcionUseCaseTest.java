package Estudiante;

import Docente.CrearDocenteUseCase;
import Docente.Events.DocenteCreado;
import Estudiante.Commands.CrearSuscripcionCommand;
import Estudiante.Entities.Suscripcion;
import Estudiante.Events.suscripcionCreada;
import Estudiante.Identities.SuscripcionId;
import Estudiante.Values.Descripcion;
import Estudiante.Values.TipoSuscripcion;
import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static Estudiante.Values.TipoSuscripcion.Types.PREMIUM;

public class CrearSuscripcionUseCaseTest {
    @Test
    void crearSuscripcion() {
        Suscripcion suscripcion = new Suscripcion(new SuscripcionId());
        Descripcion descripcion =new Descripcion("Prueba");
        TipoSuscripcion tipoSuscripcion =new TipoSuscripcion(PREMIUM);

        CrearSuscripcionCommand command = new CrearSuscripcionCommand(descripcion,tipoSuscripcion,suscripcion);
        CrearSuscripcionUseCase Usecase = new CrearSuscripcionUseCase();

        //act
        List<DomainEvent> events = UseCaseHandler.getInstance()
                .syncExecutor(Usecase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();


        //assert
        suscripcionCreada event = (suscripcionCreada) events.get(0);
        Assertions.assertEquals("Sofka.Estudiante.suscripcionCreada", event.type);
        Assertions.assertEquals(PREMIUM, event.getTipoSuscripcion().value());


    }



}
