package rent.a.vehicle;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import java.util.Hashtable;

public class JNDI {
	
	public static final Hashtable<String,String> JBOSS_ENV = new Hashtable<String,String>();
	public static final Hashtable<String,String> GLASSFISH_ENV = new Hashtable<String,String>();
	
	private static final Hashtable<String,String> DEFAULT_ENV = null;
	
	static {
		JBOSS_ENV.put( Context.INITIAL_CONTEXT_FACTORY, "org.jnp.interfaces.NamingContextFactory" );
		JBOSS_ENV.put( Context.PROVIDER_URL, "localhost:1099" );
		JBOSS_ENV.put( Context.URL_PKG_PREFIXES, "org.jboss.naming:org.jnp.interfaces" );
	}


	public static Object lookup(Hashtable<String,String> env, String path) throws NamingException {
		Context ctx = new InitialContext( env );
		Object obj = ctx.lookup( path );
		ctx.close();
		return obj;
	}
	
	public static Object lookup(String path) throws NamingException {
		return lookup( DEFAULT_ENV, path );
	}

}
