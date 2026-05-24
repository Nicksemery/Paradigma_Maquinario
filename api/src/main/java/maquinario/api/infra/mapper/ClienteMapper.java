package maquinario.api.infra.mapper;

import maquinario.api.domain.dtos.request.cliente.ClienteDtoRequest;
import maquinario.api.domain.dtos.response.cliente.ClienteDtoResponse;
import maquinario.api.domain.entity.Cliente;
import org.springframework.stereotype.Component;

@Component
public class ClienteMapper {

    public Cliente entidade(ClienteDtoRequest dto){
        if (dto == null){
            return null;
        }

        return new Cliente(
                dto.nome(),
                dto.cpf(),
                dto.email(),
                dto.telefone()
        );
    }


    public ClienteDtoResponse resposta(Cliente cliente){
        if (cliente == null){
            return null;
        }
        return new ClienteDtoResponse(
                cliente.getID_cliente(),
                cliente.getNome(),
                cliente.getEmail(),
                cliente.getTelefone()
        );
    }

}
