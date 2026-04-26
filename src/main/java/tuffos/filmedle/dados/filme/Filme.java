package tuffos.filmedle.dados.filme;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

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

    @Column(nullable = false)
    private String pais;

    @Column(nullable = false)
    private String genero;

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

    @CreationTimestamp
    private LocalDateTime dataCriacao;

    @UpdateTimestamp
    private LocalDateTime dataAtualizacao;
}
