package dev.java10x.EventClean.infrastructure.persistence;

import dev.java10x.EventClean.core.entities.Evento;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EventoRepository extends JpaRepository<EventoEntity, Long> {

    public EventoEntity findEventoByIdentificador (String identificador);
}
