package rent.a.vehicle.ws.impl;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.jws.WebService;

import rent.a.vehicle.controller.ManufacturerController;
import rent.a.vehicle.dto.ManufacturerDto;
import rent.a.vehicle.ws.ManufacturerWebService;

@Stateless
@WebService
public class ManufacturerWebServiceBean implements ManufacturerWebService{

    @EJB
    private ManufacturerController controller;
    
    @Override
    public List<ManufacturerDto> findAll() {
        return controller.findAll();
    }

    @Override
    public ManufacturerDto byName(String name) {
        return controller.byName(name);
    }

    @Override
    public boolean doManufacturerExists(String manufacturerName) {
        return controller.doManufacturerExists(manufacturerName);
    }

}
