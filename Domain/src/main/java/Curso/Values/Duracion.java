package Curso.Values;

import co.com.sofka.domain.generic.ValueObject;

public class Duracion implements ValueObject<String> {

    private final String value;

    public Duracion(String value) {
        this.value = value;
    }

    @Override
    public String value() {
        return value;
    }
}
