package dev.java10x.EventClean.infrastructure.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class ControllerExceptionsHandler {

    @ExceptionHandler(DuplicateEventException.class)
    public ResponseEntity<Map<String, String>> handleDuplicateEventExceptions(DuplicateEventException exception) {
        Map<String, String> response =  new HashMap<>();
        response.put("Erro: ", exception.getMessage());
        response.put("Mensagem: ","Por favor, insira uma hashId válida para o seu evento e tente novamente");
    return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }
}
