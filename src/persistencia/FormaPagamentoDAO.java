package persistencia;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import bean.FormaPagamento;
import bean.Pessoa;

public class FormaPagamentoDAO {
	
	public static void inserir(FormaPagamento formaPagamento) {

		Session sessao = HibernateUtil.getSesseionfactory().openSession();
		Transaction t = sessao.beginTransaction();
		sessao.save(formaPagamento);
		t.commit();
		sessao.close();
	}

	public static void alterar(FormaPagamento formaPagamento) {

		Session sessao = HibernateUtil.getSesseionfactory().openSession();
		Transaction t = sessao.beginTransaction();
		sessao.update(formaPagamento);
		t.commit();
		sessao.close();
	}

	public static void excluir(FormaPagamento formaPagamento) {

		Session sessao = HibernateUtil.getSesseionfactory().openSession();
		Transaction t = sessao.beginTransaction();
		sessao.delete(formaPagamento);
		t.commit();
		sessao.close();
	}

	public static List<FormaPagamento> consultar() {

		Session sessao = HibernateUtil.getSesseionfactory().openSession();

		Query consulta;

		consulta = sessao.createQuery("from FormaPagamento order by descricao");

		List lista = consulta.list();

		sessao.close();

		return lista;

	}

}
