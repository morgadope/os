package com.morgado.os.Domain.enums;

import lombok.Getter;

import javax.persistence.GeneratedValue;

public enum Perfil {

    ADMIN(1, "ROLE_ADMIN"), PADRAO(2, "ROLE_PADRAO");
    @Getter
    private final Integer codigo;
    @Getter
    private final String descricao;

    Perfil(Integer codigo, String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
    }

    public static Perfil toEnum(Integer cod) {

        if (cod == null) {
            return null;
        }

        for (Perfil x : Perfil.values()) {
            if (cod.equals(x.getCodigo())) {
                return x;
            }
        }

        throw new IllegalArgumentException("Código inválido! " + cod);
    }

}