package formation.Jpa.util;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Context {
	private static EntityManagerFactory emf=null;
	public static EntityManagerFactory getEntityManagerFactory(){
		if (emf==null) { 
			emf=Persistence.createEntityManagerFactory("formationJpa");
		}
		return emf;
	}
	public static void close() {
		emf.close();
	}


}
