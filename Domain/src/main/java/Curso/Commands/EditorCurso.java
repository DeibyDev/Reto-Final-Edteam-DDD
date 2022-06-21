package Curso.Commands;

import Curso.Identitis.CategoriaId;
import Curso.Identitis.CursoId;
import Curso.Values.Descripcion;
import Curso.Values.Duracion;
import Curso.Values.Idioma;
import Docente.Identities.DocenteId;
import co.com.sofka.domain.generic.Command;

public class EditorCurso extends Command {

    protected CategoriaId CategoriaId;
    protected CursoId cursoId;
    protected Descripcion descripcion;
    protected Idioma idioma;
    protected Duracion duracion;
    protected DocenteId docenteId;

    public EditorCurso(CategoriaId categoriaId, CursoId cursoId, Descripcion descripcion, Idioma idioma, Duracion duracion, DocenteId docenteId) {
        CategoriaId = categoriaId;
        this.cursoId = cursoId;
        this.descripcion = descripcion;
        this.idioma = idioma;
        this.duracion = duracion;
        this.docenteId = docenteId;
    }

    public CategoriaId getCategoriaId() {
        return CategoriaId;
    }

    public CursoId getCursoId() {
        return cursoId;
    }

    public Descripcion getDescripcion() {
        return descripcion;
    }

    public Idioma getIdioma() {
        return idioma;
    }

    public Duracion getDuracion() {
        return duracion;
    }

    public DocenteId getDocenteId() {
        return docenteId;
    }
}
