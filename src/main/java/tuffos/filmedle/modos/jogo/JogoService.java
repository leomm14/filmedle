package tuffos.filmedle.modos.jogo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import tuffos.filmedle.dados.filme.Filme;
import tuffos.filmedle.mecanicas.Partida.Partida;
import tuffos.filmedle.mecanicas.Partida.PartidaRepository;
import tuffos.filmedle.modos.ModoJogo;

@Service
public class JogoService {

    @Autowired
    private PartidaRepository partidaRepository;

    private final ModoJogo modoDiario;
    private final ModoJogo modoInfinito;

    public JogoService(
            @Qualifier("modoDiario") ModoJogo modoDiario,
            @Qualifier("modoInfinito") ModoJogo modoInfinito
    ) {
        this.modoDiario = modoDiario;
        this.modoInfinito = modoInfinito;
    }

    public Filme escolherFilme(String tipo) {
        if ("diario".equalsIgnoreCase(tipo)) {
            return modoDiario.getFilmeDoDia();
        }
        return modoInfinito.getFilmeDoDia();
    }

    public Partida iniciarPartida(String modo) {
        Filme filme = escolherFilme(modo);

        Partida partida = new Partida();
        partida.setFilme(filme);

        return partidaRepository.save(partida);
    }
}