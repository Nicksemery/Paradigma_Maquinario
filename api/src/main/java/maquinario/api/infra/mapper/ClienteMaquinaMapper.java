package maquinario.api.infra.mapper;

import maquinario.api.domain.dtos.request.clienteMaquina.ClienteMaquinaDtoRequest;
import maquinario.api.domain.dtos.response.clienteMaquina.ClienteMaquinaDtoResponse;
import maquinario.api.domain.entity.Cliente;
import maquinario.api.domain.entity.ClienteMaquina;
import maquinario.api.domain.entity.Maquina;
import org.springframework.stereotype.Component;


@Component
public class ClienteMaquinaMapper {


    public ClienteMaquina entidade(ClienteMaquinaDtoRequest dto, Cliente cliente, Maquina maquina) {
        if (dto == null) {
            return null;
        }

        return new ClienteMaquina(
                cliente,
                maquina,
                dto.dataInicio(),
                dto.dataFim(),
                dto.situacao(),
                dto.valorTotal()
        );
    }

    public ClienteMaquinaDtoResponse resposta(ClienteMaquina entidade) {
        if (entidade == null) {
            return null;
        }
        return new ClienteMaquinaDtoResponse(
                entidade.getId_clienteMaquina(),
                entidade.getIdCliente().getID_cliente(),
                entidade.getIdMaquina().getID_maquina(),
                entidade.getDataInicio(),
                entidade.getDataFim(),
                entidade.getSituacao(),
                entidade.getValorTotal()
        );
    }

}
