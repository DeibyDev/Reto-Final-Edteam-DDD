package Curso.Values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;


public class TipoCategorias implements ValueObject<TipoCategorias.Types> {
    private final Types type;

    public TipoCategorias(Types type) {
        this.type = type;
    }

    @Override
    public Types value() {
        return type;
    }

    public enum Types {
        DESARROLLO, REDES , CRECIMIENTOPERSONAL
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TipoCategorias)) return false;
        TipoCategorias that = (TipoCategorias) o;
        return type.equals(that.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(type);
    }
}
