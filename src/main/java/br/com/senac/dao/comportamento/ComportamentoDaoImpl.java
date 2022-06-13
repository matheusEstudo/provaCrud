package br.com.senac.dao.comportamento;

import br.com.senac.dao.BaseDaoImpl;
import br.com.senac.entidade.Comportamento;
import org.hibernate.HibernateException;
import org.hibernate.Session;

public class ComportamentoDaoImpl extends BaseDaoImpl<Comportamento, Long> implements ComportamentoDao {

    @Override
    public Comportamento pesquisarPorID(Long id, Session sessao) throws HibernateException {
        return sessao.get(Comportamento.class, id);
    }

}
