package Docente.Values;

import co.com.sofka.domain.generic.ValueObject;

public class tipoEspecialidad implements ValueObject<String> {
    private final String descripcion;

    public tipoEspecialidad(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public String value() {
        return this.descripcion;
    }
}
