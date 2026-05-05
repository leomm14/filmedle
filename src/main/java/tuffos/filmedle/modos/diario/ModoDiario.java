package tuffos.filmedle.modos.diario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import tuffos.filmedle.dados.filme.Filme;
import tuffos.filmedle.dados.filme.FilmeRepository;
import tuffos.filmedle.modos.ModoJogo;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.List;
import java.util.Random;

@Service("modoDiario")
public class ModoDiario implements ModoJogo {

    @Autowired
    private FilmeRepository filmeRepository;

    @Override
    public Filme getFilmeDoDia() {
        List<Filme> filmes = filmeRepository.findAll(Sort.by("id"));

        if (filmes.isEmpty()) {
            throw new IllegalStateException("Não existem filmes cadastrados.");
        }

        long seed = LocalDate.now(ZoneId.of("America/Sao_Paulo")).toEpochDay();
        Random random = new Random(seed);

        return filmes.get(random.nextInt(filmes.size()));
    }
}