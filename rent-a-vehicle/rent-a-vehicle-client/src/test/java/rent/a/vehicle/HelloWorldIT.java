package rent.a.vehicle;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import rent.a.vehicle.utils.ServiceLocator;

public class HelloWorldIT {
   

    @Test
    public void testSayHelloTo() throws Exception {
        String appName = "rent-a-vehicle-ear";
        String moduleName = "rent-a-vehicle-ejb";
        String distinctName = "";
        String beanName = "HelloWorldBean";
        Class<HelloWorld> viewClass = HelloWorld.class;
        
        HelloWorld helloWorld = ServiceLocator.lookupStatelessService(appName, moduleName, distinctName, beanName, viewClass);
        String greeting = helloWorld.sayHelloTo("Ingo");
        assertEquals("Hello Ingo!", greeting);
    }

}
