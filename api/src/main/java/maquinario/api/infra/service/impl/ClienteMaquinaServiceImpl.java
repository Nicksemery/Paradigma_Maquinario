package maquinario.api.infra.service.impl;

import jakarta.transaction.Transactional;
import maquinario.api.domain.dtos.request.clienteMaquina.ClienteMaquinaDtoRequest;
import maquinario.api.domain.dtos.response.clienteMaquina.ClienteMaquinaDtoResponse;
import maquinario.api.domain.entity.Cliente;
import maquinario.api.domain.entity.ClienteMaquina;
import maquinario.api.domain.entity.Maquina;
import maquinario.api.infra.mapper.ClienteMaquinaMapper;
import maquinario.api.infra.repository.ClienteMaquinaRepository;
import maquinario.api.infra.repository.ClienteRepository;
import maquinario.api.infra.repository.MaquinaRepository;
import maquinario.api.infra.service.ClienteMaquinaService;
import maquinario.api.infra.validate.ClienteMaquinaValidate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClienteMaquinaServiceImpl implements ClienteMaquinaService {

    private final ClienteMaquinaRepository repository;
    private final ClienteMaquinaMapper mapper;
    private final ClienteMaquinaValidate validate;
    private final ClienteRepository clienteRepository;
    private final MaquinaRepository maquinaRepository;

    public ClienteMaquinaServiceImpl(ClienteMaquinaRepository repository, ClienteMaquinaMapper mapper, ClienteMaquinaValidate validate, ClienteRepository clienteRepository, MaquinaRepository maquinaRepository) {
        this.repository = repository;
        this.mapper = mapper;
        this.validate = validate;
        this.clienteRepository = clienteRepository;
        this.maquinaRepository = maquinaRepository;
    }

    @Override
    @Transactional
    public ClienteMaquinaDtoResponse cadastrarClienteMaquina(ClienteMaquinaDtoRequest dto) {

        Cliente cliente = clienteRepository.getReferenceById(dto.cliente());
        Maquina maquina = maquinaRepository.getReferenceById(dto.maquina());

        ClienteMaquina entidade = mapper.entidade(dto, cliente, maquina);
        ClienteMaquina salvar = repository.save(entidade);

        return mapper.resposta(salvar);
    }

    @Override
    public ClienteMaquinaDtoResponse buscarClienteMaquinaPorId(Long id) {
        ClienteMaquina cm = validate.validarId(id);
        return mapper.resposta(cm);
    }

    @Override
    public ClienteMaquinaDtoResponse buscarClienteMaquinaPorSituacao(String nome) {
        ClienteMaquina cm = validate.validarSituacao(nome);
        return mapper.resposta(cm);
    }

    @Override
    public List<ClienteMaquinaDtoResponse> listarClienteMaquinas() {
        List<ClienteMaquina> lista = repository.findAll();
        return lista.stream().map(mapper::resposta).collect(Collectors.toList());
    }

    @Override
    @Transactional
    public ClienteMaquinaDtoResponse atualizarClienteMaquina(Long id, ClienteMaquinaDtoRequest dto) {

        ClienteMaquina cm = validate.validarId(id);
        cm.atualizarDados(dto.dataInicio(),dto.dataFim(),dto.situacao(),dto.valorTotal());

        return mapper.resposta(cm);
    }

    @Override
    @Transactional
    public void deletarClienteMaquinaPorId(Long id) {
        ClienteMaquina cm = validate.validarId(id);
        cm.desativarTransacao();
    }

    @Override
    @Transactional
    public void deletarClienteMaquinaPorSituacao(String nome) {
        ClienteMaquina cm = validate.validarSituacao(nome);
        cm.desativarTransacao();
    }
}
