package maquinario.api.infra.repository;

import maquinario.api.domain.entity.Maquina;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface MaquinaRepository extends JpaRepository<Maquina, Long> {

    @Override
    Optional<Maquina> findById(Long id);
    Optional<Maquina> findByNome(String nome);
}
