package dev.java10x.EventClean.infrastructure.gateway;

import dev.java10x.EventClean.core.entities.Evento;
import dev.java10x.EventClean.core.gateway.EventoGateway;
import dev.java10x.EventClean.infrastructure.persistence.EventoRepository;
import org.springframework.stereotype.Component;


@Component
public class EventoRepositoryGateway implements EventoGateway {

    private final EventoRepository eventoRepository;

    public EventoRepositoryGateway(EventoRepository eventoRepository) {
        this.eventoRepository = eventoRepository;
    }

    @Override
    public Evento criarEvento(Evento evento) {
        return eventoRepository.save(evento);
    }
}
