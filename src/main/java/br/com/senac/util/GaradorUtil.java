package br.com.senac.util;

import br.com.senac.entidade.Comportamento;
import com.github.javafaker.Faker;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class GaradorUtil {

    private static final Faker FAKER = new Faker();
    private static final Random R = new Random();

    public static String gerarNome() {
        List<String> nomes = new ArrayList<>();
        nomes.add("luke");
        nomes.add("laica");
        nomes.add("pitoco");
        nomes.add("bob");
        nomes.add("minnie");
        nomes.add("nico");
        nomes.add("amy");
        nomes.add("natasha");

        Collections.shuffle(nomes);
        return nomes.get(0);
    }

    public static String gerarSexo() {
        List<String> sexos = new ArrayList<>();
        sexos.add("masculino");
        sexos.add("femenino");

        Collections.shuffle(sexos);
        return sexos.get(0);
    }

    public static Double gerarPeso() {
        return Double.parseDouble(R.nextInt(90) + "." + R.nextInt(10));
    }

    public static Boolean gerarBooleano() {
        List<Boolean> teinados = new ArrayList<>();
        teinados.add(true);
        teinados.add(false);

        Collections.shuffle(teinados);
        return teinados.get(0);
    }

    public static void main(String[] args) {

    }

}
