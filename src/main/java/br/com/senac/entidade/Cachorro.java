package br.com.senac.entidade;

import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.*;

@Getter
@Setter
@ToString
@Entity
@Table(name = "cachorro")
@PrimaryKeyJoinColumn(name = "id_animal")
public class Cachorro extends Animal {

    @Column(nullable = false)
    private Boolean treinamento;

    public Cachorro() {
    }

    public Cachorro(Boolean treinamento, String nome, Date nascimento, Double peso, String sexo, String observacao, Comportamento comportamento) {
        super(nome, nascimento, peso, sexo, observacao, comportamento);
        this.treinamento = treinamento;
    }

   
  
}
