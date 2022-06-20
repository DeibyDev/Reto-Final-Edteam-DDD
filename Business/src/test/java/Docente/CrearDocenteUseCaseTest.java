package Docente;

import Docente.Commands.CrearDocenteCommand;
import Docente.Entities.Especialidad;
import Docente.Events.DocenteCreado;
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

public class CrearDocenteUseCaseTest {
    @Test
    void crearDocente() {
        DocenteId docenteId = new DocenteId();
        Correo correo = new Correo("DeibySierra@hotmail.com");
        Fullname fullname = new Fullname("Deiby Sierra");
        Identificacion identificacion = new Identificacion("1073704700");
        Especialidad especialidad = new Especialidad(new EspecialidadId("1"),
                new tipoEspecialidad("Desarrollador"));

        CrearDocenteCommand command = new CrearDocenteCommand(correo,fullname,identificacion,especialidad, docenteId);
        CrearDocenteUseCase Usecase = new CrearDocenteUseCase();

        //act
        List<DomainEvent> events = UseCaseHandler.getInstance()
                .syncExecutor(Usecase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();


        //assert
        DocenteCreado event = (DocenteCreado) events.get(0);
        Assertions.assertEquals("Sofka.Docente.DocenteCreado", event.type);


    }



}
