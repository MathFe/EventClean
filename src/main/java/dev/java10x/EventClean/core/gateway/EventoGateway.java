package dev.java10x.EventClean.core.gateway;

import dev.java10x.EventClean.core.entities.Evento;

public interface EventoGateway {


    // Contrato
    Evento criarEvento(Evento evento);
}
