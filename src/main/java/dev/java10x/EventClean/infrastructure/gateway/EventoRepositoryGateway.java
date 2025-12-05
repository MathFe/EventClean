package dev.java10x.EventClean.infrastructure.gateway;

import dev.java10x.EventClean.core.entities.Evento;
import dev.java10x.EventClean.core.gateway.EventoGateway;
import dev.java10x.EventClean.infrastructure.dtos.EventoDto;
import dev.java10x.EventClean.infrastructure.mapper.EventoDtoMapper;
import dev.java10x.EventClean.infrastructure.mapper.EventoEntityMapper;
import dev.java10x.EventClean.infrastructure.persistence.EventoEntity;
import dev.java10x.EventClean.infrastructure.persistence.EventoRepository;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Transactional
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

    @Override
    public List<Evento> buscarEventos() {
        List<EventoEntity> buscarEventos = eventoRepository.findAll();
        return buscarEventos.stream()
                .map(mapper::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public boolean existePorIdentificador(String identificador) {
        return eventoRepository.findAll().stream()
                .anyMatch(evento -> evento.getIdentificador().equalsIgnoreCase(identificador));
    }

    @Override
    public Optional<Evento> filtroIdentificador(String identificador) {
        return eventoRepository.findEventoByIdentificador(identificador);
    }
}
