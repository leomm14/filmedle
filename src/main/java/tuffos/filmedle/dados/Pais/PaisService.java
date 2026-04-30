package tuffos.filmedle.dados.Pais;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import tuffos.filmedle.dados.Pais.dto.ResponsePaisDTO;

@Service
public class PaisService {

    @Autowired PaisRepository paisRepository;

    public Pais get(Integer id)  {
        return paisRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Pais não encontrado"));
    }

    public ResponsePaisDTO getDTO(Integer id) {return ResponsePaisDTO.toDTO(get(id));}

}
