package de.appserver.service;

import javax.ejb.Remote;

import de.appserver.entities.User;

@Remote
public interface ServiceInterface {

	public void createUser(User u);
}
