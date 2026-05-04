package tuffos.filmedle.dados.filme.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import tuffos.filmedle.dados.filme.Filme;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class FilmeBuscaDTO {

    private Integer id;
    private String nome;

    public static FilmeBuscaDTO fromEntity(Filme filme) {
        return new FilmeBuscaDTO(filme.getId(), filme.getNome());
    }
}
