package br.com.fiap.pontoeletronicoregistro.repository;

import br.com.fiap.pontoeletronicoregistro.domain.RegistroPonto;

public interface RegistroPontoRepository {

    RegistroPonto save(RegistroPonto registroPonto);

    String getUltimoTipoRegistroDoDia(String funcionarioId);
}
