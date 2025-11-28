package dev.java10x.EventClean.core.usecases;

import dev.java10x.EventClean.core.entities.Evento;

import java.util.List;

public interface BuscarEventoCase {

    List<Evento> execute();
}
