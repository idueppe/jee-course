package rent.a.vehicle;

import javax.ejb.Remote;
import javax.ejb.Stateless;

@Stateless
@Remote(HelloWorld.class)
public class HelloWorldBean implements HelloWorld {
    
    @Override
    public String sayHelloTo(String name) {
        return "Hello "+name+"!";
    }

}
