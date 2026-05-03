package tuffos.filmedle.dados.filme.dto;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import tuffos.filmedle.dados.Pais.dto.ResponsePaisDTO;
import tuffos.filmedle.dados.filme.Filme;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
public class ResponseFilmeDTO {
    private Integer id;
    private String nome;
    private List<ResponsePaisDTO> paises;
    private List<String> genero;
    private Integer lancamento;
    private Double receita;
    private List<String> produtora;
    private List<String> elenco;
    private String diretor;
    private List<String> keywords;

    public static @NonNull ResponseFilmeDTO toDTO(Filme filme) {
        ResponseFilmeDTO responseFilmeDTO = new ResponseFilmeDTO();
        responseFilmeDTO.setId(filme.getId());
        responseFilmeDTO.setNome(filme.getNome());
        responseFilmeDTO.setGenero(filme.getGenero());
        responseFilmeDTO.setLancamento(filme.getLancamento());
        responseFilmeDTO.setReceita(filme.getReceita());
        responseFilmeDTO.setProdutora(filme.getProdutora());
        responseFilmeDTO.setElenco(filme.getElenco());
        responseFilmeDTO.setDiretor(filme.getDiretor());
        responseFilmeDTO.setKeywords(filme.getKeywords());

        if (filme.getPaises() != null) {
            responseFilmeDTO.setPaises(
                    filme.getPaises().stream()
                            .map(ResponsePaisDTO::toDTO)
                            .collect(Collectors.toList())
            );
        }

        return responseFilmeDTO;
    }
}