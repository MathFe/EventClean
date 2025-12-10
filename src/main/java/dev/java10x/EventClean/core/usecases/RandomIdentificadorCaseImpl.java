package dev.java10x.EventClean.core.usecases;

import dev.java10x.EventClean.core.gateway.EventoGateway;

import java.security.SecureRandom;

public class RandomIdentificadorCaseImpl implements RandomIdentificadorCase{

    private final EventoGateway eventoGateway;

    public RandomIdentificadorCaseImpl(EventoGateway eventoGateway) {
        this.eventoGateway = eventoGateway;
    }

    @Override
    public String execute() {
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        SecureRandom secureRandom = new SecureRandom();
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < 6 ; i++) {
            int index = secureRandom.nextInt(characters.length());
            result.append(characters.charAt(index));
        }


        return result.toString();

    }
}
