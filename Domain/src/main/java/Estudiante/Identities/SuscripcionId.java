package Estudiante.Identities;

import Docente.Identities.EspecialidadId;
import co.com.sofka.domain.generic.Identity;

public class SuscripcionId extends Identity {
    public SuscripcionId(String id){
        super(id);
    }


    public SuscripcionId() {
     

    }
    public static SuscripcionId of(String id){
        return new SuscripcionId(id);
    }
}
