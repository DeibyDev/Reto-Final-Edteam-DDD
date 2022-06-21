package Curso;

import Curso.Commands.AgregarCategoria;
import Curso.Entities.Categoria;
import Curso.Entities.Refuerzos;
import Curso.Events.*;
import Curso.Identitis.CategoriaId;
import Curso.Identitis.CursoId;
import Curso.Values.Descripcion;
import Curso.Values.Duracion;
import Curso.Values.Idioma;
import Curso.Values.TipoCategorias;
import Docente.Identities.DocenteId;
import Factory.LessonFactory;
import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.generic.DomainEvent;

import java.util.List;
import java.util.Set;

public class Curso extends AggregateEvent<CursoId> {

 protected Categoria categoria;
 protected CategoriaId categoriaId;
 protected Descripcion descripcion;
 protected TipoCategorias tipoCategorias;
 protected Set<Refuerzos> refuerzos;
 protected Curso curso;

    public Curso(CursoId entityId) {
        super(entityId);
        this.subscribe(new CursoChange(this));
    }

    public Curso(CategoriaId categoriaId, TipoCategorias tipoCategorias, Descripcion descripcion) {
        super(new CursoId());
        this.appendChange(new CategoriaCreada(categoriaId,tipoCategorias,descripcion)).apply();

    }

    public Curso(CategoriaId of, CursoId cursoId, Descripcion descripcion, Idioma idioma, Duracion duracion, DocenteId of1) {
        super(cursoId);
        subscribe(new CursoChange(this));
        this.appendChange(new CursoCreado(cursoId,new CategoriaId(),idioma,descripcion,duracion,new DocenteId()));
    }

    public static Curso from(CursoId entityId, List<DomainEvent> events) {
        Curso curso = new Curso(entityId);
        events.forEach(curso::applyEvent);
        return curso;
    }

    public void agregarRepaso(LessonFactory lessonFactory){
        lessonFactory.refuerzos()
                .forEach(refuerzo ->
                        appendChange(
                                new RepasoCreado(refuerzo.identity(),refuerzo.contenido(),refuerzo.tipoCategorias())
                        )   .apply()
                );
    }


    public void agregarCategoria(TipoCategorias tipoCategorias , Descripcion descripcion){
        CategoriaId categoriaId= new CategoriaId();
        this.appendChange(new CategoriaCreada(categoriaId,tipoCategorias,descripcion)).apply();
    }
    public void actualizarCurso(CategoriaId categoriaId, CursoId cursoId, Descripcion descripcion, Idioma idioma, Duracion duracion, DocenteId docenteId){
        appendChange(new CursoEditado(categoriaId, cursoId, descripcion,idioma,duracion,docenteId)
        ).apply();
    }

    public void eliminarCurso(CategoriaId categoriaId,CursoId cursoId,DocenteId docenteId){
        appendChange(new CursoEliminado(categoriaId, cursoId,docenteId)).apply();
    }

}
