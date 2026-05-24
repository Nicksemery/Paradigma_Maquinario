package maquinario.api.domain.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Table(name = "ClienteMaquina")
@Getter
@NoArgsConstructor
public class ClienteMaquina {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_clienteMaquina;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idCliente")
    private Cliente idCliente;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idMaquina")
    private Maquina idMaquina;

    @Column(name = "dataInicio")
    private Date dataInicio;

    @Column(name = "dataFim")
    private Date dataFim;
    private String situacao;

    @Column(name = "valorTotal")
    private Double valorTotal;
    private Boolean ativo;

    public ClienteMaquina(Cliente idCliente, Maquina idMaquina, Date date, Date date1, String situacao, Double aDouble) {
        this.idCliente = idCliente;
        this.idMaquina = idMaquina;
        this.dataInicio = date;
        this.dataFim = date1;
        this.situacao = situacao;
        this.valorTotal = aDouble;
        this.ativo = true;
    }


    public void atualizarDados(Date dataInicio, Date dataFim, String situacao, Double valorTotal) {
        if(dataInicio != null) {
            this.dataInicio = dataInicio;
        }
        if(dataFim != null) {
            this.dataFim = dataFim;
        }
        if(situacao != null) {
            this.situacao = situacao;
        }
        if(valorTotal != null) {
            this.valorTotal = valorTotal;
        }

    }

    public void desativarTransacao(){
        this.ativo = false;
    }

}
