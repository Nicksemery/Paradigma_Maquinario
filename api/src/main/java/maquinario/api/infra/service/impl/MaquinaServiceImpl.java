package maquinario.api.infra.service.impl;

import jakarta.transaction.Transactional;
import maquinario.api.domain.dtos.request.maquina.MaquinaDtoRequest;
import maquinario.api.domain.dtos.response.maquina.MaquinaDtoResponse;
import maquinario.api.domain.entity.Maquina;
import maquinario.api.infra.mapper.MaquinaMapper;
import maquinario.api.infra.repository.MaquinaRepository;
import maquinario.api.infra.service.MaquinaService;
import maquinario.api.infra.validate.MaquinaValidate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MaquinaServiceImpl implements MaquinaService {

    private final MaquinaRepository repository;
    private final MaquinaMapper mapper;
    private final MaquinaValidate validate;

    public MaquinaServiceImpl(MaquinaRepository repository, MaquinaMapper mapper, MaquinaValidate validate) {
        this.repository = repository;
        this.mapper = mapper;
        this.validate = validate;
    }

    @Override
    @Transactional
    public MaquinaDtoResponse cadastrarMaquina(MaquinaDtoRequest dto) {

        Maquina maquina = mapper.entidade(dto);
        Maquina salvar = repository.save(maquina);

        return mapper.resposta(salvar);
    }

    @Override
    public MaquinaDtoResponse buscarMaquinaPorId(Long id) {
        Maquina maquina = validate.validarId(id);
        return mapper.resposta(maquina);
    }

    @Override
    public MaquinaDtoResponse buscarMaquinaPorNome(String nome) {
        Maquina maquina = validate.validarNome(nome);
        return mapper.resposta(maquina);
    }

    @Override
    public List<MaquinaDtoResponse> listarMaquinas() {
        List<Maquina> maquinas = repository.findAll();
        return maquinas.stream().map(mapper::resposta).collect(Collectors.toList());
    }

    @Override
    @Transactional
    public MaquinaDtoResponse atualizarMaquinaPorId(Long id, MaquinaDtoRequest dto) {
        Maquina maquina = validate.validarId(id);
        maquina.atualizarDados(dto.nome(), dto.marca(), dto.tipo(), dto.valor_Diaria());

        return mapper.resposta(maquina);
    }

    @Override
    @Transactional
    public void deletarMaquinaPorId(Long id) {
        Maquina maquina = validate.validarId(id);
        maquina.desativarMaquina();
    }

    @Override
    @Transactional
    public void deletarMaquinaPorNome(String nome) {
        Maquina maquina = validate.validarNome(nome);
        maquina.desativarMaquina();
    }
}
