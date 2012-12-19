package rent.a.vehicle.controller;

public class ManufacturerNotFoundException extends Exception {

    private static final long serialVersionUID = 1L;
    
    public ManufacturerNotFoundException(String manufacturerName) {
        super("Manufacturer "+manufacturerName+" not found!");
    }

}
