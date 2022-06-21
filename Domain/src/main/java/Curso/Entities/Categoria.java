package Curso.Entities;

import Curso.Identitis.CategoriaId;
import Curso.Values.Descripcion;
import Curso.Values.TipoCategorias;
import Docente.Identities.EspecialidadId;
import Docente.Values.tipoEspecialidad;
import co.com.sofka.domain.generic.Entity;

import java.util.Objects;

public class Categoria extends Entity<CategoriaId> {

    private TipoCategorias tipoCategorias;
    private Descripcion descripcion;

    public Categoria(CategoriaId entityId, TipoCategorias tipoCategorias , Descripcion descripcion) {
        super(entityId);
        this.tipoCategorias = tipoCategorias;
        this.descripcion=descripcion;
    }


    // Comportamientos



}
