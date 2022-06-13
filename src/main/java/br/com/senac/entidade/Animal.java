package br.com.senac.entidade;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.*;

@Getter
@Setter
@EqualsAndHashCode
@ToString
@Entity
@Table(name = "animal")
@Inheritance(strategy = InheritanceType.JOINED)
public class Animal implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private Date nascimento;

    @Column(nullable = false)
    private Double peso;

    @Column(nullable = false)
    private String sexo;

    @Column(nullable = false)
    private String observacao;

    @JoinColumn(name = "id_comportamento")
    @OneToOne
    private Comportamento comportamento;

    public Animal() {
    }

    public Animal(String nome, Date nascimento, Double peso, String sexo, String observacao, Comportamento comportamento) {
        this.nome = nome;
        this.nascimento = nascimento;
        this.peso = peso;
        this.sexo = sexo;
        this.observacao = observacao;
        this.comportamento = comportamento;
    }

}
