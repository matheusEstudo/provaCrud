package br.com.senac.dao.comportamento;

import br.com.senac.dao.BaseDao;
import br.com.senac.entidade.Comportamento;
import java.util.List;
import org.hibernate.Session;

public interface ComportamentoDao extends BaseDao<Comportamento, Long> {

    List<Comportamento> pesquisaTudo(Session sessao);

}
