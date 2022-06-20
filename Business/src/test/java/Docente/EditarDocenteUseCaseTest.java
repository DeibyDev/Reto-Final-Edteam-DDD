package Docente;

import Docente.Commands.CrearDocenteCommand;
import Docente.Commands.EditarDocenteCommand;
import Docente.Entities.Especialidad;
import Docente.Events.DocenteCreado;
import Docente.Events.DocenteEditado;
import Docente.Identities.DocenteId;
import Docente.Identities.EspecialidadId;
import Docente.Values.Correo;
import Docente.Values.Fullname;
import Docente.Values.Identificacion;
import Docente.Values.tipoEspecialidad;
import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class EditarDocenteUseCaseTest {
    @Test
    void EditarDocente() {
        DocenteId docenteId = new DocenteId();
        Correo correo = new Correo("DeibySierra@hotmail.com");
        Fullname fullname = new Fullname("Deiby Sierra");
        Identificacion identificacion = new Identificacion("1073704700");



        var command = new EditarDocenteCommand(correo,fullname,identificacion,docenteId);
        var Usecase = new EditarDocenteUseCase();

        //act
        List<DomainEvent> events = UseCaseHandler.getInstance()
                .syncExecutor(Usecase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();


        //assert
        DocenteEditado event = (DocenteEditado) events.get(0);
        Assertions.assertEquals("Sofka.Docente.DocenteEditado", event.type);
        Assertions.assertEquals(docenteId.value(), event.aggregateRootId());
        Assertions.assertEquals(docenteId.value(), event.getDocenteId().value());
        Assertions.assertNotNull(docenteId.value());
    }



}
