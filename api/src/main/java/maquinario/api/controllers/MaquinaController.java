package maquinario.api.controllers;

import maquinario.api.domain.dtos.request.maquina.MaquinaDtoRequest;
import maquinario.api.domain.dtos.response.maquina.MaquinaDtoResponse;
import maquinario.api.infra.service.ClienteService;
import maquinario.api.infra.service.MaquinaService;
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
@RequestMapping("/maquina")
public class MaquinaController {

    private final MaquinaService service;
    public MaquinaController(MaquinaService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<MaquinaDtoResponse> cadastrarMaquina(@RequestBody MaquinaDtoRequest dto, UriComponentsBuilder uriBuilder) {
        MaquinaDtoResponse maquina = service.cadastrarMaquina(dto);

        URI uri = uriBuilder.path("/maquina/{id}").buildAndExpand(maquina.idMaquina()).toUri();
        return ResponseEntity.created(uri).body(maquina);
    }

    @GetMapping
    public ResponseEntity<List<MaquinaDtoResponse>> listarMaquinas() {
        List<MaquinaDtoResponse> maquinas = service.listarMaquinas();
        return ResponseEntity.ok().body(maquinas);
    }
    @GetMapping("{id}")
    public ResponseEntity<MaquinaDtoResponse> buscarMaquinaPorId(@PathVariable Long id) {
        MaquinaDtoResponse maquina = service.buscarMaquinaPorId(id);
        return ResponseEntity.ok().body(maquina);
    }
    @GetMapping("{nome}")
    public ResponseEntity<MaquinaDtoResponse> buscarMaquinaPorNome(@PathVariable String nome) {
        MaquinaDtoResponse maquina = service.buscarMaquinaPorNome(nome);
        return ResponseEntity.ok().body(maquina);
    }

    @PutMapping("{id}")
    public ResponseEntity<MaquinaDtoResponse> atualizarMaquina(@PathVariable Long id, @RequestBody MaquinaDtoRequest dto) {
        MaquinaDtoResponse maquina = service.atualizarMaquinaPorId(id, dto);
        return ResponseEntity.ok().body(maquina);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<MaquinaDtoResponse> deletarMaquinaPorId(@PathVariable Long id) {
        service.deletarMaquinaPorId(id);
        return ResponseEntity.noContent().build();
    }
    @DeleteMapping("{nome}")
    public ResponseEntity<MaquinaDtoResponse> deletarMaquinaPorNome(@PathVariable String nome) {
        service.deletarMaquinaPorNome(nome);
        return ResponseEntity.noContent().build();
    }


}
