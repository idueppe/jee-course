package rent.a.vehicle.dao.jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import rent.a.vehicle.model.Message;

public class SimpleMessageTest {
    
    private EntityManagerFactory emf;

    @Test
    public void testMessage() {
        Message msg = new Message();
        msg.setText("Hello JPA");
        msg.setAuthor("Ingo Düppe");
        
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();
        em.persist(msg);
        em.getTransaction().commit();
        
        em.close();
        emf.close();
        
    }
    
    @Test
    public void testFindMessage() {
        EntityManager em = emf.createEntityManager();
        
        Message msg = em.find(Message.class, 1L);
        System.out.println(msg.getText());
        
        em.close();
    }

    @Before
    public void setup() {
        emf = Persistence.createEntityManagerFactory("vehicle-persistence-unit-test");
    }
    
    @After
    public void tearDown() {
        emf.close();
    }

}
