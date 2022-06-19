package Docente.Identities;

import co.com.sofka.domain.generic.Identity;

public class EspecialidadId extends Identity {
    public EspecialidadId(String id){
        super(id);
    }

    public static EspecialidadId of(String id){
        return new EspecialidadId(id);
    }
}
