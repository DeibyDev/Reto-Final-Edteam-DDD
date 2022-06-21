package Curso.Values;

import co.com.sofka.domain.generic.ValueObject;

public class Resena implements ValueObject<String> {

    private final String value;

    public Resena(String value) {
        this.value = value;
    }

    @Override
    public String value() {
        return value;
    }
}
