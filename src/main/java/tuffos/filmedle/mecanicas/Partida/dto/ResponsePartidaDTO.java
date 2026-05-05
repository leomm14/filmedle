package tuffos.filmedle.mecanicas.Partida.dto;


import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import tuffos.filmedle.mecanicas.Palpite.dto.ResponsePalpiteDTO;
import tuffos.filmedle.mecanicas.Partida.Partida;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
public class ResponsePartidaDTO {

    private Integer id;
    private Boolean terminou;
    private List<ResponsePalpiteDTO> palpites;

    public static @NonNull ResponsePartidaDTO toDTO(Partida partida) {
        ResponsePartidaDTO dto = new ResponsePartidaDTO();
        dto.setId(partida.getId());
        dto.setTerminou(partida.getTerminou());

        if (partida.getPalpites() != null) {
            dto.setPalpites(
                    partida.getPalpites().stream()
                            .map(ResponsePalpiteDTO::toDTO)
                            .collect(Collectors.toList())
            );
        }

        return dto;
    }
}