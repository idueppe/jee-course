package rent.a.vehicle.controller;

import java.util.List;

import rent.a.vehicle.dto.ManufacturerDto;

public interface ManufacturerController {
    
    public List<ManufacturerDto> findAll();
    
    public void newManufacturer(String name);
    
    public ManufacturerDto byName(String name);
    

}