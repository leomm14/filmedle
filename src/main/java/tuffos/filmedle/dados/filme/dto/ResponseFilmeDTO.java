package tuffos.filmedle.dados.filme.dto;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import tuffos.filmedle.dados.filme.Filme;

@Getter
@Setter
public class ResponseFilmeDTO {
    private Integer id;
    private String nome;
    private String pais;
    private String genero;
    private Integer lancamento;
    private Double receita;
    private String[] produtora;
    private String[] elenco;
    private String diretor;

    public static @NonNull ResponseFilmeDTO toDTO (Filme filme) {
        ResponseFilmeDTO responseFilmeDTO = new ResponseFilmeDTO();
        responseFilmeDTO.setId(filme.getId());
        responseFilmeDTO.setNome(filme.getNome());
        responseFilmeDTO.setPais(filme.getPais());
        responseFilmeDTO.setGenero(filme.getGenero());
        responseFilmeDTO.setLancamento(filme.getLancamento());
        responseFilmeDTO.setReceita(filme.getReceita());
        responseFilmeDTO.setProdutora(filme.getProdutora());
        responseFilmeDTO.setElenco(filme.getElenco());
        responseFilmeDTO.setDiretor(filme.getDiretor());
        return responseFilmeDTO;
    }
}
