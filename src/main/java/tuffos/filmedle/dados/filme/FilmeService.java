package tuffos.filmedle.dados.filme;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import tuffos.filmedle.dados.filme.dto.ResponseFilmeDTO;

@Service
public class FilmeService {

    @Autowired
    private FilmeRepository filmeRepository;

    public Filme get(Integer id)  {
        return filmeRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Filme não encontrado"));
    }

    public ResponseFilmeDTO getDTO(Integer id) {return ResponseFilmeDTO.toDTO(get(id));}
}
