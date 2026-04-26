package tuffos.filmedle.dados.filme;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tuffos.filmedle.dados.filme.dto.ResponseFilmeDTO;

@RestController
@RequestMapping("/filme")
public class FilmeController {

    @Autowired
    private FIlmeService fIlmeService;

    @GetMapping("/{id}")
    public ResponseFilmeDTO getFilme(@PathVariable Integer id) {return fIlmeService.getDTO(id);}

}
