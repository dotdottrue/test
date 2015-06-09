package de.appserver.dao;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import de.appserver.entities.User;


@Stateless
public class UserDAO implements UserInterface{
	
	@PersistenceContext
	private EntityManager em;
	
	public void createUser(User user){
		em.persist(user);
	}

}
