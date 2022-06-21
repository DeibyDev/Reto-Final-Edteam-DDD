package Factory;

import Curso.Entities.Refuerzos;
import Curso.Identitis.RefuerzosId;
import Curso.Values.Contenido;
import Curso.Values.TipoCategorias;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class LessonFactory {

    private final Set<Refuerzos> refuerzos;
    private static LessonFactory instance;

    private LessonFactory(){
        refuerzos = new HashSet<>();
    }

    public static LessonFactory getInstance(){
        if(Objects.isNull(instance)){
            instance = new LessonFactory();
            return instance;
        }
        return instance;
    }

    public LessonFactory add(RefuerzosId RefuerzosId, Contenido contenido, TipoCategorias tipoCategorias){
        refuerzos.add(new Refuerzos(RefuerzosId, contenido, tipoCategorias));
        return this;
    }

    public Set<Refuerzos> refuerzos() {
        return refuerzos;
    }
}