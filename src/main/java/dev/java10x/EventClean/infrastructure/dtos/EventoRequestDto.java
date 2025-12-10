package dev.java10x.EventClean.infrastructure.dtos;

import dev.java10x.EventClean.core.enums.TipoEvento;

import java.time.LocalDateTime;

public record EventoRequestDto(
        String nome,
        String descricao,
        LocalDateTime dataInicio,
        LocalDateTime dataFim,
        String localEvento,
        Integer capacidade,
        String organizador,
        TipoEvento tipoEvento
) {}
