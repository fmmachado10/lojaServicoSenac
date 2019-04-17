package persistencia;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import bean.Servico;

public class ServicoDAO {

	
	public static void inserir(Servico servico) {

		Session sessao = HibernateUtil.getSesseionfactory().openSession();
		Transaction t = sessao.beginTransaction();
		sessao.save(servico);
		t.commit();
		sessao.close();
	}

	public static void alterar(Servico servico) {

		Session sessao = HibernateUtil.getSesseionfactory().openSession();
		Transaction t = sessao.beginTransaction();
		sessao.update(servico);
		t.commit();
		sessao.close();
	}
	
	public static void excluir(Servico servico) {

		Session sessao = HibernateUtil.getSesseionfactory().openSession();
		Transaction t = sessao.beginTransaction();
		sessao.delete(servico);
		t.commit();
		sessao.close();
	}
	
	public static List<Servico> listagem(String filtro) {
		
		Session sessao = HibernateUtil.getSesseionfactory().openSession();
		
		Query consulta;
		
		if(filtro.trim().length() == 0) {
			
			consulta = sessao.createQuery("from Servico order by nome");
			
		}else {
			
			consulta = sessao.createQuery("from Servico where pro_nome like :parametro order by nome");
			
			consulta.setString(":parametro", "%" + filtro + "%");
			
		}
		
		List lista = consulta.list();
		
		sessao.close();
		
		return lista;
		
		
	}
	
	 public static List<Servico> consultar(){
		 
		 Session sessao = HibernateUtil.getSesseionfactory().openSession();
			
			Query consulta;
			
			consulta = sessao.createQuery("from Servico order by nome");
			
			List lista = consulta.list();
			
			sessao.close();
			
			return lista;
	        
	    }
	
	

}
