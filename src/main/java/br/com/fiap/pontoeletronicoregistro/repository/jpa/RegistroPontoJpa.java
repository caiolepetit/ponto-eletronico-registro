package br.com.fiap.pontoeletronicoregistro.repository.jpa;

import br.com.fiap.pontoeletronicoregistro.domain.entity.RegistroPontoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.UUID;

public interface RegistroPontoJpa extends JpaRepository<RegistroPontoEntity, UUID> {
    @Query(value = "SELECT tipo_registro FROM registro_ponto WHERE funcionario_id = ?1 ORDER BY data_hora_registro DESC LIMIT 1", nativeQuery = true)
    Integer getTipoRegistroByFuncionarioIdOrderByDataHoraRegistroDesc(UUID funcionarioId);
}
