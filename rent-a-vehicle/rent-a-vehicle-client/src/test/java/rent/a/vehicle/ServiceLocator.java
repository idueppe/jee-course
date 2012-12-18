package rent.a.vehicle;

import java.util.Hashtable;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class ServiceLocator {

    /**
     * 
     * The app name is the application name of the deployed EJBs. This is typically the ear name
     * without the .ear suffix. However, the application name could be overridden in the application.xml of the
     * EJB deployment on the server.
     * 
     * Since we haven't deployed the application as a .ear, the app name for us will be an empty string
     * This is the module name of the deployed EJBs on the server. This is typically the jar name of the
     * EJB deployment, without the .jar suffix, but can be overridden via the ejb-jar.xml
     * In this example, we have deployed the EJBs in a jboss-as-ejb-remote-app.jar, so the module name is
     * jboss-as-ejb-remote-app AS7 allows each deployment to have an (optional) distinct name. We haven't specified a distinct name for
     * our EJB deployment, so this is an empty string 
     * The EJB name which by default is the simple class name of the bean implementation class the remote view fully qualified class name
     * let's do the lookup (notice the ?stateful string as the last part of the jndi name for stateful bean lookup)
     * 
     * @param 
     *    appName This is the name of the .ear (without the .ear suffix) that you have deployed on the server and contains your EJBs. 
     * @param moduleName This is the name of the .jar (without the .jar suffix) that you have deployed on the server and the contains your EJBs. 
     *    If the EJBs are deployed in a .war then the module name is the .war name (without the .war suffix).
     * @param distinctName This is a JBoss AS7 specific name which can be optionally assigned to the deployments that are deployed on the server. 
     *    More about the purpose and usage of this will be explained in a separate chapter. 
     *    If a deployment doesn't use distinct-name then, use an empty string in the JNDI name, for distinct-name
     * @param beanName This is the name of the bean for which you are doing the lookup. 
     *    The bean name is typically the unqualified classname of the bean implementation 
     *    class, but can be overriden through either ejb-jar.xml or via annotations. 
     *    The bean name part cannot be an empty string in the JNDI name.
     * @param viewClass
     *    This is the fully qualified class name of the interface for which you are doing the lookup. The interface should be one of the remote interfaces exposed by the bean on the server. The fully qualified class name part cannot be an empty string in the JNDI name.
     * @return
     * @throws Exception
     */
    @SuppressWarnings("unchecked")
    public static <T> T lookupStatelessService(String appName, String moduleName, String distinctName, String beanName, Class<T> viewClass) throws Exception {
        final Context context = getContext();
        return (T) context.lookup("ejb:" + appName + "/" + moduleName + "/" + distinctName + "/" + beanName + "!" + viewClass.getName() + "?stateless");
    }

    @SuppressWarnings("unchecked")
    public static <T> T lookupStatefulService(String appName, String moduleName, String distinctName, String beanName, Class<T> viewClass) throws Exception {
        final Context context = getContext();
        return (T) context.lookup("ejb:" + appName + "/" + moduleName + "/" + distinctName + "/" + beanName + "!" + viewClass.getName() + "?stateful");
    }
    
    @SuppressWarnings({"unchecked","rawtypes"})
    private static Context getContext() throws NamingException {
        final Hashtable jndiProperties = new Hashtable();
        jndiProperties.put(Context.URL_PKG_PREFIXES, "org.jboss.ejb.client.naming");
        final Context context = new InitialContext(jndiProperties);
        return context;
    }
}
