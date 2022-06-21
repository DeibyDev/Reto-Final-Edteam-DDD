package Docente.Identities;

import Curso.Identitis.CategoriaId;
import co.com.sofka.domain.generic.Identity;

public class DocenteId extends Identity {
    public DocenteId(String id){
        super(id);
    }

    public static DocenteId of(String id){ return new DocenteId(id);}
    public DocenteId() {

    }
}
