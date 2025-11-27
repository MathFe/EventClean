package dev.java10x.EventClean.core.usecases;

import dev.java10x.EventClean.core.entities.Evento;
import dev.java10x.EventClean.core.gateway.EventoGateway;

public class CriarEventoCaseImpl implements CriarEventoCase {

    private final EventoGateway eventoGateway;

    public CriarEventoCaseImpl(EventoGateway eventoGateway) {
        this.eventoGateway = eventoGateway;
    }

    @Override
    public Evento execute(Evento evento) {
        return eventoGateway.criarEvento(evento);
    }
}
