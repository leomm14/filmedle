package tuffos.filmedle.dados.filme.dto;

import lombok.*;
import tuffos.filmedle.dados.filme.Filme;

@Getter
@Setter
public class ResponseFilmeFiltroDTO {

    private Integer id;
    private String nome;

    public static @NonNull ResponseFilmeFiltroDTO toDTO(Filme filme) {
        ResponseFilmeFiltroDTO FilmeDTO = new ResponseFilmeFiltroDTO();
        FilmeDTO.setId(filme.getId());
        FilmeDTO.setNome(filme.getNome());
        return FilmeDTO;
    }
}