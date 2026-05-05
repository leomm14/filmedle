package tuffos.filmedle.modos.Infinito;

import org.springframework.stereotype.Service;
import tuffos.filmedle.modos.Jogo;

import java.util.concurrent.ThreadLocalRandom;

@Service("modoInfinito")
public class Infinito implements Jogo {

    @Override
    public long gerarSeed() {
        long seed = ThreadLocalRandom.current().nextLong();
        return seed;
    }
}
