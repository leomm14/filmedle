package tuffos.filmedle.mecanicas.Partida.dto;


import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import tuffos.filmedle.dados.filme.Filme;
import tuffos.filmedle.mecanicas.Palpite.dto.ResponsePalpiteDTO;
import tuffos.filmedle.mecanicas.Partida.Partida;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
public class ResponsePartidaDTO {

    private Integer id;
    private Filme filme;
    private List<ResponsePalpiteDTO> palpites;

    public static @NonNull ResponsePartidaDTO toDTO (Partida partida) {
        ResponsePartidaDTO responsePartidaDTO = new ResponsePartidaDTO();
        responsePartidaDTO.setId(partida.getId());
        responsePartidaDTO.setFilme(partida.getFilme());
        if (partida.getPalpites() != null) {
            responsePartidaDTO.setPalpites(partida.getPalpites().stream()
                    .map(ResponsePalpiteDTO::toDTO)
                    .collect(Collectors.toList()));
        }

        return responsePartidaDTO;
    }
}