package rent.a.vehicle.dao.jpa;

import static org.junit.Assert.assertNotNull;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import rent.a.vehicle.model.Attachment;
import rent.a.vehicle.model.Message;

public class SimpleMessageTest {
    
    private EntityManagerFactory emf;
    
    @Before
    public void setup() {
        emf = Persistence.createEntityManagerFactory("vehicle-persistence-unit-mysql-test");
    }
    
    @Test
    public void testMessage() {
        Message msg = new Message();
        
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();
        msg.setText("Hello JPA");
        em.persist(msg);
        msg.setAuthor("Ingo Düppe");
        
        em.getTransaction().commit();
        msg.setMessageNumber(1234L);
        
        
        em.getTransaction().begin();
        em.getTransaction().commit();
        
        em.getTransaction().begin();
        em.getTransaction().commit();
        
        em.close();
        
    }

    @Test
    public void testQuery() {
        testMessage();
        
        EntityManager em = emf.createEntityManager();
        
        String qlStmt = "SELECT m.attachment FROM Message m WHERE m.id = :id";
        TypedQuery<Attachment> query = em.createQuery(qlStmt, Attachment.class);
        query.setParameter("id", 1L);
        
        List<Attachment> resultList = query.getResultList();
        System.out.println(resultList);
        em.close();
    }

    @Test
    public void testNativeQuery() {
        testMessage();
        
        EntityManager em = emf.createEntityManager();
        
        Query query = em.createNativeQuery("SELECT * FROM message"); // SQL STATEMENT
        
        List resultList = query.getResultList();
        System.out.println(resultList);
        em.close();
    }

    
    @Ignore
    public void testFindMessage() {
        EntityManager em = emf.createEntityManager();
        
        Message msg = em.find(Message.class, 1L);
        System.out.println(msg.getText());

        em.getTransaction().begin();
        em.getTransaction().commit();

        
        em.close();
    }
    
    @Ignore
    public void testDetachMessage() {
        EntityManager em = emf.createEntityManager();
        Message msg = em.find(Message.class, 1L);
        msg.setAttachment(new Attachment());
        msg.getAttachment().setData(new byte[]{1,2,3,4,5,6});
        
        em.getTransaction().begin();
            em.persist(msg.getAttachment());
        em.getTransaction().commit();        

        em.close();
        //-----------------------------------
        em = emf.createEntityManager();
        msg = em.find(Message.class, 1L);
        Attachment attachment = msg.getAttachment();
        byte[] data = attachment.getData();
        em.close();
        assertNotNull(attachment);

        //-----------------------------------
        em = emf.createEntityManager();
        msg.setText("Geändert");
        em.getTransaction().begin();
        Message merged = em.merge(msg);
        em.getTransaction().commit();
        
        
    }
    
    @After
    public void tearDown() {
        emf.close();
    }

}
