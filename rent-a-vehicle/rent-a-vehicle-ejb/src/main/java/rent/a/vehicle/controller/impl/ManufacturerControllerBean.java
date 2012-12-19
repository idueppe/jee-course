package rent.a.vehicle.controller.impl;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Remote;
import javax.ejb.Stateless;

import rent.a.vehicle.controller.ManufacturerController;
import rent.a.vehicle.converter.ManufacturerConverter;
import rent.a.vehicle.dto.ManufacturerDto;
import rent.a.vehicle.services.ManufacturerService;

@Stateless
@Remote(ManufacturerController.class)
public class ManufacturerControllerBean implements ManufacturerController{

    @EJB
    private ManufacturerService manufacturerService;
    
    @EJB
    private ManufacturerConverter manufacturerConverter;
    
    @Override
    public List<ManufacturerDto> findAll() {
        return manufacturerConverter.convert(manufacturerService.findAll());
    }

    @Override
    public void newManufacturer(String name) {
        manufacturerService.newManufacturer(name);
    }

    @Override
    public ManufacturerDto byName(String name) {
        return manufacturerConverter.convert(manufacturerService.byName(name));
    }

}
