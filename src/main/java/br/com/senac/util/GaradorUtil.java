package br.com.senac.util;

import br.com.senac.entidade.Comportamento;
import com.github.javafaker.Faker;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GaradorUtil {

    private static final Faker FAKER = new Faker();

    public static Comportamento gerarComportamento() {

        List<String> tipos = new ArrayList<>();
        tipos.add("raivoso");
        tipos.add("carinhoso");
        tipos.add("nervoso");
        tipos.add("tristinho");
        tipos.add("dorminhoco");
        tipos.add("hiperativo");
        tipos.add("sonhador");
        Collections.shuffle(tipos);
        return new Comportamento(tipos.get(0), FAKER.lorem().sentence(), false);
    }

    public static void main(String[] args) {
        System.out.println(gerarComportamento());
    }

}
