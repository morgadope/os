package com.morgado.os.Domain;

import lombok.*;
import org.hibernate.validator.constraints.br.CPF;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public abstract class Pessoa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Integer id;
    private String nome;
    @CPF
    private String cpf;
    private String telefone;

}
