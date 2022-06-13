package br.com.senac.dao;

import java.io.Serializable;
import org.hibernate.*;

public abstract class BaseDaoImpl<T, ID> implements BaseDao<T, ID>, Serializable {

    private Transaction transaction;

    @Override
    public void salvarOuAlterar(T entidade, Session sessao) throws HibernateException {
        transaction = sessao.beginTransaction();
        sessao.saveOrUpdate(entidade);
        transaction.commit();
    }

    @Override
    public void excluir(T entidade, Session sessao) throws HibernateException {
        transaction = sessao.beginTransaction();
        sessao.delete(entidade);
        transaction.commit();
    }

}
