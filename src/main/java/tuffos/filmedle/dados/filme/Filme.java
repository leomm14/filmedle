package tuffos.filmedle.dados.filme;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import tuffos.filmedle.dados.Pais.Pais;

import java.time.LocalDateTime;
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

    @Column(nullable = false)
    private String[] genero;

    @Column(nullable = false)
    private Integer lancamento;

    @Column(nullable = false)
    private Double receita;

    @Column(nullable = false)
    private String[] produtora;

    @Column(nullable = false)
    private String[] elenco;

    @Column(nullable = false)
    private String diretor;

    @Column(nullable = false)
    private String[] keywords;
}
