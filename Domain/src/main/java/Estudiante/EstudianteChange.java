package Estudiante;

import Docente.Docente;
import Docente.Events.DocenteCreado;
import Docente.Events.DocenteEditado;
import Estudiante.Events.estudianteCreado;
import Estudiante.Events.suscripcionCreada;
import co.com.sofka.domain.generic.EventChange;

public class EstudianteChange extends EventChange {
   public EstudianteChange(Estudiante estudiante){
       apply((suscripcionCreada event)->{
          estudiante.crearSuscripcion();
       });

       apply((suscripcionCreada event)->{
           estudiante.editarSuscripcion(event.getTipoSuscripcion(),event.getDescripcion(),event.getSuscripcionId());
       });

       apply((estudianteCreado event)->{
           estudiante.suscripcionId=null;
       });


   }

}
