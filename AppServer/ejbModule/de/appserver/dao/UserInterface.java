package de.appserver.dao;

import javax.ejb.Local;

import de.appserver.entities.User;

@Local
public interface UserInterface {
	
	public void createUser(User user);

}
