package tuffos.filmedle.dados.filme;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import tuffos.filmedle.dados.filme.dto.ResponseFilmeFiltroDTO;

import java.util.List;
import java.util.Random;

@Service
public class FilmeService {

    @Autowired
    private FilmeRepository filmeRepository;

    public Filme get(Integer id)  {
        return filmeRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Filme não encontrado"));
    }

    public Filme getFilmePorSeed(long seed) {
        Random random = new Random(seed);
        int idSorteado = random.nextInt((int) filmeRepository.count()) + 1;
        return  filmeRepository.findById(idSorteado)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Filme não encontrado com ID: " + idSorteado));
    }

    public List<ResponseFilmeFiltroDTO> getTodosFilmesParaBusca() {
        return filmeRepository.findAll()
                .stream()
                .map(ResponseFilmeFiltroDTO::toDTO)
                .toList();
    }
}
