package maquinario.api.infra.validate;

import maquinario.api.domain.entity.ClienteMaquina;
import maquinario.api.infra.repository.ClienteMaquinaRepository;
import org.springframework.stereotype.Component;

@Component
public class ClienteMaquinaValidate {

    private final ClienteMaquinaRepository repository;

    public ClienteMaquinaValidate(ClienteMaquinaRepository repository) {
        this.repository = repository;
    }

    public ClienteMaquina validarSituacao(String nome) {
        return repository.findBySituacao(nome).orElseThrow(()->new RuntimeException(" Situação inexistente"));
    }

    public ClienteMaquina validarId(Long id) {
        return repository.findById(id).orElseThrow(()->new RuntimeException("Id de transação inexistente"));
    }
}
