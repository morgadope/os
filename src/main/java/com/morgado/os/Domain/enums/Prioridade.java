package com.morgado.os.Domain.enums;

import lombok.Getter;


@Getter
public enum Prioridade {

    BAIXA(0, "BAIXA"),
    MEDIA(1, "MEDIA"),
    ALTA(2, "ALTA");

    Prioridade(Integer cod, String descricao) {
        this.cod = cod;
        this.descricao = descricao;
    }

    private final Integer cod;
    private final String descricao;

    public static Prioridade toEnunm(Integer cod) {
        if (cod == null) {
            return null;
        }
        for (Prioridade x : Prioridade.values()) {
            if (cod.equals((x.getCod()))) {
                return x;
            }
        }
        throw new IllegalArgumentException("Prioridade não encontrada");
    }
}


