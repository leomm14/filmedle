package tuffos.filmedle.dados.filme;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import tuffos.filmedle.dados.Pais.Pais;
import tuffos.filmedle.mecanicas.Palpite.Palpite;
import tuffos.filmedle.mecanicas.Partida.Partida;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Filme {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String nome;

    @ManyToMany
    @JoinTable(
            name = "filme_pais",
            joinColumns = @JoinColumn(name = "id_filme"),
            inverseJoinColumns = @JoinColumn(name = "id_pais")
    )
    private List<Pais> paises;

    @ElementCollection
    @CollectionTable(
            name = "filme_genero",
            joinColumns = @JoinColumn(name = "filme_id")
    )
    @Column(name = "genero", nullable = false)
    private List<String> genero;

    @Column(nullable = false)
    private Integer lancamento;

    @Column(nullable = false)
    private Double receita;

    @ElementCollection
    @CollectionTable(
            name = "filme_produtora",
            joinColumns = @JoinColumn(name = "filme_id")
    )
    @Column(name = "produtora", nullable = false)
    private List<String> produtora;

    @ElementCollection
    @CollectionTable(
            name = "filme_elenco",
            joinColumns = @JoinColumn(name = "filme_id")
    )
    @Column(name = "elenco", nullable = false)
    private List<String> elenco;

    @Column(nullable = false)
    private String diretor;

    @ElementCollection
    @CollectionTable(
            name = "filme_keywords",
            joinColumns = @JoinColumn(name = "filme_id")
    )
    @Column(name = "keyword", nullable = false)
    private List<String> keywords;

    @JsonIgnore
    @OneToMany(mappedBy = "filme")
    private List<Palpite> palpites;

    @JsonIgnore
    @OneToMany(mappedBy = "filme")
    private List<Partida> partidas;
}