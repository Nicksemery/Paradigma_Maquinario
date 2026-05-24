package maquinario.api.infra.repository;

import maquinario.api.domain.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {

    @Override
    Optional<Cliente> findById(Long id);

    Optional<Cliente> findByNome(String nome);



}
