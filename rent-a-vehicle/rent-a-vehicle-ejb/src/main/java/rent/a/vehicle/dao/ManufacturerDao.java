package rent.a.vehicle.dao;

import rent.a.vehicle.model.Manufacturer;

public interface ManufacturerDao extends EntityDao<Manufacturer>{

    public Manufacturer findByName(String name);

}
