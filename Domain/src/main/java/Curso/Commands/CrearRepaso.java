package Curso.Commands;

import Curso.Identitis.CursoId;
import Estudiante.Estudiante;
import Estudiante.Identities.EstudianteId;
import Factory.LessonFactory;
import co.com.sofka.domain.generic.Command;

public class CrearRepaso extends Command {

    private final LessonFactory lessonFactory;
    private final CursoId cursoId;

    public CrearRepaso(LessonFactory lessonFactory, CursoId cursoId) {
        this.lessonFactory = lessonFactory;
        this.cursoId = cursoId;
    }

    public LessonFactory getLessonFactory() {
        return lessonFactory;
    }

    public CursoId getCursoId() {
        return cursoId;
    }
}
