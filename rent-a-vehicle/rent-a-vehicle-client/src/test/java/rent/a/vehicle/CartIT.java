package rent.a.vehicle;

import java.util.List;

import org.junit.Test;

import rent.a.vehicle.utils.ServiceLocator;

public class CartIT {

    @Test
    public void testSayHelloTo() throws Exception {
        String appName = "rent-a-vehicle-ear";
        String moduleName = "rent-a-vehicle-ejb";
        String beanName = "CartBean";
        Class<Cart> viewClass = Cart.class;
        
        Cart warenkorb = ServiceLocator.lookupStatefulService(appName, moduleName, "", beanName, viewClass);
        
        warenkorb.addProduct("MacBook Pro");
        warenkorb.addProduct("IntelliJ IDEA 12");
        warenkorb.addProduct("IntelliJ IDEA 11");
        warenkorb.addProduct("IntelliJ IDEA 10");

        List<String> ids = warenkorb.listProducts();
        for (String product : ids) {
            System.out.println(product);
        }
        
        warenkorb.buy();
        
        warenkorb.addProduct("XYZ");
        
    }

}
