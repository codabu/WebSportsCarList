package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.ListItem;

public class LIHelper {

	EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("ConsoleSportsCarList"); 
	

	//showAllItems method - creates a List with all the items in the database and returns that list
	public List<ListItem> showAllItems() {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		List<ListItem> allItems = em.createQuery("SELECT i FROM ListItem i").getResultList();
		return allItems;
	}
	
	//insertItem method - takes a ListItem object and adds it to the database
	public void insertItem(ListItem li) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(li);
		em.getTransaction().commit();
		em.close();
	}
	
	//updatItem method - takes an edited ListItem and updates it in the DB
	public void updateItem(ListItem toEdit) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		
		em.merge(toEdit);
		em.getTransaction().commit();
		em.close();
	}

	//delete item - makes a TypedQuery with the parameters make, model and year. Query retruns that item in the db and then it removes that item from the db
	public void deleteItem(ListItem toDelete) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<ListItem> typedQuery = em.createQuery("select li from ListItem li where li.make = :selectedMake and li.model = :selectedModel and li.year = :selectedYear", ListItem.class);

		//Swap out the parameters with actual data from toDelete 
		typedQuery.setParameter("selectedMake", toDelete.getMake());
		typedQuery.setParameter("selectedModel", toDelete.getModel());
		typedQuery.setParameter("selectedYear", toDelete.getYear());

		//make sure there's only one result
		typedQuery.setMaxResults(1);

		//get the item that matches the parameters and save it to a list item
		ListItem result = typedQuery.getSingleResult();

		//remove it
		em.remove(result);
		em.getTransaction().commit();
		em.close();
	}

	
	//searchForCarByMake method lists all cars in the db matching the makeName parameter
	public List<ListItem> searchForCarByMake(String makeName) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<ListItem> typedQuery = em.createQuery("select li from ListItem li where li.make = :selectedMake", ListItem.class);
		typedQuery.setParameter("selectedMake", makeName);

		List<ListItem> foundItems = typedQuery.getResultList();
		em.close();
		return foundItems;
	}

	//searchForCarByModel method lists all cars in the db matching the modelName parameter
	public List<ListItem> searchForCarByModel(String modelName) {
				EntityManager em = emfactory.createEntityManager();
				em.getTransaction().begin();
				TypedQuery<ListItem> typedQuery = em.createQuery("select li from ListItem li where li.model = :selectedModel", ListItem.class);
				typedQuery.setParameter("selectedModel", modelName);

				List<ListItem> foundItems = typedQuery.getResultList();
				em.close();
				return foundItems;
	}

	//searchForCarByYear method lists all cars in the db matching the year parameter
	public List<ListItem> searchForCarByYear(String year) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<ListItem> typedQuery = em.createQuery("select li from ListItem li where li.year = :selectedYear", ListItem.class);
		typedQuery.setParameter("selectedYear", year);

		List<ListItem> foundItems = typedQuery.getResultList();
		em.close();
		return foundItems;
	}

	//the search for car by ID searches for a car by id and returns that list item - used when an item is edited in the db
	public ListItem searchForCarById(int idToEdit) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		ListItem found = em.find(ListItem.class, idToEdit);
		em.close();
		return found;
	}
	
	//cleanUp method closes off the connection to the db
	public void cleanUp() {
		emfactory.close();
	}

}
