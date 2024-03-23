package br.com.fiap.pontoeletronicoregistro.domain;

import br.com.fiap.pontoeletronicoregistro.domain.enums.TipoRegistro;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RegistroPonto {
    private UUID id;

    private UUID funcionarioId;

    private LocalDateTime dataHoraRegistro;

    private TipoRegistro tipoRegistro;
}
