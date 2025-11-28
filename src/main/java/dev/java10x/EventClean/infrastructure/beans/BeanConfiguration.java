package dev.java10x.EventClean.infrastructure.beans;

import dev.java10x.EventClean.core.gateway.EventoGateway;
import dev.java10x.EventClean.core.usecases.BuscarEventoCase;
import dev.java10x.EventClean.core.usecases.BuscarEventoCaseImpl;
import dev.java10x.EventClean.core.usecases.CriarEventoCase;
import dev.java10x.EventClean.core.usecases.CriarEventoCaseImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfiguration {

    @Bean
    public CriarEventoCase criarEventoCase(EventoGateway eventoGateway) {
        return new CriarEventoCaseImpl(eventoGateway);
    }

    @Bean
    public BuscarEventoCase buscarEventoCase(EventoGateway eventoGateway) {
        return new BuscarEventoCaseImpl(eventoGateway);
    }
}
