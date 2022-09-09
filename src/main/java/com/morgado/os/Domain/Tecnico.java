package com.morgado.os.Domain;

import com.morgado.os.Domain.enums.Perfil;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;


@Entity
@Getter
@Setter
public class Tecnico implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nome;

    @Column(unique = true)
    private String cpf;

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "PERFIS")
    private Set<Integer> perfis = new HashSet<>();

    @OneToMany(mappedBy = "tecnico")
    private List<OrdemDeServico> osList = new ArrayList<>();

    public Tecnico() {
        super();
        addPerfil(Perfil.PADRAO);
    }

    public Tecnico(Integer id, String nome, String cpf) {
        super();
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        addPerfil(Perfil.PADRAO);
    }

    public Set<Perfil> getPerfis() {
        return perfis.stream().map(x -> Perfil.toEnum(x)).collect(Collectors.toSet());
    }

    public void addPerfil(Perfil perfil) {
        this.perfis.add(perfil.getCodigo());
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Tecnico other = (Tecnico) obj;
        if (id == null) {
            return other.id == null;
        } else return id.equals(other.id);
    }

}