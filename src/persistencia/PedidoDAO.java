package persistencia;

import org.hibernate.Session;
import org.hibernate.Transaction;

import bean.Pedido;

public class PedidoDAO {
	
	public static void inserir(Pedido pedido) {

		Session sessao = HibernateUtil.getSesseionfactory().openSession();
		Transaction t = sessao.beginTransaction();
		sessao.save(pedido);
		t.commit();
		sessao.close();
	}
	
	public static void alterar(Pedido pedido) {

		Session sessao = HibernateUtil.getSesseionfactory().openSession();
		Transaction t = sessao.beginTransaction();
		sessao.update(pedido);
		t.commit();
		sessao.close();
	}

}
