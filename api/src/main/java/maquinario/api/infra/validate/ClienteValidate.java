package maquinario.api.infra.validate;

import maquinario.api.domain.entity.Cliente;
import maquinario.api.infra.repository.ClienteRepository;
import org.springframework.stereotype.Component;

@Component
public class ClienteValidate {

    private final ClienteRepository clienteRepository;

    public ClienteValidate(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    public Cliente validarId(Long id){
        return clienteRepository.findById(id).orElseThrow(()-> new RuntimeException("id não encontrado"));
    }

    public Cliente validarNome(String nome){
        return clienteRepository.findByNome(nome).orElseThrow(()->new RuntimeException("Nome não encontrado"));
    }
}
