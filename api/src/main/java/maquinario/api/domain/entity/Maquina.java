package maquinario.api.domain.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "maquina")
@Getter
@NoArgsConstructor
public class Maquina {

    public Maquina(String nome, String marca, String tipo, Double valor_Diaria) {
        this.nome = nome;
        this.marca = marca;
        this.tipo = tipo;
        this.valor_Diaria = valor_Diaria;
        this.ativo = true;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ID_maquina;
    private String nome;
    private String marca;
    private String tipo;
    private Double valor_Diaria;
    private Boolean ativo;

    @OneToMany(mappedBy = "idMaquina")
    private List<ClienteMaquina> maquinas = new ArrayList<>();


    public void atualizarDados(String nome, String marca, String tipo, Double valor_Diaria) {
        if (nome != null) {
            this.nome = nome;
        }
        if (marca != null) {
            this.marca = marca;
        }
        if (tipo != null) {
            this.tipo = tipo;
        }
        if (valor_Diaria != null) {
            this.valor_Diaria = valor_Diaria;
        }

    }

    public void desativarMaquina() {
        this.ativo = false;
    }

}
