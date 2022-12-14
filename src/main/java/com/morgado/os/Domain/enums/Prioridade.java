package com.morgado.os.Domain.enums;


import lombok.Getter;

public enum Prioridade {

    BAIXA(0, "BAIXA"), MEDIA(1, "MEDIA"), ALTA(2, "ALTA");
    @Getter
    private final Integer codigo;
    @Getter
    private final String descricao;

    Prioridade(Integer codigo, String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
    }

    public static Prioridade toEnum(Integer cod) {

        if (cod == null) {
            return null;
        }

        for (Prioridade x : Prioridade.values()) {
            if (cod.equals(x.getCodigo())) {
                return x;
            }
        }

        throw new IllegalArgumentException("Código de Perfil inválido! " + cod);
    }

}

