package br.com.fiap.pontoeletronicoregistro.controller;

import br.com.fiap.pontoeletronicoregistro.service.RegistroService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/v1/ponto-eletronico")
public class RegistroController {

    private final RegistroService registroService;

    public RegistroController(final RegistroService registroService) {
        this.registroService = registroService;
    }

    @PostMapping
    public ResponseEntity<Object> registrarPonto() {
        registroService.registrarPonto(LocalDateTime.now());
    }

}
