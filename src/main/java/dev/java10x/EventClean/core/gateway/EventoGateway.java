package dev.java10x.EventClean.core.gateway;

import dev.java10x.EventClean.core.entities.Evento;
import dev.java10x.EventClean.infrastructure.persistence.EventoEntity;

import java.util.List;
import java.util.Optional;

public interface EventoGateway {

    // Contrato
    Evento criarEvento(Evento evento);
    List<Evento> buscarEventos();
    boolean existePorIdentificador(String identificador);
    Optional<Evento> filtroIdentificador(String identificador);
}
