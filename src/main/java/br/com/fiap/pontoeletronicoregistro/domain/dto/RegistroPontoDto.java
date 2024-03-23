package br.com.fiap.pontoeletronicoregistro.domain.dto;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Builder
public class RegistroPontoDto {
    private UUID id;

    private LocalDateTime dataHoraRegistro;

    private String tipoRegistro;
}
