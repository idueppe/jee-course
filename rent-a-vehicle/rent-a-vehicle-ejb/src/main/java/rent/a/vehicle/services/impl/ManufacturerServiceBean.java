package rent.a.vehicle.services.impl;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Local;
import javax.ejb.Stateless;

import rent.a.vehicle.controller.ManufacturerAlreadyExistsException;
import rent.a.vehicle.dao.ManufacturerDao;
import rent.a.vehicle.model.Manufacturer;
import rent.a.vehicle.services.ManufacturerService;

@Stateless
@Local(ManufacturerService.class)
public class ManufacturerServiceBean implements ManufacturerService {

    @EJB
    private ManufacturerDao manufacturerDao;

    @Override
    public List<Manufacturer> findAll() {
        return manufacturerDao.findAll();
    }

    @Override
    public void newManufacturer(String name) throws ManufacturerAlreadyExistsException {
        if (doesManufacturerExist(name)) {
            throw new ManufacturerAlreadyExistsException(name);
        }
        Manufacturer manufacturer = new Manufacturer();
        manufacturer.setName(name);
        manufacturerDao.create(manufacturer);
    }

    @Override
    public boolean doesManufacturerExist(String name) {
        return manufacturerDao.findByName(name) != null;
    }

    @Override
    public Manufacturer byName(String name) {
        return manufacturerDao.findByName(name);
    }

}
