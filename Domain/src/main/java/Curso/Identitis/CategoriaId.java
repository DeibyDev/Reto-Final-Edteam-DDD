package Curso.Identitis;

import co.com.sofka.domain.generic.Identity;

public class CategoriaId extends Identity {
    public CategoriaId(String id){
        super(id);
    }


    public CategoriaId() {
    }
    public static CategoriaId of(String id){ return new CategoriaId(id);}
}
