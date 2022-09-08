package com.morgado.os.Domain;

import lombok.*;
import org.hibernate.validator.constraints.br.CPF;

import javax.persistence.Id;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public abstract class Pessoa {

    @Id
    private Integer id;
    private String nome;
    @CPF
    private String cpf;
    private String telefone;

}
