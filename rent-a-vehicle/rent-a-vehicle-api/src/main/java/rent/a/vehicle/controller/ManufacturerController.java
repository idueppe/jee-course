package rent.a.vehicle.controller;

import java.util.List;

import rent.a.vehicle.dto.ManufacturerDto;

public interface ManufacturerController {
    
    public List<ManufacturerDto> findAll();
    
    public void newManufacturer(String name) throws ManufacturerAlreadyExistsException;
    
    public ManufacturerDto byName(String name);

    public boolean doManufacturerExists(String manufacturerName);

}
