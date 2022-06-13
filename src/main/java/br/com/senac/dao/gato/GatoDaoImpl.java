package br.com.senac.dao.gato;

import br.com.senac.dao.BaseDaoImpl;
import br.com.senac.entidade.Gato;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;

public class GatoDaoImpl extends BaseDaoImpl<Gato, Long> implements GatoDao {

    @Override
    public Gato pesquisarPorID(Long id, Session sessao) throws HibernateException {
        return sessao.get(Gato.class, id);
    }

    @Override
    public List<Gato> pesquisarPorNome(String nome, Session session) {
        Query<Gato> consulta = session.createQuery("from Gato g where g.nome like :nome");
        consulta.setParameter("nome", "%" + nome + "%");
        return consulta.getResultList();
    }

    @Override
    public List<Gato> pesquisarPorComportamento(String comportamento, Session session) {
        Query<Gato> consulta = session.createQuery("From Gato g where g.comportamento = :comportamento");
        consulta.setParameter("comportamento", comportamento);
        return consulta.getResultList();
    }

}
