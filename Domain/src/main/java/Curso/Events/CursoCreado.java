package Curso.Events;

import Curso.Identitis.CategoriaId;
import Curso.Identitis.CursoId;
import Curso.Values.Descripcion;
import Curso.Values.Duracion;
import Curso.Values.Idioma;
import Curso.Values.TipoCategorias;
import Docente.Docente;
import Docente.Identities.DocenteId;
import co.com.sofka.domain.generic.DomainEvent;

public class CursoCreado extends DomainEvent {
    protected CategoriaId categoriaId;
    protected Descripcion descripcion;
    protected DocenteId docenteId;
    protected Idioma idioma;
    protected Duracion duracion;
    protected CursoId cursoId;

    public CursoCreado(CursoId cursoId,CategoriaId categoriaId,
                       Idioma idioma, Descripcion descripcion , Duracion duracion,DocenteId docenteId){
       super("sofka.Curso.CursoCreado");

       this.cursoId=cursoId;
       this.categoriaId=categoriaId;
       this.idioma=idioma;
       this.descripcion=descripcion;
       this.duracion=duracion;
       this.docenteId=docenteId;

    }

    public CategoriaId getCategoriaId() {
        return categoriaId;
    }

    public Descripcion getDescripcion() {
        return descripcion;
    }

    public DocenteId getDocenteId() {
        return docenteId;
    }

    public Idioma getIdioma() {
        return idioma;
    }

    public Duracion getDuracion() {
        return duracion;
    }

    public CursoId getCursoId() {
        return cursoId;
    }
}
