package Curso.Identitis;

import co.com.sofka.domain.generic.Identity;

public class RefuerzosId extends Identity {
    public RefuerzosId(String id){
        super(id);
    }


    public RefuerzosId() {
    }
    public static RefuerzosId of(String id){ return new RefuerzosId(id);}
}
