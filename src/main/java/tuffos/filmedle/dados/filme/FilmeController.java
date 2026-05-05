package tuffos.filmedle.dados.filme;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tuffos.filmedle.dados.filme.dto.ResponseFilmeFiltroDTO;

import java.util.List;

@RestController
@RequestMapping("/filme")
public class FilmeController {

    @Autowired
    private FilmeService filmeService;

    @GetMapping("/filtro")
    public List<ResponseFilmeFiltroDTO> buscarFilmes() {
        return filmeService.getTodosFilmesParaBusca();
    }
}
