package dev.java10x.EventClean.core.entities;

import dev.java10x.EventClean.core.enums.TipoEvento;

import java.time.LocalDateTime;


public record Evento(Long id, String name, String descricao, LocalDateTime dataInicio, LocalDateTime dataFim, String identificador, String local, Integer capacidade, TipoEvento tipo) {





    // nome, descricao, inicio, fim, identificador, local, capacidade, tipo
}
