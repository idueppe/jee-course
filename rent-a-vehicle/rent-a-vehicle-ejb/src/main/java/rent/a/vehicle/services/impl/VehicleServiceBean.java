package rent.a.vehicle.services.impl;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Local;
import javax.ejb.Stateless;

import rent.a.vehicle.controller.ManufacturerNotFoundException;
import rent.a.vehicle.dao.VehicleDao;
import rent.a.vehicle.model.Manufacturer;
import rent.a.vehicle.model.Vehicle;
import rent.a.vehicle.services.ManufacturerService;
import rent.a.vehicle.services.VehicleService;

@Stateless
@Local(VehicleService.class)
public class VehicleServiceBean implements VehicleService {
    
    @EJB
    private VehicleDao vehicleDao;
    
    @EJB
    private ManufacturerService manufacturerService;

    @Override
    public List<? extends Vehicle> findByManufacturerName(String name) {
        return vehicleDao.findByManufacturer(name);
    }

    @Override
    public Vehicle addVehicle(Vehicle vehicle, String manufacturerName) throws ManufacturerNotFoundException {
        Manufacturer manufacturer = manufacturerService.byName(manufacturerName);
        if (manufacturer == null) {
            throw new ManufacturerNotFoundException(manufacturerName);
        }
        vehicle.setManufacturer(manufacturer);
        manufacturer.getVehicles().add(vehicle);
        vehicleDao.create(vehicle);
        return vehicle;
    }

}
