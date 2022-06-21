package Curso.Values;

import co.com.sofka.domain.generic.ValueObject;

public class Idioma implements ValueObject<String> {

    private final String value;

    public Idioma(String value) {
        this.value = value;
    }

    @Override
    public String value() {
        return value;
    }
}
