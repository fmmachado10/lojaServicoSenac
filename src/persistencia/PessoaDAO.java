package persistencia;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import bean.Pessoa;

public class PessoaDAO {

	public static void inserir(Pessoa pessoa) {

		Session sessao = HibernateUtil.getSesseionfactory().openSession();
		Transaction t = sessao.beginTransaction();
		sessao.save(pessoa);
		t.commit();
		sessao.close();
	}

	public static void alterar(Pessoa pessoa) {

		Session sessao = HibernateUtil.getSesseionfactory().openSession();
		Transaction t = sessao.beginTransaction();
		sessao.update(pessoa);
		t.commit();
		sessao.close();
	}

	public static void excluir(Pessoa pessoa) {

		Session sessao = HibernateUtil.getSesseionfactory().openSession();
		Transaction t = sessao.beginTransaction();
		sessao.delete(pessoa);
		t.commit();
		sessao.close();
	}

	public static List<Pessoa> consultar() {

		Session sessao = HibernateUtil.getSesseionfactory().openSession();

		Query consulta;

		consulta = sessao.createQuery("from Pessoa order by nome");

		List lista = consulta.list();

		sessao.close();

		return lista;

	}

}
