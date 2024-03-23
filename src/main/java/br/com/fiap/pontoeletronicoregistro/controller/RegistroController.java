package br.com.fiap.pontoeletronicoregistro.controller;

import br.com.fiap.pontoeletronicoregistro.domain.dto.RegistroPontoDto;
import br.com.fiap.pontoeletronicoregistro.service.RegistroService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/v1/pontos-eletronicos")
public class RegistroController {

    private final RegistroService registroService;

    public RegistroController(final RegistroService registroService) {
        this.registroService = registroService;
    }

    @PostMapping
    public ResponseEntity<RegistroPontoDto> registrarPonto() {
        RegistroPontoDto registroPontoDto = registroService.registrarPonto("af9ee2ac-29b2-4e53-805d-967e16c405ac",
                LocalDateTime.now());
        return new ResponseEntity<>(registroPontoDto, HttpStatus.CREATED);
    }

}
