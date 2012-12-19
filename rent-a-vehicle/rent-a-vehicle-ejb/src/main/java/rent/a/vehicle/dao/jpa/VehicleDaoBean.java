package rent.a.vehicle.dao.jpa;

import java.util.List;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import rent.a.vehicle.dao.VehicleDao;
import rent.a.vehicle.model.Vehicle;

@Stateless
@Local(VehicleDao.class)
public class VehicleDaoBean implements VehicleDao {
    
    @PersistenceContext(name="rent-a-vehicle")
    private EntityManager em;
    
    @Override
    public List<Vehicle> findAll() {
        TypedQuery<Vehicle> query = em.createNamedQuery(Vehicle.FIND_ALL, Vehicle.class);
        return query.getResultList();
    }

    @Override
    public void create(Vehicle vehicle) {
        em.persist(vehicle);
    }

    @Override
    public Vehicle read(Long id) {
        return em.find(Vehicle.class, id);
    }

    @Override
    public Vehicle update(Vehicle entity) {
        return em.merge(entity);
    }

    @Override
    public void delete(Vehicle entity) {
        em.remove(entity);
    }

    @Override
    public List<? extends Vehicle> findByManufacturer(String name) {
        String qlStmt = "SELECT v FROM Vehicle v WHERE v.manufacturer.name = :name";
        TypedQuery<Vehicle> query = em.createQuery(qlStmt, Vehicle.class);
        query.setParameter("name", name);
        return query.getResultList();
    }

}
