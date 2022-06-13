package br.com.senac.dao.comportamento;

import br.com.senac.dao.BaseDaoImpl;
import br.com.senac.entidade.Comportamento;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;

public class ComportamentoDaoImpl extends BaseDaoImpl<Comportamento, Long> implements ComportamentoDao {

    @Override
    public Comportamento pesquisarPorID(Long id, Session sessao) throws HibernateException {
        return sessao.get(Comportamento.class, id);
    }

    @Override
    public List<Comportamento> pesquisaTudo(Session sessao) {
        Query<Comportamento> consulta = sessao.createQuery("from Comportamento c");
        return consulta.getResultList();
    }

}
