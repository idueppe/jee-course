package rent.a.vehicle;

import java.util.List;

import org.junit.Test;

public class CartIT {

    @Test
    public void testSayHelloTo() throws Exception {
        String appName = "rent-a-vehicle-ear";
        String moduleName = "rent-a-vehicle-ejb";
        String beanName = "WarenkorbBean";
        Class<Warenkorb> viewClass = Warenkorb.class;
        
        Warenkorb warenkorb = ServiceLocator.lookupStatefulService(appName, moduleName, "", beanName, viewClass);
        
        warenkorb.addProduct("MacBook Pro");
        warenkorb.addProduct("IntelliJ IDEA 12");

        List<String> ids = warenkorb.listProducts();
        for (String product : ids) {
            System.out.println(product);
        }
        
        warenkorb.buy();
        
        
    }

}
