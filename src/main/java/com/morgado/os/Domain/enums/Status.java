package com.morgado.os.Domain.enums;

import lombok.Getter;

@Getter
public enum Status {

    ABERTO(0, "ABERTO"),
    ANDAMENTO(0, "ANDAMENTO"),
    ENCERRRADO(1, "ENCERRRADO");


    Status(Integer cod, String descricao) {
        this.cod = cod;
        this.descricao = descricao;
    }

    private final Integer cod;
    private final String descricao;

    public static Status toEnunm(Integer cod) {
        if (cod == null) {
            return null;
        }
        for (Status x : Status.values()) {
            if (cod.equals((x.getCod()))) {
                return x;
            }
        }
        throw new IllegalArgumentException("Prioridade não encontrada");
    }
}



