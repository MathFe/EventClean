package dev.java10x.EventClean.core.gateway;

import dev.java10x.EventClean.core.entities.Evento;
import dev.java10x.EventClean.infrastructure.persistence.EventoEntity;

import java.util.List;

public interface EventoGateway {

    // Contrato
    Evento criarEvento(Evento evento);
    List<Evento> buscarEventos();
    boolean existePorIdentificador(String identificador);
    Evento filtroIdentificador(String identificador);
}
