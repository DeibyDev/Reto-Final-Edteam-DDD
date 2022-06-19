package Docente.Identities;

import Docente.Docente;
import co.com.sofka.domain.generic.Identity;

public class DocenteId extends Identity {
    public DocenteId(String id){
        super(id);
    }

    public static DocenteId of(String id){
        return new DocenteId(id);
    }
}
