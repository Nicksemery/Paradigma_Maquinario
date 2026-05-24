package maquinario.api.infra.validate;

import maquinario.api.domain.entity.Maquina;
import maquinario.api.infra.repository.MaquinaRepository;
import org.springframework.stereotype.Component;

@Component
public class MaquinaValidate {

    private final MaquinaRepository maquinaRepository;

    public MaquinaValidate(MaquinaRepository maquinaRepository) {
        this.maquinaRepository = maquinaRepository;
    }

    public Maquina validarId(Long id) {
        return maquinaRepository.findById(id).orElseThrow(()->new RuntimeException("Id de Maquina inexistente"));
    }

    public Maquina validarNome(String nome) {
        return maquinaRepository.findByNome(nome).orElseThrow(()->new RuntimeException("Nome de Maquina inexistente"));
    }
}
