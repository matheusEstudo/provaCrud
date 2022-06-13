package br.com.senac.entidade;

import java.io.Serializable;
import java.util.List;
import javax.persistence.*;
import lombok.*;

@Entity
@Table(name = "comportamento")
@Getter
@Setter
@EqualsAndHashCode
@ToString
public class Comportamento implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String tipo;

    @Column(nullable = false)
    private String descricao;

    @Column(nullable = false)
    private Boolean ativo;

    public Comportamento() {
    }

    public Comportamento(String tipo, String descricao, Boolean ativo) {
        this.tipo = tipo;
        this.descricao = descricao;
        this.ativo = ativo;
    }

}
