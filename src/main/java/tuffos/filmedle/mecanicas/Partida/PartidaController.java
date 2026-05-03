package tuffos.filmedle.mecanicas.Partida;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tuffos.filmedle.dados.filme.Filme;
import tuffos.filmedle.mecanicas.Partida.dto.ResponsePartidaDTO;

@RestController
@RequestMapping("/partida")
public class PartidaController {

    @Autowired
    private PartidaService partidaService;

    @PostMapping("/inicia")
    public ResponsePartidaDTO inicia() {return partidaService.inicia();}

    @PostMapping("/{idPartida}/chute/{idChute}")
    public ResponsePartidaDTO chuta(@PathVariable Integer idPartida, @PathVariable Integer idChute) {return partidaService.chute(idPartida, idChute);}

    @GetMapping("/{idPartida}/dica")
    public String[] dica(@PathVariable Integer idPartida) {return partidaService.dica(idPartida);}

}
