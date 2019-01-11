package formationJpa.dao.Ordinateur;

public class DaoOrdinateurFactory {
	private static DaoOrdinateur singleton=null;
	public static DaoOrdinateur getInstance() {
		if(singleton==null) {
			singleton=new DaoOrdinateurJpaImpl();
		}
		return singleton;
	}
}
