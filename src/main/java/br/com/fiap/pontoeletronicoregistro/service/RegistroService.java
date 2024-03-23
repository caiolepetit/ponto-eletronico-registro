package br.com.fiap.pontoeletronicoregistro.service;

import br.com.fiap.pontoeletronicoregistro.domain.RegistroPonto;
import br.com.fiap.pontoeletronicoregistro.domain.RegistroPontoMapper;
import br.com.fiap.pontoeletronicoregistro.domain.dto.RegistroPontoDto;
import br.com.fiap.pontoeletronicoregistro.domain.enums.TipoRegistro;
import br.com.fiap.pontoeletronicoregistro.repository.RegistroPontoRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class RegistroService {

    private final RegistroPontoRepository registroPontoRepository;

    public RegistroService(RegistroPontoRepository registroPontoRepository) {
        this.registroPontoRepository = registroPontoRepository;
    }

    public RegistroPontoDto registrarPonto(String funcionarioId, LocalDateTime now) {
        String proximoTipoRegistro = capturarProximoTipoRegistro(registroPontoRepository.getUltimoTipoRegistroDoDia(funcionarioId));
        RegistroPonto registroPonto = registroPontoRepository.save(RegistroPontoMapper.formToRegistroPonto(funcionarioId, now, proximoTipoRegistro));
        return RegistroPontoMapper.registroPontoToDto(registroPonto);
    }

    private String capturarProximoTipoRegistro(String ultimoTipoRegistroDoDia) {
        return ultimoTipoRegistroDoDia.equals(TipoRegistro.ENTRADA.name()) ? TipoRegistro.SAIDA.name() : TipoRegistro.ENTRADA.name();
    }
}
