package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.ListItem;
import model.Owner;

public class OwnerHelper {

	EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("ConsoleSportsCarList"); 
	
	
	public List<ListItem> showAllOwners() {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		List<ListItem> allOwners = em.createQuery("SELECT i FROM Owner i").getResultList();
		return allOwners;
	}
	
	
	public void insertItem(Owner o) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(o);
		em.getTransaction().commit();
		em.close();
		
	}

	//cleanUp method closes off the connection to the db
		public void cleanUp() {
			emfactory.close();
		}
	
}
