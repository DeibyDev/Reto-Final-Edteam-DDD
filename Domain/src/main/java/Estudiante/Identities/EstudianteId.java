package Estudiante.Identities;

import co.com.sofka.domain.generic.Identity;

public class EstudianteId extends Identity {
    public EstudianteId(String id){
        super(id);
    }


    public EstudianteId() {
    }
    public static EstudianteId of(String id){ return new EstudianteId(id);}
}
