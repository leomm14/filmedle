package tuffos.filmedle.dados.Pais.dto;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import tuffos.filmedle.dados.Pais.Pais;
import tuffos.filmedle.dados.filme.Filme;
import tuffos.filmedle.dados.filme.dto.ResponseFilmeDTO;

@Getter
@Setter
public class ResponsePaisDTO {

    private Integer id;
    private String nome;
    private String bandeira;

    public static @NonNull ResponsePaisDTO toDTO (Pais pais) {
        ResponsePaisDTO responsePaisDTO = new ResponsePaisDTO();
        responsePaisDTO.setId(pais.getId());
        responsePaisDTO.setNome(pais.getNome());
        responsePaisDTO.setBandeira(pais.getBandeira());
        return responsePaisDTO;
    }

}
