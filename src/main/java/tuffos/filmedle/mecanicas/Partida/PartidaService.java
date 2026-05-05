package tuffos.filmedle.mecanicas.Partida;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import tuffos.filmedle.dados.filme.Filme;
import tuffos.filmedle.dados.filme.FilmeService;
import tuffos.filmedle.dados.filme.dto.ResponseFilmeDTO;
import tuffos.filmedle.mecanicas.Palpite.Palpite;
import tuffos.filmedle.mecanicas.Palpite.PalpiteService;
import tuffos.filmedle.mecanicas.Partida.dto.ResponsePartidaDTO;
import tuffos.filmedle.modos.Jogo;
import java.util.List;

@Service
public class PartidaService {

    @Autowired
    private PartidaRepository partidaRepository;
    @Autowired
    private PalpiteService palpiteService;
    @Autowired
    private FilmeService filmeService;

    @Autowired
    @Qualifier("modoDiario")
    private Jogo modoDiario;

    @Autowired
    @Qualifier("modoInfinito")
    private Jogo modoInfinito;

    public ResponsePartidaDTO inicia(String tipoModo) {
        long seed;

        if ("diario".equalsIgnoreCase(tipoModo)) {
            seed = modoDiario.gerarSeed();
        } else {
            seed = modoInfinito.gerarSeed();
        }

        Filme filme = filmeService.getFilmePorSeed(seed);

        Partida partida = new Partida();
        partida.setFilme(filme);
        partida = partidaRepository.save(partida);
        return ResponsePartidaDTO.toDTO(partida);
    }

    public ResponsePartidaDTO chute(Integer idPartida, Integer idChute) {

        Partida partida = get(idPartida);

        if (partida.getTerminou()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Esta partida já foi encerrada");
        }

        Palpite palpite = palpiteService.criaPalpite(idChute, partida);

        if (palpite.getCorreto()) {
            partida.setTerminou(true);
        }

        partida.getPalpites().add(palpite);
        partidaRepository.save(partida);
        return ResponsePartidaDTO.toDTO(partida);

    }

    public Partida get(Integer id)  {
        return partidaRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Partida não encontrado"));
    }

    public List<String> dica(Integer id) {
        Partida partida = get(id);

        if (partida.getPalpites().size() >= 5) {
            return partida.getFilme().getKeywords();
        } else {
            throw new ResponseStatusException(HttpStatus.FORBIDDEN, "A partida não tem pelo menos 5 palpites");
        }
    }

    public ResponseFilmeDTO desistir(Integer idPartida) {
        Partida partida = get(idPartida);

        if (partida.getTerminou()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Esta partida já foi encerrada");
        }

        partida.setTerminou(true);
        partidaRepository.save(partida);

        return ResponseFilmeDTO.toDTO(partida.getFilme());
    }

}
