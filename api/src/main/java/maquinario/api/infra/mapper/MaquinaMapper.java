package maquinario.api.infra.mapper;

import maquinario.api.domain.dtos.request.maquina.MaquinaDtoRequest;
import maquinario.api.domain.dtos.response.maquina.MaquinaDtoResponse;
import maquinario.api.domain.entity.Maquina;
import org.springframework.stereotype.Component;

@Component
public class MaquinaMapper {

    public Maquina entidade(MaquinaDtoRequest dto){
        if(dto ==null){
            return null;
        }
        return new Maquina(
                dto.nome(),
                dto.marca(),
                dto.tipo(),
                dto.valor_Diaria()
        );
    }

    public MaquinaDtoResponse resposta(Maquina maquina){
        if(maquina ==null){
            return null;
        }
        return new MaquinaDtoResponse(
                maquina.getID_maquina(),
                maquina.getNome(),
                maquina.getMarca(),
                maquina.getTipo(),
                maquina.getValor_Diaria()
        );
    }

}
