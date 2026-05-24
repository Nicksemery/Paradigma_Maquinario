package maquinario.api.infra.service.impl;

import jakarta.transaction.Transactional;
import maquinario.api.domain.dtos.request.cliente.ClienteDtoRequest;
import maquinario.api.domain.dtos.response.cliente.ClienteDtoResponse;
import maquinario.api.domain.entity.Cliente;
import maquinario.api.infra.mapper.ClienteMapper;
import maquinario.api.infra.repository.ClienteRepository;
import maquinario.api.infra.service.ClienteService;
import maquinario.api.infra.validate.ClienteValidate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClienteServiceImpl implements ClienteService {

    private final ClienteRepository repository;
    private final ClienteMapper mapper;
    private final ClienteValidate validate;

    public ClienteServiceImpl(ClienteRepository repository, ClienteMapper mapper, ClienteValidate validate) {
        this.repository = repository;
        this.mapper = mapper;
        this.validate = validate;
    }

    @Override
    @Transactional
    public ClienteDtoResponse cadastrarCliente(ClienteDtoRequest dto) {

        Cliente cliente = mapper.entidade(dto);
        Cliente clienteSalvo = repository.save(cliente);
        return mapper.resposta(clienteSalvo);
    }

    @Override
    public List<ClienteDtoResponse> listarClientes() {
        List<Cliente> clientes = repository.findAll();
        return clientes.stream().map(mapper::resposta).collect(Collectors.toList());
    }

    @Override
    public ClienteDtoResponse buscarClientePorId(Long id) {
        Cliente cliente = validate.validarId(id);
        return mapper.resposta(cliente);
    }

    @Override
    public ClienteDtoResponse buscarClientePorNome(String nome) {
        Cliente cliente = validate.validarNome(nome);
        return mapper.resposta(cliente);
    }

    @Override
    @Transactional
    public ClienteDtoResponse atualizarClientePorId(Long id, ClienteDtoRequest dto) {
        Cliente cliente = validate.validarId(id);
        cliente.atualizarDados(dto.nome(), dto.cpf(), dto.email(), dto.telefone());

        return mapper.resposta(cliente);
    }

    @Override
    @Transactional
    public void deletarCliente(Long id) {
        Cliente cliente = validate.validarId(id);
        cliente.desativarCliente();
    }

    @Override
    @Transactional
    public void deletarClientePorNome(String nome) {
        Cliente cliente = validate.validarNome(nome);
        cliente.desativarCliente();
    }
}
