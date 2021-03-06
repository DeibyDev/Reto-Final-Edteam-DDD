package Genericos;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Fullname implements ValueObject<String> {

    private final String value;

    public Fullname(String value) {
        this.value = Objects.requireNonNull(value);
        if(value.isBlank()){
            throw new IllegalArgumentException("No puede estar en blanco");
        }
    }

    @Override
    public String value() {
        return value;
    }
}
