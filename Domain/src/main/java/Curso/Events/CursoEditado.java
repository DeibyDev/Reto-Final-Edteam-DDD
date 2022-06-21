package Curso.Events;

import Curso.Identitis.CategoriaId;
import Curso.Identitis.CursoId;
import Curso.Values.Descripcion;
import Curso.Values.Duracion;
import Curso.Values.Idioma;
import Docente.Identities.DocenteId;
import co.com.sofka.domain.generic.DomainEvent;

public class CursoEditado extends DomainEvent {
    protected CursoId cursoId;
    protected Idioma descripcion;
    protected DocenteId docenteId;
    protected Descripcion idioma;
    protected Duracion duracion;
    protected CategoriaId categoriaId;


    public CursoEditado(CategoriaId categoriaId, CursoId cursoId,
                        Descripcion idioma, Idioma descripcion , Duracion duracion, DocenteId docenteId){
       super("sofka.Curso.Editado");

       this.cursoId=cursoId;
       this.categoriaId=categoriaId;
       this.idioma=idioma;
       this.descripcion=descripcion;
       this.duracion=duracion;
       this.docenteId=docenteId;

    }



    public Idioma getDescripcion() {
        return descripcion;
    }

    public DocenteId getDocenteId() {
        return docenteId;
    }

    public Descripcion getIdioma() {
        return idioma;
    }

    public Duracion getDuracion() {
        return duracion;
    }

    public CursoId getCursoId() {
        return cursoId;
    }

    public CategoriaId getCategoriaId() {
        return categoriaId;
    }
}
