package tuffos.filmedle.modos.infinito;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import tuffos.filmedle.dados.filme.Filme;
import tuffos.filmedle.dados.filme.FilmeRepository;
import tuffos.filmedle.modos.ModoJogo;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

@Service("modoInfinito")
public class ModoInfinito implements ModoJogo {

    @Autowired
    private FilmeRepository filmeRepository;

    @Override
    public Filme getFilmeDoDia() {
        List<Filme> filmes = filmeRepository.findAll(Sort.by("id"));

        if (filmes.isEmpty()) {
            throw new IllegalStateException("Não existem filmes cadastrados.");
        }

        int indice = ThreadLocalRandom.current().nextInt(filmes.size());
        return filmes.get(indice);
    }
}
