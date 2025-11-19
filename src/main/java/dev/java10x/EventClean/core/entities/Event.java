package dev.java10x.EventClean.core.entities;

import java.util.Date;


public record Event(String name, String descricao, Date inicio, Date fim, String identificador, String local, Integer capacidade, String tipo) {





    // nome, descricao, inicio, fim, identificador, local, capacidade, tipo
}
