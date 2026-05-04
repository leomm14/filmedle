package tuffos.filmedle.dados.filme;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tuffos.filmedle.dados.filme.dto.FilmeBuscaDTO;
import tuffos.filmedle.dados.filme.dto.ResponseFilmeDTO;

import java.util.List;

@RestController
@RequestMapping("/filme")
public class FilmeController {

    @Autowired
    private FilmeService filmeService;

    @GetMapping("/{id}")
    public ResponseFilmeDTO getFilme(@PathVariable Integer id) {return filmeService.getDTO(id);}

    @GetMapping("/buscar")
    public List<FilmeBuscaDTO> buscarFilmes() {
        return filmeService.getTodosFilmesParaBusca();
    }
}
