package br.com.senac.dao.cachorro;

import br.com.senac.dao.BaseDao;
import br.com.senac.entidade.Cachorro;
import java.util.List;
import org.hibernate.Session;

public interface CachorroDao extends BaseDao<Cachorro, Long> {

    List<Cachorro> pesquisarPorNome(String nome, Session session);

}
