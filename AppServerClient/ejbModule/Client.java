import java.util.HashMap;
import java.util.Hashtable;

import javax.naming.Context;
import javax.naming.InitialContext;

import de.appserver.entities.Name;
import de.appserver.entities.User;
import de.appserver.service.ServiceInterface;


public class Client {

	public static void main(String[] args) {
		User u = new User();
		Name n = new Name();
		
		n.setFirstname("Eduard");
		n.setLastname("Schartner");
		
		u.setName(n);
		u.setPassword("1234");
		u.setUsername("eddy");
		
		System.out.println(u.getName().getFirstname());
	
		try{
			final Hashtable<String, Comparable> jndiProperties = new Hashtable<String, Comparable>();
			jndiProperties.put(Context.INITIAL_CONTEXT_FACTORY, "org.jboss.naming.remote.client.InitialContextFactory");
			jndiProperties.put("jboss.naming.client.ejb.context", true);
			jndiProperties.put(Context.PROVIDER_URL, "http-remoting://localhost:8080");
			final Context context = new InitialContext(jndiProperties);
			
			final String lookupName = "/AppServerEAR/AppServer/service!de.appserver.service.ServiceInterface";
			
			ServiceInterface ser = (ServiceInterface) context.lookup(lookupName);
			
			ser.createUser(u);
			
		}catch (Exception e){
			
		}
	}

}
