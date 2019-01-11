package formationJpa.dao.Ordinateur;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import formation.Jpa.model.Ordinateur;
import formation.Jpa.util.Context;

public class DaoOrdinateurJpaImpl implements DaoOrdinateur {

	@SuppressWarnings("unchecked") 
	public List<Ordinateur> findAll() {
		List<Ordinateur> ordinateurs = null;
		EntityManager em = Context.getEntityManagerFactory().createEntityManager();
		Query query = em.createQuery("select o from Ordinateur o"); //"from Personne p" fonctionne aussi
		ordinateurs=query.getResultList();
		return ordinateurs;
	}

	public Ordinateur findByKey(String key) {
		EntityManager em = Context.getEntityManagerFactory().createEntityManager();
		Ordinateur o = null;
		o = em.find(Ordinateur.class, key);
		em.close();
		return o;
	}

	public void insert(Ordinateur obj) {
		EntityManager em = Context.getEntityManagerFactory().createEntityManager();
		EntityTransaction tx = null;
		try {
			tx = em.getTransaction();
			tx.begin();
			em.persist(obj);
			tx.commit();
		} catch (Exception e) {
			if (tx != null && tx.isActive()) {
				tx.rollback();
			}
		}
		em.close();

	}

	public void update(Ordinateur obj) {
		EntityManager em = Context.getEntityManagerFactory().createEntityManager();
		EntityTransaction tx = null;
		try {
			tx = em.getTransaction();
			tx.begin();
			em.merge(obj);
			tx.commit();
		} catch (Exception e) {
			if (tx != null && tx.isActive()) {
				tx.rollback();
			}
		}
		em.close();

	}

	public void delete(Ordinateur objet) {
		EntityManager em = Context.getEntityManagerFactory().createEntityManager();
		EntityTransaction tx = null;
		try {
			tx = em.getTransaction();
			tx.begin();
			em.remove(em.merge(objet));
			tx.commit();
		} catch (Exception e) {
			if (tx != null && tx.isActive()) {
				tx.rollback();
			}
		}
		em.close();
	}

	public void deleteByKey(String key) {
		EntityManager em = Context.getEntityManagerFactory().createEntityManager();
		EntityTransaction tx = null;
		try {
			tx = em.getTransaction();
			tx.begin();
			em.remove(em.find(Ordinateur.class, key));
			tx.commit();
		} catch (Exception e) {
			if (tx != null && tx.isActive()) {
				tx.rollback();
			}
		}
		em.close();
	}

}
