package com.morgado.os.Domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.morgado.os.Domain.enums.Prioridade;
import com.morgado.os.Domain.enums.Status;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;


@Getter
@Setter
@AllArgsConstructor
@EqualsAndHashCode
@Entity
public class OS {

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
    @ManyToOne
    @JoinColumn(name = "tecnico_id")
    private Tecnico tecnico;
    @ManyToOne
    @JoinColumn(name = "client_id")
    private Cliente cliente;

    public OS(Prioridade prioridade, Status status) {
        this.prioridade = (prioridade == null) ? 0 : prioridade.getCod();
        this.status = (status == null) ? 0 : status.getCod();
    }

    public Prioridade getPrioridade() {
        return Prioridade.toEnunm(this.prioridade);
    }

    public Status getStatus() {
        return Status.toEnunm(this.status);
    }

    public void setPrioridade(Prioridade prioridade) {
        this.prioridade = prioridade.getCod();
    }

    public void setStatus(Status status) {
        this.status = status.getCod();
    }

    public void setDataAbertura(LocalDateTime dataAbertura) {
        this.setDataAbertura(LocalDateTime.now());
    }


    public OS() {
        super();
        this.setDataAbertura(LocalDateTime.now());
        this.setPrioridade(Prioridade.BAIXA);
        this.setStatus(Status.ABERTO);
    }
}
