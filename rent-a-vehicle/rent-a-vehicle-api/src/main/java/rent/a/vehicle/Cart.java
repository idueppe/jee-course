package rent.a.vehicle;

import java.util.List;

public interface Cart {

    public abstract void addProduct(String productId);

    public abstract void removeProduct(String productId);
    
    public abstract List<String> listProducts();

    public abstract void buy();

    public abstract void cancel();

}