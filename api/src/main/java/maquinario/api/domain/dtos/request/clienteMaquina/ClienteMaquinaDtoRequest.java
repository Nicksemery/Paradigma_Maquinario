package maquinario.api.domain.dtos.request.clienteMaquina;

import maquinario.api.domain.entity.Cliente;
import maquinario.api.domain.entity.Maquina;

import java.util.Date;

public record ClienteMaquinaDtoRequest(
        Long cliente,
        Long maquina,
        Date dataInicio,
        Date dataFim,
        String situacao,
        Double valorTotal
) {
}
