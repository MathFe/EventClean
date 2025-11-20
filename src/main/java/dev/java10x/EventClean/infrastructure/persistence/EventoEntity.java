package dev.java10x.EventClean.infrastructure.persistence;

import dev.java10x.EventClean.core.enums.TipoEvento;

import java.time.LocalDateTime;

public record Evento(Long id, String name, String descricao, LocalDateTime dataInicio, LocalDateTime dataFim, String identificador, String local, Integer capacidade, TipoEvento tipo) {
}
