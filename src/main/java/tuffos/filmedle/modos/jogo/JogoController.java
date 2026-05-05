package tuffos.filmedle.modos.jogo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tuffos.filmedle.mecanicas.Partida.Partida;
import tuffos.filmedle.mecanicas.Partida.dto.ResponsePartidaDTO;

@RestController
@RequestMapping("/jogo")
@CrossOrigin(origins = "*")
public class JogoController {

    @Autowired
    private JogoService jogoService;

    @PostMapping("/iniciar")
    public ResponsePartidaDTO iniciarPartida(@RequestParam String modo) {
        return ResponsePartidaDTO.toDTO(jogoService.iniciarPartida(modo));
    }
}
