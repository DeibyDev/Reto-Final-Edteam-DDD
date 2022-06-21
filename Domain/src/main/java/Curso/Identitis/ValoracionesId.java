package Curso.Identitis;

import co.com.sofka.domain.generic.Identity;

public class ValoracionesId extends Identity {
    public ValoracionesId(String id){
        super(id);
    }


    public ValoracionesId() {
    }
    public static ValoracionesId of(String id){ return new ValoracionesId(id);}
}
