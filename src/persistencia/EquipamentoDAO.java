package persistencia;

import org.hibernate.Session;
import org.hibernate.Transaction;

import bean.Equipamento;



public class EquipamentoDAO {
	
	
	public static void inserir(Equipamento equipamento) {

		Session sessao = HibernateUtil.getSesseionfactory().openSession();
		Transaction t = sessao.beginTransaction();
		sessao.save(equipamento);
		t.commit();
		sessao.close();
	}

	public static void alterar(Equipamento equipamento) {

		Session sessao = HibernateUtil.getSesseionfactory().openSession();
		Transaction t = sessao.beginTransaction();
		sessao.update(equipamento);
		t.commit();
		sessao.close();
	}
	
	public static void excluir(Equipamento equipamento) {

		Session sessao = HibernateUtil.getSesseionfactory().openSession();
		Transaction t = sessao.beginTransaction();
		sessao.delete(equipamento);
		t.commit();
		sessao.close();
	}

}
