package rent.a.vehicle.services;

import java.util.List;

import rent.a.vehicle.model.Manufacturer;

public interface ManufacturerService {
    
    public List<Manufacturer> findAll();
    
    public void newManufacturer(String name);
    
    public Manufacturer byName(String name);
    
}
