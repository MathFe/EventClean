package dev.java10x.EventClean.core.usecases;

import dev.java10x.EventClean.core.entities.Evento;
import dev.java10x.EventClean.core.gateway.EventoGateway;

public class CriarEventoCaseImpl implements CriarEventoCase {

    private final EventoGateway eventoGateway;
    private final RandomIdentificadorCase randomIdentificadorCase;

    public CriarEventoCaseImpl(EventoGateway eventoGateway, RandomIdentificadorCase randomIdentificadorCase) {
        this.eventoGateway = eventoGateway;
        this.randomIdentificadorCase = randomIdentificadorCase;
    }

    @Override
    public Evento execute(Evento evento) {

        // 1) Gera um identificador aleatório
        String identificadorGerado;

        do {
            identificadorGerado = randomIdentificadorCase.execute();
            // repete até achar um que não exista
        } while (eventoGateway.existePorIdentificador(identificadorGerado));

        // 2) Cria um novo objeto Evento incluindo o identificador gerado
        Evento eventoComId = new Evento(
                evento.id(),
                evento.nome(),
                evento.descricao(),
                identificadorGerado,
                evento.dataInicio(),
                evento.dataFim(),
                evento.localEvento(),
                evento.capacidade(),
                evento.organizador(),
                evento.tipoEvento()
        );

        // 3) Salva no banco
        return eventoGateway.criarEvento(eventoComId);
    }

}
