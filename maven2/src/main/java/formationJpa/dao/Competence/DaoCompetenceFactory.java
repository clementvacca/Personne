package formationJpa.dao.Competence;

public class DaoCompetenceFactory {
	private static DaoCompetence singleton=null;
	public static DaoCompetence getInstance() {
		if(singleton==null) {
			singleton=new DaoCompetenceJpaImpl();
		}
		return singleton;
	}
}
