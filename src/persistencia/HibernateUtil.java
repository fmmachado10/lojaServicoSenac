package persistencia;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
	
	private static final SessionFactory sesseionFactory = buildSessionFactory();
	
	private static SessionFactory buildSessionFactory() {
		
		try {
			Configuration cfg = new Configuration();
			cfg.configure("hibernate.cfg.xml");
			
			StandardServiceRegistryBuilder registradorservico = new StandardServiceRegistryBuilder();
			registradorservico.applySettings(cfg.getProperties());
			StandardServiceRegistry servico = registradorservico.build();
			
			return cfg.buildSessionFactory(servico);
				
		} catch (Throwable e) {
			System.out.println("Criacao inicial do objeto Sesseion Factory falhou..." + e);
			throw new ExceptionInInitializerError(e);
		}
		
	}

	public static SessionFactory getSesseionfactory() {
		return sesseionFactory;
	}
		
}
