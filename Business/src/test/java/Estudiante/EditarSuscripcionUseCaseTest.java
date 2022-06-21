package Estudiante;

import Estudiante.Commands.CrearSuscripcionCommand;
import Estudiante.Commands.EditarSuscripcionCommand;
import Estudiante.Entities.Suscripcion;
import Estudiante.Events.suscripcionCreada;
import Estudiante.Events.suscripcionEditada;
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

public class EditarSuscripcionUseCaseTest {
    @Test
    void crearSuscripcion() {
        Suscripcion suscripcion = new Suscripcion(new SuscripcionId());
        Descripcion descripcion =new Descripcion("Prueba2");
        TipoSuscripcion tipoSuscripcion =new TipoSuscripcion(PREMIUM);

        EditarSuscripcionCommand command = new EditarSuscripcionCommand(descripcion,tipoSuscripcion,suscripcion);
        EditarSuscripcionUseCase Usecase = new EditarSuscripcionUseCase();

        //act
        List<DomainEvent> events = UseCaseHandler.getInstance()
                .syncExecutor(Usecase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();


        //assert
        suscripcionEditada event = (suscripcionEditada) events.get(0);
        Assertions.assertEquals("Sofka.Estudiante.suscripcionEditada", event.type);
        Assertions.assertEquals(PREMIUM, event.getTipoSuscripcion().value());
        Assertions.assertEquals(suscripcion.identity(), event.getSuscripcionId());
        Assertions.assertNotNull(suscripcion.identity());


    }



}
