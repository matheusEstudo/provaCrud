package br.com.senac.dao.comportamento;

import br.com.senac.dao.HibernateUtil;
import br.com.senac.entidade.Comportamento;
import org.hibernate.Session;
import org.junit.Test;
import static br.com.senac.util.GaradorUtil.*;
import java.util.Collections;
import java.util.List;
import org.hibernate.query.Query;
import static org.junit.Assert.*;

public class ComportamentoDaoImplTest {

    private Comportamento comportamento;
    private final ComportamentoDao comportamentoDao;
    private Session session;

    public ComportamentoDaoImplTest() {
        comportamentoDao = new ComportamentoDaoImpl();
    }

//    @Test
    public void testSalvar() {

        session = HibernateUtil.abrirConexao();
        comportamento = gerarComportamento();
        comportamentoDao.salvarOuAlterar(comportamento, session);
        session.close();
        assertNotNull(comportamento.getId());

    }

//    @Test
    public void testDeletar() {
        comportamento = buscarbd();
        session = HibernateUtil.abrirConexao();
        comportamentoDao.excluir(comportamento, session);
        session.close();
    }

//    @Test
    public void testAlterar() {
        comportamento = buscarbd();
        comportamento.setTipo(comportamento.getTipo() + " alterado");
        session = HibernateUtil.abrirConexao();
        comportamentoDao.salvarOuAlterar(comportamento, session);
        session.close();
    }

//    @Test
    public void testPesqusarId() {
        comportamento = buscarbd();
        session = HibernateUtil.abrirConexao();
        comportamentoDao.pesquisarPorID(comportamento.getId(), session);
        session.close();
    }

//    @Test
    public void testPesqusarTudo() {
        session = HibernateUtil.abrirConexao();
        List<Comportamento> comportamentos = comportamentoDao.pesquisaTudo(session);
        session.close();

        for (Comportamento comportamentoLista : comportamentos) {
            System.out.println(comportamentoLista.toString());
        }

    }

    public Comportamento buscarbd() {
        session = HibernateUtil.abrirConexao();
        Query<Comportamento> consulta = session.createQuery("from Comportamento c");
        List<Comportamento> comportamentos = consulta.getResultList();
        session.close();
        Collections.shuffle(comportamentos);

        return comportamentos.get(0);
    }

}
