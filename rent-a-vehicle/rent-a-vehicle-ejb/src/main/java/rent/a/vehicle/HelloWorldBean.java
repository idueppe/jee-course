package rent.a.vehicle;

import java.util.logging.Logger;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.Remote;
import javax.ejb.Stateless;

@Stateless
@Remote(HelloWorld.class)
public class HelloWorldBean implements HelloWorld {
    
    private final static Logger LOG = Logger.getLogger(HelloWorldBean.class.getName());
    
    public HelloWorldBean() {
        LOG.info("HelloWorldBean constructor called!");
    }
    
    @Override
    public String sayHelloTo(String name) {
        return "Hello "+name+"!";
    }
    
    @PostConstruct
    public void setUp() {
        // Initialisierung des Beans 
        LOG.info("Hello World is constructed!");
    }
    
    @PreDestroy
    public void tearDown() {
        
    }

}
