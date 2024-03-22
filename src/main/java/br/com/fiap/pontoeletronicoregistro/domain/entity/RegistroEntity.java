package br.com.fiap.pontoeletronicoregistro.domain.entity;

import br.com.fiap.pontoeletronicoregistro.domain.enums.TipoRegistro;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
public class RegistroEntity {

    @Id
    private UUID id;

    private UUID funcionarioId;

    private LocalDateTime dataHoraRegistro;

    private int tipoRegistro;

}
