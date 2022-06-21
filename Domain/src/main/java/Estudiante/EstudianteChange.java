package Estudiante;

import Estudiante.Events.estudianteCreado;
import Estudiante.Events.estudianteEditado;
import Estudiante.Events.estudianteEliminado;
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

       apply((estudianteEditado event)->{
           estudiante.suscripcionId=null;
       });

       apply((estudianteEliminado evento) ->{
           estudiante.estudiante = null;

       });




   }

}
