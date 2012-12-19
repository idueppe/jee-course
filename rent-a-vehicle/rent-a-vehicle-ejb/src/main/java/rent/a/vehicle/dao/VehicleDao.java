package rent.a.vehicle.dao;

import java.util.List;

import rent.a.vehicle.model.Vehicle;

public interface VehicleDao extends EntityDao<Vehicle> {

    List<? extends Vehicle> findByManufacturer(String name);

}
