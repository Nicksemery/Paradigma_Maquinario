package maquinario.api.controllers;

import maquinario.api.domain.dtos.request.cliente.ClienteDtoRequest;
import maquinario.api.domain.dtos.response.cliente.ClienteDtoResponse;
import maquinario.api.infra.service.ClienteService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/cliente")
public class ClienteController {

    private final ClienteService service;

    public ClienteController(ClienteService service) {
        this.service = service;
    }


    @PostMapping
    public ResponseEntity<ClienteDtoResponse> cadastrarCliente(@RequestBody ClienteDtoRequest dto, UriComponentsBuilder uriBuilder) {
        ClienteDtoResponse cliente = service.cadastrarCliente(dto);

        URI uri = uriBuilder.path("/cliente/{id}").buildAndExpand(cliente.idCliente()).toUri();

        return ResponseEntity.created(uri).body(cliente);

    }

    @GetMapping
    public ResponseEntity<List<ClienteDtoResponse>> listarClientes() {
        List<ClienteDtoResponse> clientes = service.listarClientes();
        return ResponseEntity.ok().body(clientes);
    }

    @GetMapping("{id}")
    public ResponseEntity<ClienteDtoResponse> buscarClientePorId(@PathVariable Long id) {
        ClienteDtoResponse cliente = service.buscarClientePorId(id);
        return ResponseEntity.ok().body(cliente);
    }

    @GetMapping("{nome}")
    public ResponseEntity<ClienteDtoResponse> buscarClientePorNome(@PathVariable String nome) {
        ClienteDtoResponse cliente = service.buscarClientePorNome(nome);
        return ResponseEntity.ok().body(cliente);
    }

    @PutMapping("{id}")
    public ResponseEntity<ClienteDtoResponse> atualizarCliente(@PathVariable Long id, @RequestBody ClienteDtoRequest dto){
        ClienteDtoResponse cliente = service.atualizarClientePorId(id, dto);
        return ResponseEntity.ok().body(cliente);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<ClienteDtoResponse> deletarCliente(@PathVariable Long id) {
        service.deletarCliente(id);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("{nome}")
    public ResponseEntity<ClienteDtoResponse> deletarClientePorNome(@PathVariable String nome) {
        service.deletarClientePorNome(nome);
        return ResponseEntity.noContent().build();
    }

}
