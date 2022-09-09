package com.morgado.os.Domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.morgado.os.Domain.enums.Prioridade;
import com.morgado.os.Domain.enums.Status;
import lombok.Getter;
import lombok.Setter;
import org.jetbrains.annotations.NotNull;

import javax.persistence.*;
import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;


@Entity
@Getter
@Setter
public class OrdemDeServico implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @JsonFormat(pattern = "dd/MM/yyyy HH:mm")
    private LocalDateTime dataAbertura;

    @JsonFormat(pattern = "dd/MM/yyyy HH:mm")
    private LocalDateTime dataFechamento;

    private Integer prioridade;
    private String observacoes;
    private Integer status;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "tecnico_id")
    private Tecnico tecnico;
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;

    public OrdemDeServico() {
        super();
        this.setPrioridade(Prioridade.BAIXA);
        this.setStatus(Status.ABERTO);
        this.dataAbertura = LocalDateTime.now();
    }

    public OrdemDeServico(Integer id, String observacoes, Tecnico tecnico, Cliente cliente) {
        super();
        this.id = id;
        this.observacoes = observacoes;
        this.tecnico = tecnico;
        this.cliente = cliente;

        this.setPrioridade(Prioridade.BAIXA);
        this.setStatus(Status.ABERTO);
        this.dataAbertura = LocalDateTime.now();
    }


    public Prioridade getPrioridade() {
        return Prioridade.toEnum(this.prioridade);
    }

    public void setPrioridade(@NotNull Prioridade prioridade) {
        this.prioridade = prioridade.getCodigo();
    }


    public Status getStatus() {
        return Status.toEnum(status);
    }

    public void setStatus(Status status) {
        this.status = status.getCodigo();
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
        OrdemDeServico other = (OrdemDeServico) obj;
        if (id == null) {
            return other.id == null;
        } else return id.equals(other.id);
    }

}