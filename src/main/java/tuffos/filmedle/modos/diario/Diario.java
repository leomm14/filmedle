package tuffos.filmedle.modos.Diario;

import org.springframework.stereotype.Service;
import tuffos.filmedle.modos.Jogo;

import java.time.LocalDate;
import java.time.ZoneId;

@Service("modoDiario")
public class Diario implements Jogo {

    @Override
    public long gerarSeed() {
        long seed = LocalDate.now(ZoneId.of("America/Sao_Paulo")).toEpochDay();
        return seed * 982451653L;
    }
}