package maquinario.api.infra.service;

import maquinario.api.domain.dtos.request.cliente.ClienteDtoRequest;
import maquinario.api.domain.dtos.response.cliente.ClienteDtoResponse;

import java.util.List;

public interface ClienteService {

    ClienteDtoResponse cadastrarCliente(ClienteDtoRequest dto);

    List<ClienteDtoResponse> listarClientes();

    ClienteDtoResponse buscarClientePorId(Long id);

    ClienteDtoResponse buscarClientePorNome(String nome);

    ClienteDtoResponse atualizarClientePorId(Long id, ClienteDtoRequest dto);

    void deletarCliente(Long id);

    void deletarClientePorNome(String nome);


}
