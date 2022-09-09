package com.morgado.os.Domain.enums;

import lombok.Getter;

public enum Status {

    ABERTO(0, "ABERTO"), ANDAMENTO(1, "ANDAMENTO"), ENCERRADO(2, "ENCERRADO");
    @Getter
    private final Integer codigo;
    @Getter
    private final String descricao;

    Status(Integer codigo, String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
    }

    public static Status toEnum(Integer cod) {

        if (cod == null) {
            return null;
        }

        for (Status x : Status.values()) {
            if (cod.equals(x.getCodigo())) {
                return x;
            }
        }
        throw new IllegalArgumentException("Código de Perfil inválido! " + cod);
    }


}
