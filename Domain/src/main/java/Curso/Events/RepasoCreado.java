package Curso.Events;

import Curso.Identitis.RefuerzosId;
import Curso.Values.Contenido;
import Curso.Values.TipoCategorias;
import co.com.sofka.domain.generic.DomainEvent;

public class RepasoCreado  extends DomainEvent {
    private final RefuerzosId refuerzosId;
    private final Contenido Contenido;
    private final TipoCategorias tipoCategorias;


    public RepasoCreado(RefuerzosId refuerzosId, Contenido Contenido, TipoCategorias tipoCategorias) {
        super("Curso.RepasoCreado");
         this.refuerzosId=refuerzosId;
         this.Contenido=Contenido;
         this.tipoCategorias=tipoCategorias;
    }

    public RefuerzosId getRefuerzosId() {
        return refuerzosId;
    }

    public Curso.Values.Contenido getContenido() {
        return Contenido;
    }

    public TipoCategorias getTipoCategorias() {
        return tipoCategorias;
    }
}
