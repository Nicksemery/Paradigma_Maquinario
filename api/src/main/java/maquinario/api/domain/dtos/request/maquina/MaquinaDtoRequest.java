package maquinario.api.domain.dtos.request.maquina;

public record MaquinaDtoRequest(
        String nome,
        String marca,
        String tipo,
        Double valor_Diaria

) {
}
