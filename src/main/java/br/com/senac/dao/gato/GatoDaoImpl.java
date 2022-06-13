package br.com.senac.dao.gato;

import br.com.senac.dao.BaseDaoImpl;
import br.com.senac.entidade.Gato;
import org.hibernate.HibernateException;
import org.hibernate.Session;

public class GatoDaoImpl extends BaseDaoImpl<Gato, Long> implements GatoDao {

    @Override
    public Gato pesquisarPorID(Long id, Session sessao) throws HibernateException {
        return sessao.get(Gato.class, id);
    }

}
