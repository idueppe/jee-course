package rent.a.vehicle.dao.jpa;

import static org.junit.Assert.assertNotNull;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Spy;
import org.mockito.runners.MockitoJUnitRunner;

import rent.a.vehicle.model.Vehicle;

@RunWith(MockitoJUnitRunner.class)
public class VehicleDaoBeanIT {

    private static EntityManagerFactory emf;
    
    @Spy
    private EntityManager em = emf.createEntityManager();
    
    @InjectMocks
    private VehicleDaoBean dao;
    
    @BeforeClass
    public static void setUpClass() {
        emf = Persistence.createEntityManagerFactory("vehicle-persistence-unit-mysql-test");
    }
    
    @Test
    public void testPersist() {
        txBegin();
        Vehicle vehicle = new Vehicle();
        dao.create(vehicle);
        assertNotNull(vehicle.getId());
        txCommit();
    }
    
    @Test
    public void testFindAll() {
        List<Vehicle> all = dao.findAll();
        assertNotNull(all);
    }
    
    
    private void txBegin() {
        if (!em.getTransaction().isActive()) {
            em.getTransaction().begin();
        }
    }
    
    private void txCommit() {
        if (em.getTransaction().isActive()) {
            em.getTransaction().commit();
        }
    }
    

}
