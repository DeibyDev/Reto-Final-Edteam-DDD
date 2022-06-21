package Curso.Entities;

import Curso.Identitis.RefuerzosId;
import Curso.Values.Contenido;
import Curso.Values.TipoCategorias;
import co.com.sofka.domain.generic.Entity;

import java.util.Objects;

public class Refuerzos extends Entity<RefuerzosId> {

    private Contenido contenido;
    private TipoCategorias tipoCategorias;


    public Refuerzos(RefuerzosId RefuerzosId,  Contenido contenido, TipoCategorias tipoCategorias) {
        super(RefuerzosId);
        this.contenido=contenido;
        this.tipoCategorias=tipoCategorias;
    }

    public void cambiarCategoria(TipoCategorias tipoCategorias){
        this.tipoCategorias = Objects.requireNonNull(tipoCategorias);
    }

    public void changeContent(Contenido contenido){
        this.contenido = Objects.requireNonNull(contenido);
    }

    public TipoCategorias tipoCategorias() {
        return tipoCategorias;
    }

    public Contenido contenido() {
        return contenido;
    }


}
