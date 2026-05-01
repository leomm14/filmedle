package tuffos.filmedle.mecanicas.Palpite;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import tuffos.filmedle.dados.filme.Filme;
import tuffos.filmedle.mecanicas.FeedbackAtributo.Feedback;
import tuffos.filmedle.mecanicas.Partida.Partida;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Palpite{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "id_filme", nullable = false)
    private Filme filme;

    @ManyToOne
    @JoinColumn(name = "id_partida", nullable = false)
    private Partida partida;

    @Column(nullable = false)
    private Boolean correto;

    @Enumerated(EnumType.STRING)
    private Feedback Pais;

    @Enumerated(EnumType.STRING)
    private Feedback genero;

    @Enumerated(EnumType.STRING)
    private Feedback lancamento;

    @Enumerated(EnumType.STRING)
    private Feedback receita;

    @Enumerated(EnumType.STRING)
    private Feedback produtora;

    @Enumerated(EnumType.STRING)
    private Feedback elenco;

    @Enumerated(EnumType.STRING)
    private Feedback diretor;
}
