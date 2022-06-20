package Docente;

import Docente.Entities.Especialidad;
import Docente.Events.DocenteCreado;
import Docente.Events.DocenteEditado;
import Docente.Values.tipoEspecialidad;
import co.com.sofka.domain.generic.EventChange;

public class DocenteChange extends EventChange {
   public DocenteChange (Docente docente){
       apply((DocenteCreado event)->{
           docente.especialidad = null;
       });

       apply((DocenteEditado event) -> {
           docente.editarDocente(event.getDocenteId(),event.getCorreo(),event.getFullname(),event.getIdentificacion());
       });

   }

}
