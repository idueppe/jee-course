package rent.a.vehicle;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import javax.ejb.Remote;
import javax.ejb.Remove;
import javax.ejb.Stateful;

@Stateful
@Remote(Cart.class)
public class CartBean implements Serializable, Cart {
    
    private static final Logger log = Logger.getLogger(CartBean.class.getName());
    
    private static final long serialVersionUID = 1L;

    private List<String> productIds = new ArrayList<>();
    
    @Override
    public void addProduct(String productId) {
        productIds.add(productId);
    }
    
    @Override
    public void removeProduct(String productId) {
        productIds.remove(productId);
    }
    
    @Override
    @Remove
    public void buy() {
        for (String productId : listProducts()) {
            log.info("buying: "+productId);
        }
        // do something meaningful.
    }
    
    @Override
    @Remove
    public void cancel() {
        // nothing to do.
    }

    @Override
    public List<String> listProducts() {
        return productIds;
    }
    
}
