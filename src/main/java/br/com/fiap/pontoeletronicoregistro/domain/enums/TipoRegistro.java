package br.com.fiap.pontoeletronicoregistro.domain.enums;

import lombok.Getter;

import java.util.Arrays;

@Getter
public enum TipoRegistro {
    ENTRADA(1), SAIDA(2);

    private final int codigo;

    TipoRegistro(int codigo) {
        this.codigo = codigo;
    }

    public static TipoRegistro getByCodigo(int codigo) {
        return Arrays.stream(TipoRegistro.values()).filter(tipoRegistro -> tipoRegistro.getCodigo() == codigo).findFirst()
                .orElseThrow(() -> new RuntimeException("Não foi encontrado o tipo de registro"));
    }
}
