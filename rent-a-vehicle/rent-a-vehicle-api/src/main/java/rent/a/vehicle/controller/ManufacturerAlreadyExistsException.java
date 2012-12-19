package rent.a.vehicle.controller;

public class ManufacturerAlreadyExistsException extends Exception {

    private static final long serialVersionUID = 1L;

    public ManufacturerAlreadyExistsException(String name) {
        super("Manufacturer "+name+" already exists!");
    }

}
