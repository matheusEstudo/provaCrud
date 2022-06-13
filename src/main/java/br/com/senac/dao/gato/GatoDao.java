package br.com.senac.dao.gato;

import br.com.senac.dao.BaseDao;
import br.com.senac.entidade.Gato;
import java.util.List;
import org.hibernate.Session;

public interface GatoDao extends BaseDao<Gato, Long> {

    List<Gato> pesquisarPorNome(String nome, Session session);

    List<Gato> pesquisarPorComportamento(String comportamento, Session session);

}
