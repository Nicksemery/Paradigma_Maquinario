package maquinario.api.domain.dtos.response.cliente;

public record ClienteDtoResponse(
        Long idCliente,
        String nome,
        String email,
        int telefone
) {
}
