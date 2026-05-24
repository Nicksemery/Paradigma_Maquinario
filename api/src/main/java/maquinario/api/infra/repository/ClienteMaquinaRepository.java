package maquinario.api.infra.repository;

import maquinario.api.domain.entity.ClienteMaquina;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ClienteMaquinaRepository extends JpaRepository<ClienteMaquina, Long> {

    @Override
    Optional<ClienteMaquina> findById(Long id);
    Optional<ClienteMaquina> findBySituacao(String nome);
}
