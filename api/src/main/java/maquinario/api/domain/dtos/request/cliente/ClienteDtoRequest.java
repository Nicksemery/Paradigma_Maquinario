package maquinario.api.domain.dtos.request.cliente;

public record ClienteDtoRequest(
        String nome,
        String cpf,
        String email,
        int telefone
) {
}
