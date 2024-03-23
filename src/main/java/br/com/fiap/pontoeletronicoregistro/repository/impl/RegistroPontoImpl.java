package br.com.fiap.pontoeletronicoregistro.repository.impl;

import br.com.fiap.pontoeletronicoregistro.domain.RegistroPonto;
import br.com.fiap.pontoeletronicoregistro.domain.RegistroPontoMapper;
import br.com.fiap.pontoeletronicoregistro.domain.entity.RegistroPontoEntity;
import br.com.fiap.pontoeletronicoregistro.domain.enums.TipoRegistro;
import br.com.fiap.pontoeletronicoregistro.repository.RegistroPontoRepository;
import br.com.fiap.pontoeletronicoregistro.repository.jpa.RegistroPontoJpa;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public class RegistroPontoImpl implements RegistroPontoRepository {

    private final RegistroPontoJpa registroPontoJpa;

    private static final int SAIDA = 2;

    public RegistroPontoImpl(final RegistroPontoJpa registroPontoJpa) {
        this.registroPontoJpa = registroPontoJpa;
    }

    @Override
    public RegistroPonto save(RegistroPonto registroPonto) {
        RegistroPontoEntity registroPontoEntity = registroPontoJpa.save(RegistroPontoMapper.registroPontoToEntity(registroPonto));
        return RegistroPontoMapper.entityToRegistroPonto(registroPontoEntity);
    }

    @Override
    public String getUltimoTipoRegistroDoDia(String funcionarioId) {
        Integer ultimoTipoRegistroDoDia = registroPontoJpa.getTipoRegistroByFuncionarioIdOrderByDataHoraRegistroDesc(UUID.fromString(funcionarioId));
        return TipoRegistro.getByCodigo(ultimoTipoRegistroDoDia == null ? SAIDA : ultimoTipoRegistroDoDia).name();
    }
}
