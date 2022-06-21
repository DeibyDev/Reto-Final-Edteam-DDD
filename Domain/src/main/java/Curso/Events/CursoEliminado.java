package Curso.Events;

import Curso.Identitis.CategoriaId;
import Curso.Identitis.CursoId;
import Curso.Values.Descripcion;
import Curso.Values.Duracion;
import Curso.Values.Idioma;
import Docente.Identities.DocenteId;
import co.com.sofka.domain.generic.DomainEvent;

public class CursoEliminado extends DomainEvent {
    protected CursoId cursoId;
    protected DocenteId docenteId;
    protected CategoriaId categoriaId;


    public CursoEliminado(CategoriaId categoriaId, CursoId cursoId,
                          DocenteId docenteId){
       super("sofka.Curso.Eliminado");

       this.cursoId=cursoId;
       this.categoriaId=categoriaId;
       this.docenteId=docenteId;

    }

    public CursoId getCursoId() {
        return cursoId;
    }

    public DocenteId getDocenteId() {
        return docenteId;
    }

    public CategoriaId getCategoriaId() {
        return categoriaId;
    }
}
