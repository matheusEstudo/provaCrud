package br.com.senac.dao.gato;

import br.com.senac.dao.HibernateUtil;
import br.com.senac.dao.comportamento.ComportamentoDaoImplTest;
import br.com.senac.entidade.Comportamento;
import static br.com.senac.util.GaradorUtil.*;
import br.com.senac.entidade.Gato;
import com.github.javafaker.Faker;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.junit.Test;
import static org.junit.Assert.*;

public class GatoDaoImplTest {

    private Gato gato;
    private final GatoDao gatoDao;
    private final ComportamentoDaoImplTest cdit;
    private Session session;
    private final Faker FAKER = new Faker();

    public GatoDaoImplTest() {
        gatoDao = new GatoDaoImpl();
        cdit = new ComportamentoDaoImplTest();
    }

//    @Test
    public void testSomeMethod() {

        System.out.println("salvar");

        Comportamento comportamento = cdit.buscarbd();
        Date data = new Date();
        gato = new Gato(gerarBooleano(),
                gerarBooleano(),
                gerarNome(),
                data,
                gerarPeso(),
                gerarSexo(),
                FAKER.lorem().sentence(),
                comportamento);

        session = HibernateUtil.abrirConexao();
        gatoDao.salvarOuAlterar(gato, session);
        session.close();
        assertNotNull(gato.getId());
    }

//    @Test
    public void testAlterar() {
        System.out.println("alterar");
        gato = buscarbd();
        gato.setNome(gerarNome());
        session = HibernateUtil.abrirConexao();
        gatoDao.salvarOuAlterar(gato, session);
        session.close();

    }

//    @Test
    public void testPesqusarId() {
        System.out.println("pesquisar por id");
        gato = buscarbd();
        session = HibernateUtil.abrirConexao();
        gatoDao.pesquisarPorID(gato.getId(), session);
        session.close();

    }

//    @Test
    public void testDeletar() {
        System.out.println("deletar");
        gato = buscarbd();
        session = HibernateUtil.abrirConexao();
        gatoDao.excluir(gato, session);
        session.close();

    }

//    @Test
    public void testPesqusarNome() {
        System.out.println("pesquisar por nome");
        gato = buscarbd();
        session = HibernateUtil.abrirConexao();
        List<Gato> gatos = gatoDao.pesquisarPorNome(gato.getNome(), session);
        session.close();

        for (Gato gatoList : gatos) {
            System.out.println("nome: " + gatoList.getNome()
                    + "\ntipo comportamento: " + gatoList.getComportamento().getTipo());
        }

    }

    @Test
    public void testPesqusarComportamento() {
        System.out.println("pesquisar por nome");
        session = HibernateUtil.abrirConexao();
        List<Gato> gatos = gatoDao.pesquisarPorComportamento("agressivo", session);
        session.close();

        for (Gato gatoList : gatos) {
            System.out.println("nome: " + gatoList.getNome());

        }

    }

    public Gato buscarbd() {
        session = HibernateUtil.abrirConexao();
        Query<Gato> consulta = session.createQuery("from Gato g");
        List<Gato> Cachorros = consulta.getResultList();
        session.close();
        Collections.shuffle(Cachorros);

        return Cachorros.get(0);

    }

}
