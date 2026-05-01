package tuffos.filmedle.mecanicas.Partida;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import tuffos.filmedle.mecanicas.Palpite.Palpite;
import tuffos.filmedle.mecanicas.Palpite.PalpiteService;
import tuffos.filmedle.mecanicas.Partida.dto.ResponsePartidaDTO;

@Service
public class PartidaService {

    @Autowired
    private PartidaRepository partidaRepository;
    @Autowired
    private PalpiteService palpiteService;

    public ResponsePartidaDTO chute(Integer idPartida, Integer idChute) {

        Partida partida = get(idPartida);

        Palpite palpite = palpiteService.criaPalpite(idChute, partida);

        partida.getPalpites().add(palpite);
        partidaRepository.save(partida);
        return ResponsePartidaDTO.toDTO(partida);

    }


    public Partida get(Integer id)  {
        return partidaRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Partida não encontrado"));
    }
    public ResponsePartidaDTO getDTO(Integer id) {return ResponsePartidaDTO.toDTO(get(id));}

}
