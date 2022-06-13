package br.com.senac.dao.cachorro;

import br.com.senac.dao.BaseDaoImpl;
import br.com.senac.entidade.Cachorro;
import org.hibernate.HibernateException;
import org.hibernate.Session;

public class CachorroDaoImpl extends BaseDaoImpl<Cachorro, Long> implements CachorroDao {

    @Override
    public Cachorro pesquisarPorID(Long id, Session sessao) throws HibernateException {
        return sessao.get(Cachorro.class, id);
    }

}
