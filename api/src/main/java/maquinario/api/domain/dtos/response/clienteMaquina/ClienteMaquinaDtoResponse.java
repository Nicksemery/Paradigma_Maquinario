package maquinario.api.domain.dtos.response.clienteMaquina;

import java.util.Date;

public record ClienteMaquinaDtoResponse(
        Long idClienteMaquina,
        Long idCliente,
        Long idMaquina,
        Date dataInicio,
        Date dataFim,
        String situacao,
        Double valorTotal
) {
}
