package maquinario.api.infra.service;

import maquinario.api.domain.dtos.request.maquina.MaquinaDtoRequest;
import maquinario.api.domain.dtos.response.maquina.MaquinaDtoResponse;

import java.util.List;

public interface MaquinaService {

    MaquinaDtoResponse cadastrarMaquina(MaquinaDtoRequest dto);

    MaquinaDtoResponse buscarMaquinaPorId(Long id);

    MaquinaDtoResponse buscarMaquinaPorNome(String nome);

    List<MaquinaDtoResponse> listarMaquinas();

    MaquinaDtoResponse atualizarMaquinaPorId(Long id, MaquinaDtoRequest dto);

    void deletarMaquinaPorId(Long id);

    void deletarMaquinaPorNome(String nome);

}
