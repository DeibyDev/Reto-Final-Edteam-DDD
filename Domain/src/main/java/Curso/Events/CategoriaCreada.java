package Curso.Events;

import Curso.Entities.Categoria;
import Curso.Identitis.CategoriaId;
import Curso.Values.Descripcion;
import Curso.Values.TipoCategorias;
import co.com.sofka.domain.generic.DomainEvent;

public class CategoriaCreada extends DomainEvent {
    protected CategoriaId categoriaId;
    protected TipoCategorias tipoCategorias;
    protected Descripcion descripcion;

    public CategoriaCreada(CategoriaId categoriaId,TipoCategorias tipoCategorias,Descripcion descripcion){
       super("sofka.Curso.CategoriaCreada");
        this.categoriaId=categoriaId;
        this.tipoCategorias=tipoCategorias;
        this.descripcion=descripcion;
    }

    public CategoriaId getCategoriaId() {
        return categoriaId;
    }

    public TipoCategorias getTipoCategorias() {
        return tipoCategorias;
    }

    public Descripcion getDescripcion() {
        return descripcion;
    }
}
