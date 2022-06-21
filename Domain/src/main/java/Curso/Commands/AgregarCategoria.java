package Curso.Commands;

import Curso.Curso;
import Curso.Identitis.CategoriaId;
import Curso.Identitis.CursoId;
import Curso.Values.Descripcion;
import Curso.Values.TipoCategorias;
import co.com.sofka.domain.generic.Command;

public class AgregarCategoria extends Command {

    protected CategoriaId CategoriaId;
    protected TipoCategorias tipoCategorias;
    protected Descripcion descripcion;

    public AgregarCategoria(CategoriaId CategoriaId,TipoCategorias tipoCategorias,Descripcion descripcion){
          this.CategoriaId=CategoriaId;
          this.tipoCategorias=tipoCategorias;
          this.descripcion=descripcion;

    }

    public CategoriaId getCategoriaId() {
        return CategoriaId;
    }

    public TipoCategorias getTipoCategorias() {
        return tipoCategorias;
    }

    public Descripcion getDescripcion() {
        return descripcion;
    }
}
