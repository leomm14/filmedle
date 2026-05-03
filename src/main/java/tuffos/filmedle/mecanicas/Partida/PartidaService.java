package tuffos.filmedle.mecanicas.Partida;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import tuffos.filmedle.dados.filme.FilmeService;
import tuffos.filmedle.mecanicas.Palpite.Palpite;
import tuffos.filmedle.mecanicas.Palpite.PalpiteService;
import tuffos.filmedle.mecanicas.Partida.dto.ResponsePartidaDTO;

import java.util.ArrayList;

@Service
public class PartidaService {

    @Autowired
    private PartidaRepository partidaRepository;
    @Autowired
    private PalpiteService palpiteService;
    @Autowired
    private FilmeService filmeService;

    public ResponsePartidaDTO chute(Integer idPartida, Integer idChute) {

        Partida partida = get(idPartida);

        Palpite palpite = palpiteService.criaPalpite(idChute, partida);

        partida.getPalpites().add(palpite);
        partidaRepository.save(partida);
        return ResponsePartidaDTO.toDTO(partida);

    }

    public ResponsePartidaDTO criar(Integer idFilme) {
        Partida partida = new Partida();
        partida.setFilme(filmeService.get(idFilme));
        partida.setPalpites(new ArrayList<>());
        return ResponsePartidaDTO.toDTO(partidaRepository.save(partida));
    }

    public Partida get(Integer id)  {
        return partidaRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Partida não encontrado"));
    }
    public ResponsePartidaDTO getDTO(Integer id) {return ResponsePartidaDTO.toDTO(get(id));}

    public ResponsePartidaDTO inicia() {
        Partida partida = new Partida();
        partida.setFilme(filmeService.getAleatorio());
        partida = partidaRepository.save(partida);
        return ResponsePartidaDTO.toDTO(partida);
    }

    public String[] dica(Integer id) {
        Partida partida = get(id);

        if (partida.getPalpites().size() >= 5) {
            return partida.getFilme().getKeywords();
        } else {
            throw new ResponseStatusException(HttpStatus.FORBIDDEN, "A partida não tem pelo menos 5 palpites");
        }
    }

}
