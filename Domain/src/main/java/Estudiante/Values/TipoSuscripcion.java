package Estudiante.Values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;


public class TipoSuscripcion implements ValueObject<TipoSuscripcion.Types> {
    private final Types type;

    public TipoSuscripcion(Types type) {
        this.type = type;
    }

    @Override
    public Types value() {
        return type;
    }

    public enum Types {
        PREMIUM, FREE
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TipoSuscripcion)) return false;
        TipoSuscripcion that = (TipoSuscripcion) o;
        return type.equals(that.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(type);
    }
}
