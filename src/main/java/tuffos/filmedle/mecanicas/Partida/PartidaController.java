package tuffos.filmedle.mecanicas.Partida;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tuffos.filmedle.dados.filme.dto.ResponseFilmeDTO;
import tuffos.filmedle.mecanicas.Partida.dto.ResponsePartidaDTO;

import java.util.List;

@RestController
@RequestMapping("/partida")
public class PartidaController {

    @Autowired
    private PartidaService partidaService;

    @PostMapping("/inicia")
    public ResponsePartidaDTO inicia(@RequestParam(defaultValue = "infinito") String modo) {return partidaService.inicia(modo);}

    @PostMapping("/{idPartida}/chute/{idChute}")
    public ResponsePartidaDTO chuta(@PathVariable Integer idPartida, @PathVariable Integer idChute) {return partidaService.chute(idPartida, idChute);}

    @GetMapping("/{idPartida}/dica")
    public List<String> dica(@PathVariable Integer idPartida) {return partidaService.dica(idPartida);}

    @GetMapping("/{idPartida}/desistir")
    public ResponseFilmeDTO desistir(@PathVariable Integer idPartida) {return partidaService.desistir(idPartida);}

}
