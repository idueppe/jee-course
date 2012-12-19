package rent.a.vehicle.util.jpa;

import java.io.IOException;
import java.net.URL;
import java.util.Enumeration;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class PersistenceHelper {
    
    private static void wrapClassLoader() {
        ClassLoader current = Thread.currentThread().getContextClassLoader();
        Thread.currentThread().setContextClassLoader(new ClassLoader(current) {
            public Enumeration<URL> getResources(String name) throws IOException {
                if ("META-INF/persistence.xml".equals(name)) {
                    Enumeration<URL> resources = super.getResources("META-INF/test-persistence.xml");
                    return resources;
                } else {
                    return super.getResources(name);
                }
            }
        });
    }
    
    public static EntityManagerFactory createEntityManagerFactory(String name) {
        wrapClassLoader();
        return Persistence.createEntityManagerFactory(name);
    }

}
