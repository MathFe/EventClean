package dev.java10x.EventClean.infrastructure.mapper;

import dev.java10x.EventClean.core.entities.Evento;
import dev.java10x.EventClean.infrastructure.dtos.EventoDto;
import dev.java10x.EventClean.infrastructure.dtos.EventoResponseDto;
import org.springframework.stereotype.Component;

@Component
public class EventoDtoMapper {

    public Evento toEntity(EventoDto evento){

        return new Evento(
                null,
                evento.nome(),
                evento.descricao(),
                null,
                evento.dataInicio(),
                evento.dataFim(),
                evento.localEvento(),
                evento.capacidade(),
                evento.organizador(),
                evento.tipoEvento()
                );

    }

    public EventoResponseDto toResponseDto(Evento evento){
        return new EventoResponseDto(
                evento.id(),
                evento.nome(),
                evento.descricao(),
                evento.identificador(),
                evento.dataInicio(),
                evento.dataFim(),
                evento.localEvento(),
                evento.capacidade(),
                evento.organizador(),
                evento.tipoEvento()
        );
    }
}
