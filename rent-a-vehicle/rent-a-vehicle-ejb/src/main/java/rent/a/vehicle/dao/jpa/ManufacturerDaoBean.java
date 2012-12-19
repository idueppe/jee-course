package rent.a.vehicle.dao.jpa;

import java.util.List;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import rent.a.vehicle.dao.ManufacturerDao;
import rent.a.vehicle.model.Manufacturer;

@Stateless
@Local(ManufacturerDao.class)
public class ManufacturerDaoBean implements ManufacturerDao{

    @PersistenceContext(name="rent-a-vehicle")
    private EntityManager em;
    
    @Override
    public List<Manufacturer> findAll() {
        String qString = "SELECT m FROM Manufacturer m";
        TypedQuery<Manufacturer> query = em.createQuery(qString, Manufacturer.class);
        return query.getResultList();
    }

    @Override
    public void create(Manufacturer entity) {
        em.persist(entity);
    }

    @Override
    public Manufacturer read(Long id) {
        return em.find(Manufacturer.class, id);
    }

    @Override
    public Manufacturer update(Manufacturer entity) {
        return em.merge(entity);
    }

    @Override
    public void delete(Manufacturer entity) {
        em.remove(entity);
    }

    @Override
    public Manufacturer findByName(String name) {
        try {
            String qlStmt = "SELECT m FROM Manufacturer m WHERE m.name = :name";
            TypedQuery<Manufacturer> query = em.createQuery(qlStmt, Manufacturer.class);
            query.setParameter("name", name);
            return query.getSingleResult();
        } catch (NoResultException ex) {
            return null;
        }
    }
}
