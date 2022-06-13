package br.com.senac.dao.comportamento;

import br.com.senac.dao.HibernateUtil;
import br.com.senac.entidade.Comportamento;
import org.hibernate.Session;
import org.junit.Test;
import static br.com.senac.util.GaradorUtil.*;
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
        comportamentoDao.salvarOuAlterar(gerarComportamento(), session);
        session.close();
    }

//    @Test
    public void testDeletar() {
        comportamento = new Comportamento("", "", false);
        comportamento.setId(Long.parseLong("1"));
        session = HibernateUtil.abrirConexao();
        comportamentoDao.excluir(comportamento, session);
        session.close();
    }

//    @Test
    public void testAlterar() {
        comportamento = gerarComportamento();
        comportamento.setId(Long.parseLong("2"));
        session = HibernateUtil.abrirConexao();
        comportamentoDao.salvarOuAlterar(comportamento, session);
        session.close();
    }

    public Comportamento buscarbd() {
        session = HibernateUtil.abrirConexao();
        
        return null;
    }

}
