package Curso;

import Curso.Entities.Categoria;
import Curso.Entities.Refuerzos;
import Curso.Events.CategoriaCreada;
import Curso.Events.CursoCreado;
import Curso.Events.RepasoCreado;
import Curso.Identitis.CategoriaId;
import co.com.sofka.domain.generic.EventChange;

public class CursoChange extends EventChange {

    public CursoChange(Curso curso){
        this.apply((CategoriaCreada event)->{
            CategoriaId categoriaId = event.getCategoriaId();
            Categoria categoria= new Categoria(categoriaId,event.getTipoCategorias(),event.getDescripcion());
            curso.categoria=categoria;
        });

        apply((CursoCreado event)->{
            curso.categoriaId=event.getCategoriaId();
        });
        apply((RepasoCreado event) -> {
            curso.refuerzos.add(new Refuerzos(event.getRefuerzosId(),event.getContenido(),event.getTipoCategorias()));
        });



    }

}
