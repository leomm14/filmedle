package tuffos.filmedle.mecanicas.Palpite.dto;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import tuffos.filmedle.dados.filme.Filme;
import tuffos.filmedle.mecanicas.FeedbackAtributo.Feedback;
import tuffos.filmedle.mecanicas.Palpite.Palpite;

@Getter
@Setter
public class ResponsePalpiteDTO {
    private Integer id;
    private Filme filme;
    private Boolean correto;
    private Feedback pais;
    private Feedback genero;
    private Feedback lancamento;
    private Feedback receita;
    private Feedback produtora;
    private Feedback elenco;
    private Feedback diretor;

    public static @NonNull ResponsePalpiteDTO toDTO (Palpite palpite) {
        ResponsePalpiteDTO responsePalpiteDTO = new ResponsePalpiteDTO();
        responsePalpiteDTO.setId(palpite.getId());
        responsePalpiteDTO.setFilme(palpite.getFilme());
        responsePalpiteDTO.setCorreto(palpite.getCorreto());
        responsePalpiteDTO.setPais(palpite.getPais());
        responsePalpiteDTO.setGenero(palpite.getGenero());
        responsePalpiteDTO.setLancamento(palpite.getLancamento());
        responsePalpiteDTO.setReceita(palpite.getReceita());
        responsePalpiteDTO.setProdutora(palpite.getProdutora());
        responsePalpiteDTO.setElenco(palpite.getElenco());
        responsePalpiteDTO.setDiretor(palpite.getDiretor());
        return responsePalpiteDTO;
    }
}
