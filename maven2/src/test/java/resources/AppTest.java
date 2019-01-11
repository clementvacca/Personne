package resources;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import formation.Jpa.model.Competence;
import formation.Jpa.model.Ordinateur;
import formation.Jpa.model.Personne;
import formation.Jpa.util.Context;
import formationJpa.dao.Adresse.Adresse;
import formationJpa.dao.Competence.DaoCompetence;
import formationJpa.dao.Competence.DaoCompetenceFactory;
import formationJpa.dao.Ordinateur.DaoOrdinateur;
import formationJpa.dao.Ordinateur.DaoOrdinateurFactory;
import formationJpa.dao.Personne.Civilite;
import formationJpa.dao.Personne.DaoPersonne;
import formationJpa.dao.Personne.DaoPersonneFactory;

public class AppTest {

	public static void main(String[] args) {
		DaoPersonne daoPersonne=DaoPersonneFactory.getInstance();
		
		Personne clement= new Personne("clement","vacca");
		clement.setCivilite(Civilite.M);
		SimpleDateFormat sdf=new SimpleDateFormat("dd/mm/yyyy");
		try {
			clement.setDateNaissance(sdf.parse("16/01/1995"));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		clement.setAdresse(new Adresse(6,"rue rougemont","75009","paris"));
		daoPersonne.insert(clement);
		
		Personne recherche= daoPersonne.findByKey(100);
		System.out.println(recherche);
		
		DaoOrdinateur daoOrdinateur=DaoOrdinateurFactory.getInstance();
		Ordinateur ordi=new Ordinateur("368",16);
		daoOrdinateur.insert(ordi);
		
		DaoCompetence daoCompetence=DaoCompetenceFactory.getInstance();
		Competence comp=new Competence("JAVA");
		daoCompetence.insert(comp);
		
		
		
		Context.close();
		
//		System.out.println("ok");
//		Personne clement = new Personne("clement", "vacca");
//		System.out.println(clement.getId());
//		EntityManager em = Context.getEntityManagerFactory().createEntityManager();
//		// transaction pour ordre de modification
//		EntityTransaction tx = em.getTransaction();
//		try {
//			tx.begin();
//			// rendre un objet persistant--> avoir une version de l'objet en base (insert)
//			em.persist(clement);
//			clement.setPrenom("aze");
//			tx.commit();
//		} catch (Exception e) {
//			e.printStackTrace();
//			tx.rollback();
//		}
//		em.close();
//		
//		Personne recherche=null;
//		em=Context.getEntityManagerFactory().createEntityManager();
//		tx=em.getTransaction();
//		tx.begin();
//		//recherche=em.find(Personne.class, 100);
//		recherche=new Personne("aaa","");
//		System.out.println("----------------");
//		
//		recherche.setNom("azerty");
//		em.merge(recherche); //
//		tx.commit();
		
	}

}
