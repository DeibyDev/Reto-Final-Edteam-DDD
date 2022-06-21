package Curso;

import Curso.Commands.AgregarCategoria;
import Curso.Events.CategoriaCreada;
import Curso.Identitis.CategoriaId;
import Curso.Identitis.CursoId;
import Curso.Values.Descripcion;
import Curso.Values.TipoCategorias;
import Docente.Commands.CrearDocenteCommand;
import Docente.CrearDocenteUseCase;
import Docente.Entities.Especialidad;
import Docente.Events.DocenteCreado;
import Docente.Identities.DocenteId;
import Docente.Identities.EspecialidadId;
import Docente.Values.Correo;
import Docente.Values.Fullname;
import Docente.Values.Identificacion;
import Docente.Values.tipoEspecialidad;
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

import static Curso.Values.TipoCategorias.Types.DESARROLLO;

@ExtendWith({MockitoExtension.class})
public class CrearCategoriaUseCaseTest {

    @InjectMocks
    private CrearCategoriaUseCase useCase;

    @Mock
    private DomainEventRepository repository;

    public CrearCategoriaUseCaseTest() {
    }

    @Test
    void crearCategoria() {
        CategoriaId categoriaId = CategoriaId.of("0001");
        TipoCategorias tipoCategorias= new TipoCategorias(DESARROLLO);
        Descripcion descripcion=new Descripcion("Categoria para Desarrolladores");

        AgregarCategoria command = new AgregarCategoria(categoriaId,tipoCategorias,descripcion);
        CrearCategoriaUseCase Usecase = new CrearCategoriaUseCase();

        //act
        List<DomainEvent> events = UseCaseHandler.getInstance()
                .syncExecutor(Usecase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();


        //assert
        CategoriaCreada event = (CategoriaCreada) events.get(0);
        Assertions.assertEquals("sofka.Curso.CategoriaCreada", event.type);


    }



}
