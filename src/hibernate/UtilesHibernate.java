package hibernate;

import org.hibernate.cfg.Configuration;
import org.hibernate.SessionFactory;

public class UtilesHibernate {

	private static final SessionFactory sessionFactory;
	static {
	try {
	Configuration configuration = new Configuration().configure();
	sessionFactory = configuration.buildSessionFactory();
	}catch (Throwable ex) {
	// Log the exception.
	System.err.println("Error al crear la SessionFactory." +
	ex);
	throw new ExceptionInInitializerError(ex);
	}
	}
	public static SessionFactory getSessionFactory() {
	return sessionFactory;
	}
	
	
}
