package de.appserver.service;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import de.appserver.dao.UserInterface;
import de.appserver.entities.User;


@Stateless
public class service implements ServiceInterface{
	
	@EJB(beanInterface= de.appserver.dao.UserInterface.class)
	private UserInterface dao;
	
	public void createUser(User u){
		dao.createUser(u);
	}

}
