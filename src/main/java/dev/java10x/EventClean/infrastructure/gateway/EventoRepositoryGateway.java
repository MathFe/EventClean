package dev.java10x.EventClean.infrastructure.gateway;

import dev.java10x.EventClean.core.entities.Evento;
import dev.java10x.EventClean.core.gateway.EventoGateway;
import dev.java10x.EventClean.infrastructure.mapper.EventoEntityMapper;
import dev.java10x.EventClean.infrastructure.persistence.EventoEntity;
import dev.java10x.EventClean.infrastructure.persistence.EventoRepository;
import org.springframework.stereotype.Component;


@Component
public class EventoRepositoryGateway implements EventoGateway {

    private final EventoRepository eventoRepository;
    private final EventoEntityMapper mapper;

    public EventoRepositoryGateway(EventoRepository eventoRepository, EventoEntityMapper mapper) {
        this.eventoRepository = eventoRepository;
        this.mapper = mapper;
    }

    @Override
    public Evento criarEvento(Evento evento) {
        EventoEntity entity = mapper.toEntity(evento);
        EventoEntity novoEvento = eventoRepository.save(entity);
        return mapper.toDomain(novoEvento);
    }
}
