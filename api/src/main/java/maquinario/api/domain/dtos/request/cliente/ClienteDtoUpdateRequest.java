package maquinario.api.domain.dtos.request.cliente;

public record ClienteDtoUpdateRequest(
        String nome,
        String cpf,
        String email,
        int telefone
) {
}
