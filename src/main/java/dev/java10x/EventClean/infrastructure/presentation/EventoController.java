package dev.java10x.EventClean.infrastructure.presentation;

import dev.java10x.EventClean.core.entities.Evento;
import dev.java10x.EventClean.core.usecases.BuscarEventoCase;
import dev.java10x.EventClean.core.usecases.CriarEventoCase;
import dev.java10x.EventClean.infrastructure.dtos.EventoDto;
import dev.java10x.EventClean.infrastructure.mapper.EventoDtoMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("api/v1/")

public class EventoController {

    private final CriarEventoCase criarEventoCase;
    private final EventoDtoMapper eventoDtoMapper;
    private final BuscarEventoCase buscarEventoCase;


    public EventoController(CriarEventoCase criarEventoCase, EventoDtoMapper eventoDtoMapper, BuscarEventoCase buscarEventoCase) {
        this.criarEventoCase = criarEventoCase;
        this.eventoDtoMapper = eventoDtoMapper;
        this.buscarEventoCase = buscarEventoCase;
    }

    @PostMapping("criarevento")
    public ResponseEntity<Map<String, Object>> criarEvento(@RequestBody EventoDto eventoDto) {
        Evento novoEvento = criarEventoCase.execute(eventoDtoMapper.toEntity(eventoDto));
        Map<String, Object> response = new HashMap<>();
        response.put("Mensagem: ","Evento cadastrado com sucesso no nosso banco de dados");
        response.put("Dados do evento: ",eventoDtoMapper.toDto(novoEvento));
        return ResponseEntity.ok(response);
    }

    @GetMapping("buscareventos")
    public List<EventoDto> listarEvento() {
        List<Evento> eventos = buscarEventoCase.execute();
        List<EventoDto> eventosDto = eventos.stream()
                .map(eventoDtoMapper::toDto)
                .collect(Collectors.toList());
        return eventosDto;
    }

}
