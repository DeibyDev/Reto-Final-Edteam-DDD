package Curso.Values;

import co.com.sofka.domain.generic.ValueObject;

public class Contenido implements ValueObject<String> {

    private final String value;

    public Contenido(String value) {

        this.value = value;
    }

    @Override
    public String value() {
        return value;
    }
}
