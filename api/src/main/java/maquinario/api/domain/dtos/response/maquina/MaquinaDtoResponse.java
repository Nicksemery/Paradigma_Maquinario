package maquinario.api.domain.dtos.response.maquina;

public record MaquinaDtoResponse(
        Long idMaquina,
        String nome,
        String marca,
        String tipo,
        Double valor_Diaria
) {
}
