package Curso.Identitis;

import co.com.sofka.domain.generic.Identity;

public class CursoId extends Identity {
    public CursoId(String id){
        super(id);
    }


    public CursoId() {
    }
    public static CursoId of(String id){ return new CursoId(id);}
}
