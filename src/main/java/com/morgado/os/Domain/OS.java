package com.morgado.os.Domain;

import com.morgado.os.Domain.enums.Prioridade;
import com.morgado.os.Domain.enums.Status;
import lombok.*;

import javax.persistence.Id;
import java.time.LocalDateTime;


@Getter
@Setter
@AllArgsConstructor
@EqualsAndHashCode
public class OS {

    @Id
    private Integer id;
    private LocalDateTime dataAbertura;
    private LocalDateTime dataFechamento;
    private Integer prioridade;
    private String observacoes;
    private Integer status;
    private Tecnico tecnico;
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
