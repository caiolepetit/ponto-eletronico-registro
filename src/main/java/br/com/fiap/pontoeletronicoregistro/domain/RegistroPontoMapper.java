package br.com.fiap.pontoeletronicoregistro.domain;

import br.com.fiap.pontoeletronicoregistro.domain.dto.RegistroPontoDto;
import br.com.fiap.pontoeletronicoregistro.domain.entity.RegistroPontoEntity;
import br.com.fiap.pontoeletronicoregistro.domain.enums.TipoRegistro;

import java.time.LocalDateTime;
import java.util.UUID;

public class RegistroPontoMapper {

    private RegistroPontoMapper() {
        throw new IllegalStateException("Utility class");
    }
    public static RegistroPontoDto registroPontoToDto(final RegistroPonto registroPonto) {
        return RegistroPontoDto.builder()
                .id(registroPonto.getId())
                .dataHoraRegistro(registroPonto.getDataHoraRegistro())
                .tipoRegistro(registroPonto.getTipoRegistro().name()).build();
    }

    public static RegistroPonto entityToRegistroPonto(final RegistroPontoEntity registroPontoEntity) {
        return RegistroPonto.builder()
                .id(registroPontoEntity.getId())
                .funcionarioId(registroPontoEntity.getFuncionarioId())
                .dataHoraRegistro(registroPontoEntity.getDataHoraRegistro())
                .tipoRegistro(TipoRegistro.getByCodigo(registroPontoEntity.getTipoRegistro())).build();
    }


    public static RegistroPonto formToRegistroPonto(String funcionarioId, LocalDateTime now, String tipoRegistro) {
        return RegistroPonto.builder().funcionarioId(UUID.fromString(funcionarioId))
                .tipoRegistro(TipoRegistro.valueOf(tipoRegistro))
                .dataHoraRegistro(now).build();
    }

    public static RegistroPontoEntity registroPontoToEntity(RegistroPonto registroPonto) {
        return RegistroPontoEntity.builder()
                .funcionarioId(registroPonto.getFuncionarioId())
                .dataHoraRegistro(registroPonto.getDataHoraRegistro())
                .tipoRegistro(registroPonto.getTipoRegistro().getCodigo()).build();
    }
}
