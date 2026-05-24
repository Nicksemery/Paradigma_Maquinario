package maquinario.api.infra.service;

import maquinario.api.domain.dtos.request.clienteMaquina.ClienteMaquinaDtoRequest;
import maquinario.api.domain.dtos.response.clienteMaquina.ClienteMaquinaDtoResponse;

import java.util.List;

public interface ClienteMaquinaService {

    ClienteMaquinaDtoResponse cadastrarClienteMaquina(ClienteMaquinaDtoRequest dto);

    ClienteMaquinaDtoResponse buscarClienteMaquinaPorId(Long id);

    ClienteMaquinaDtoResponse buscarClienteMaquinaPorSituacao(String nome);

    List<ClienteMaquinaDtoResponse> listarClienteMaquinas();

    ClienteMaquinaDtoResponse atualizarClienteMaquina(Long id ,ClienteMaquinaDtoRequest dto);

    void deletarClienteMaquinaPorId(Long id);

    void deletarClienteMaquinaPorSituacao(String nome);
}
