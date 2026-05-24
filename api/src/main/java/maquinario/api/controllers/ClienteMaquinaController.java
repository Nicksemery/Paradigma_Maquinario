package maquinario.api.controllers;

import maquinario.api.domain.dtos.request.clienteMaquina.ClienteMaquinaDtoRequest;
import maquinario.api.domain.dtos.response.clienteMaquina.ClienteMaquinaDtoResponse;
import maquinario.api.infra.service.ClienteMaquinaService;
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
@RequestMapping("/clienteMaquina")
public class ClienteMaquinaController {

    private final ClienteMaquinaService service;

    public ClienteMaquinaController(ClienteMaquinaService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<ClienteMaquinaDtoResponse> cadastrarClienteMaquina(@RequestBody ClienteMaquinaDtoRequest dto, UriComponentsBuilder uriBuilder) {
        ClienteMaquinaDtoResponse dtoResponse = service.cadastrarClienteMaquina(dto);

        URI uri = uriBuilder.path("/clienteMaquina").buildAndExpand(dtoResponse.idClienteMaquina()).toUri();

        return ResponseEntity.created(uri).body(dtoResponse);
    }

    @GetMapping
    public ResponseEntity<List<ClienteMaquinaDtoResponse>> listarClienteMaquinas(){
        List<ClienteMaquinaDtoResponse> dtoResponse = service.listarClienteMaquinas();
        return ResponseEntity.ok().body(dtoResponse);
    }

    @GetMapping("{id}")
    public ResponseEntity<ClienteMaquinaDtoResponse> buscarClienteMaquina(@PathVariable Long id){
        ClienteMaquinaDtoResponse cm = service.buscarClienteMaquinaPorId(id);
        return ResponseEntity.ok().body(cm);
    }

    @GetMapping("{situacao}")
    public ResponseEntity<ClienteMaquinaDtoResponse> buscarClienteMaquinaPorSituacao(@PathVariable String situacao){
        ClienteMaquinaDtoResponse cm = service.buscarClienteMaquinaPorSituacao(situacao);
        return ResponseEntity.ok().body(cm);
    }

    @PutMapping("{id}")
    public ResponseEntity<ClienteMaquinaDtoResponse> atualizarClienteMaquina(@PathVariable Long id, @RequestBody ClienteMaquinaDtoRequest dto){
        ClienteMaquinaDtoResponse cm = service.atualizarClienteMaquina(id, dto);
        return ResponseEntity.ok().body(cm);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<ClienteMaquinaDtoResponse> excluirClienteMaquinaPorId(@PathVariable Long id){
        service.deletarClienteMaquinaPorId(id);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("{situacao}")
    public ResponseEntity<ClienteMaquinaDtoResponse> excluirClienteMaquinaPorSituacao(@PathVariable String situacao){
        service.deletarClienteMaquinaPorSituacao(situacao);
        return ResponseEntity.noContent().build();
    }

}
