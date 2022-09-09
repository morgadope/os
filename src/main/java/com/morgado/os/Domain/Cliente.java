package com.morgado.os.Domain;

import org.hibernate.validator.constraints.br.CPF;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
@Entity
public class Cliente extends Pessoa implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;
    @OneToMany(mappedBy = "cliente")
    private List<OS> list = new ArrayList<>();

    public List<OS> getList() {
        return list;
    }

    public List<OS> setList() {
        return list;
    }

    public Cliente() {
        super();
    }

    public Cliente(Integer id, String nome, @CPF String cpf, String telefone) {
        super(id, nome, cpf, telefone);

    }

}
