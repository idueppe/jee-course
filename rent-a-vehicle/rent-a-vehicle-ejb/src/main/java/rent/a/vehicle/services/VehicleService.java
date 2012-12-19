package rent.a.vehicle.services;

import java.util.List;

import rent.a.vehicle.controller.ManufacturerNotFoundException;
import rent.a.vehicle.model.Vehicle;

public interface VehicleService {

    public List<? extends Vehicle> findByManufacturerName(String name);

    public Vehicle addVehicle(Vehicle vehicle, String manufacturerName) throws ManufacturerNotFoundException ;

}
