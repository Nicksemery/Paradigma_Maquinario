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
@Table(name = "clientes")
@Getter
@NoArgsConstructor
public class Cliente {

    public Cliente(String nome, String cpf, String email, int telefone) {
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
        this.telefone = telefone;
        this.ativo = true;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ID_cliente;

    private String nome;
    private String cpf;
    private String email;
    private int telefone;
    private Boolean ativo;

    @OneToMany(mappedBy = "idCliente")
    private List <ClienteMaquina> cliente = new ArrayList<>();

    public void atualizarDados(String nome, String cpf, String email, int telefone) {
        if(nome != null) {
            this.nome = nome;
        }
        if(cpf != null) {
            this.cpf = cpf;
        }
        if(email != null) {
            this.email = email;
        }
        if (telefone == 00000000) {
            this.telefone = telefone;
        }
    }

    public void desativarCliente() {
        this.ativo = false;
    }

}
