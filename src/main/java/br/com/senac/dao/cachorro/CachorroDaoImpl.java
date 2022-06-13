package br.com.senac.dao.cachorro;

import br.com.senac.dao.BaseDaoImpl;
import br.com.senac.entidade.Cachorro;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;

public class CachorroDaoImpl extends BaseDaoImpl<Cachorro, Long> implements CachorroDao {

    @Override
    public Cachorro pesquisarPorID(Long id, Session sessao) throws HibernateException {
        return sessao.get(Cachorro.class, id);
    }

    @Override
    public List<Cachorro> pesquisarPorNome(String nome, Session session) {
        Query<Cachorro> consulta = session.createQuery("from Cachorro c where c.nome like :nome");
        consulta.setParameter("nome", "%" + nome + "%");
        return consulta.getResultList();
    }

    @Override
    public List<Cachorro> todosTreinado(Session session) {
        Query<Cachorro> consulta = session.createQuery("from Cachorro c where c.treinamento = TRUE");
        return consulta.getResultList();
    }

}
