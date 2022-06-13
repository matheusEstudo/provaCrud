package br.com.senac.entidade;

import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.*;

@Getter
@Setter
@ToString
@Entity
@Table(name = "gato")
@PrimaryKeyJoinColumn(name = "id_animal")
public class Gato extends Animal {

    @Column(nullable = false)
    private Boolean fiv;

    @Column(nullable = false)
    private Boolean felv;

    public Gato() {
    }

    public Gato(Boolean fiv, Boolean felv, String nome, Date nascimento, Double peso, String sexo, String observacao, Comportamento comportamento) {
        super(nome, nascimento, peso, sexo, observacao, comportamento);
        this.fiv = fiv;
        this.felv = felv;
    }

}
