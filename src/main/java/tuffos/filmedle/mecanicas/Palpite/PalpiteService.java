package tuffos.filmedle.mecanicas.Palpite;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tuffos.filmedle.dados.filme.Filme;
import tuffos.filmedle.dados.filme.FilmeService;
import tuffos.filmedle.mecanicas.FeedbackAtributo.Feedback;
import tuffos.filmedle.mecanicas.Partida.Partida;
import java.util.*;

@Service
public class PalpiteService {

    @Autowired
    private PalpiteReposity palpiteReposity;
    @Autowired
    private FilmeService filmeService;

    public Palpite criaPalpite(Integer idChute, Partida partida) {
        Palpite palpite = new Palpite();
        Filme filmeCorreto = partida.getFilme();
        Filme filmeChute = filmeService.get(idChute);
        palpite.setFilme(filmeChute);
        palpite.setPartida(partida);

        if (idChute.equals(filmeCorreto.getId())) {
            palpite.setCorreto(true);
            palpite.setGenero(Feedback.CORRETO);
            palpite.setLancamento(Feedback.CORRETO);
            palpite.setReceita(Feedback.CORRETO);
            palpite.setProdutora(Feedback.CORRETO);
            palpite.setElenco(Feedback.CORRETO);
            palpite.setDiretor(Feedback.CORRETO);
        } else {
            defineFeedbacks(filmeChute, filmeCorreto, palpite);
        }

        return palpiteReposity.save(palpite);

    }

    public void defineFeedbacks(Filme filmeChute, Filme filmeCorreto, Palpite palpite) {
        palpite.setCorreto(false);

        palpite.setGenero(feedbackLista(filmeChute.getGenero(), filmeCorreto.getGenero()));
        palpite.setProdutora(feedbackLista(filmeChute.getProdutora(), filmeCorreto.getProdutora()));
        palpite.setElenco(feedbackLista(filmeChute.getElenco(), filmeCorreto.getElenco()));

        palpite.setLancamento(feedbackNumero(filmeChute.getLancamento().doubleValue(), filmeCorreto.getLancamento().doubleValue()));
        palpite.setReceita(feedbackNumero(filmeChute.getReceita(), filmeCorreto.getReceita()));

        if (filmeChute.getDiretor().equals(filmeCorreto.getDiretor())) {
            palpite.setDiretor(Feedback.CORRETO);
        } else {
            palpite.setDiretor(Feedback.ERRADO);
        }
    }

    public Feedback feedbackLista(String[] chute, String[] correto) {
        List<String> listaChute = Arrays.asList(chute);
        List<String> listaCorreta = Arrays.asList(correto);
        if (listaCorreta.size() == listaChute.size() && listaCorreta.containsAll(listaChute)) {
            return Feedback.CORRETO;
        }
        if (Collections.disjoint(listaCorreta, listaChute)) {
            return Feedback.ERRADO;
        }
        return Feedback.PARCIAL;
    }

    public Feedback feedbackNumero(Double chute, Double correto) {
        if (chute.equals(correto)) {
            return Feedback.CORRETO;
        }
        if (chute < correto) {
            return Feedback.SETA_CIMA;
        }
        return  Feedback.SETA_BAIXO;
    }

}
