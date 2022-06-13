package br.com.senac.dao.cachorro;

import br.com.senac.dao.HibernateUtil;
import br.com.senac.entidade.Cachorro;
import br.com.senac.entidade.Comportamento;
import static br.com.senac.util.GaradorUtil.*;
import com.github.javafaker.Faker;
import java.util.Date;
import org.hibernate.Session;
import org.junit.Test;
import static org.junit.Assert.*;

public class CachorroDaoImplTest {

    private Cachorro cachorro;
    private CachorroDao cachorroDao;
    private Session session;
    private final Faker FAKER = new Faker();

    public CachorroDaoImplTest() {
        cachorroDao = new CachorroDaoImpl();
    }

    @Test
    public void testSalvar() {
        System.out.println("salvar");
        Date data = new Date();
        Comportamento comportamento = new Comportamento("raiva", "sadasdsad", false);
        cachorro = new Cachorro(false, "luke", data, 4.9, "maculino", FAKER.lorem().sentence(), comportamento);
        session = HibernateUtil.abrirConexao();
        cachorroDao.salvarOuAlterar(cachorro, session);
        session.close();

    }

}
