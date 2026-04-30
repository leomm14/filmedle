package tuffos.filmedle.dados.Pais;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tuffos.filmedle.dados.Pais.dto.ResponsePaisDTO;
import tuffos.filmedle.dados.filme.FilmeService;
import tuffos.filmedle.dados.filme.dto.ResponseFilmeDTO;

@RestController
@RequestMapping("/pais")
public class PaisController {

    @Autowired
    private PaisService paisService;

    @GetMapping("/{id}")
    public ResponsePaisDTO getPais(@PathVariable Integer id) {return paisService.getDTO(id);}


}
