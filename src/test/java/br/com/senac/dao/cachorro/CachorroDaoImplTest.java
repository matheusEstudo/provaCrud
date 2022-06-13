package br.com.senac.dao.cachorro;

import br.com.senac.dao.HibernateUtil;
import br.com.senac.dao.comportamento.ComportamentoDaoImplTest;
import br.com.senac.entidade.Cachorro;
import br.com.senac.entidade.Comportamento;
import static br.com.senac.util.GaradorUtil.*;
import com.github.javafaker.Faker;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.junit.Test;
import static org.junit.Assert.*;

public class CachorroDaoImplTest {

    private Cachorro cachorro;
    private final CachorroDao cachorroDao;
    private final ComportamentoDaoImplTest cdit;
    private Session session;
    private final Faker FAKER = new Faker();

    public CachorroDaoImplTest() {
        cachorroDao = new CachorroDaoImpl();
        cdit = new ComportamentoDaoImplTest();
    }

    @Test
    public void testSalvar() {
        System.out.println("salvar");

        Date data = new Date();
        Comportamento comportamento = cdit.buscarbd();
        cachorro = new Cachorro(gerarBooleano(),
                gerarNome(),
                data,
                gerarPeso(),
                gerarSexo(),
                FAKER.lorem().sentence(),
                comportamento);
        session = HibernateUtil.abrirConexao();
        cachorroDao.salvarOuAlterar(cachorro, session);
        session.close();
        assertNotNull(cachorro.getId());
    }

//    @Test
    public void testAlterar() {
        System.out.println("alterar");
        cachorro = buscarbd();
        cachorro.setNome(gerarNome());
        session = HibernateUtil.abrirConexao();
        cachorroDao.salvarOuAlterar(cachorro, session);
        session.close();

    }

//    @Test
    public void testDeletar() {
        System.out.println("deletar");
        cachorro = buscarbd();
        session = HibernateUtil.abrirConexao();
        cachorroDao.excluir(cachorro, session);
        session.close();

    }

//    @Test
    public void testPesqusarId() {
        System.out.println("pesquisar por id");
        cachorro = buscarbd();
        session = HibernateUtil.abrirConexao();
        cachorroDao.pesquisarPorID(cachorro.getId(), session);
        session.close();

    }

//    @Test
    public void testPesqusarNome() {
        System.out.println("pesquisar por nome");
        cachorro = buscarbd();
        session = HibernateUtil.abrirConexao();
        List<Cachorro> cachorros = cachorroDao.pesquisarPorNome(cachorro.getNome(), session);
        session.close();

        for (Cachorro cachorroList : cachorros) {
            System.out.println("nome: " + cachorroList.getNome()
                    + "\ntipo comportamento: " + cachorroList.getComportamento().getTipo());
        }

    }

//    @Test
    public void testTodosTreinado() {
        System.out.println("todos treinado");
        session = HibernateUtil.abrirConexao();
        List<Cachorro> cachorros = cachorroDao.todosTreinado(session);
        session.close();

        for (Cachorro cachorroList : cachorros) {
            System.out.println("nome: " + cachorroList.getNome()
                    + "\n treinamento " + cachorroList.getTreinamento());
        }

    }

    public Cachorro buscarbd() {
        session = HibernateUtil.abrirConexao();
        Query<Cachorro> consulta = session.createQuery("from Cachorro c");
        List<Cachorro> Cachorros = consulta.getResultList();
        session.close();
        Collections.shuffle(Cachorros);

        return Cachorros.get(0);

    }
}
