package dev.java10x.EventClean.core.usecases;

import dev.java10x.EventClean.core.entities.Evento;
import dev.java10x.EventClean.core.gateway.EventoGateway;
import dev.java10x.EventClean.infrastructure.exception.NotFoundEventException;

public class FiltroIdentificadorCaseImpl implements FiltroIdentificadorCase{

    private final EventoGateway eventoGateway;

    public FiltroIdentificadorCaseImpl(EventoGateway eventoGateway) {
        this.eventoGateway = eventoGateway;
    }

    @Override
    public Evento execute(String identificador) {
        return eventoGateway.filtroIdentificador(identificador)
                .orElseThrow(() -> new NotFoundEventException("Evento com identificador: " + identificador + " não encontrado."));
    }
}
