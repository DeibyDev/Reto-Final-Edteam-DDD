package Genericos;

import co.com.sofka.domain.generic.ValueObject;

public class Correo implements ValueObject<String> {

    private final String value;

    public Correo(String value) {
        this.value = value;
    }

    @Override
    public String value() {
        return value;
    }
}
