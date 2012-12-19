package rent.a.vehicle.dao.jpa;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.logging.Logger;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import rent.a.vehicle.model.Engine;
import rent.a.vehicle.model.EngineType;
import rent.a.vehicle.model.Manufacturer;
import rent.a.vehicle.model.Vehicle;

@Singleton
@Startup
public class DBFixture {
	
	private static final Logger LOG = Logger.getLogger(DBFixture.class.getName());

    @PersistenceContext(name="vehicle-foundation")
    private EntityManager em;
    
    private List<Manufacturer> manufacturers = new ArrayList<Manufacturer>();
    private List<Vehicle> vehicles = new ArrayList<Vehicle>();
    private List<Engine> engines = new ArrayList<Engine>();

    private Manufacturer currentManufacturer;

    private Vehicle currentVehicle;

    private Engine currentEngine;

    @PostConstruct
    public void createDefaultDataInDatabase() {
    	LOG.info("Creating dummy data...");
        this.createManufacturer("Bugatti")
            .addVehicle()
            .setModelName("Veyron")
            .setPrice(1200000.00)
            .addEngine(EngineType.PETROL)
            .setConstructionDate(toDate(2011,8,1))
            .setInspectionDate(toDate(2013,8,1))
            .addVehicle()
            .setModelName("Veyron Diesel")
            .setPrice(999000.00)
            .setConstructionDate(toDate(2012,1,1))
            .setInspectionDate(toDate(2014,1,1))
            .addEngine(EngineType.DIESEL)
            .createManufacturer("VW")
            .addVehicle()
            .setModelName("Trabbi")
            .setConstructionDate(toDate(1989,12,1))
            .setInspectionDate(toDate(2013,12,1))
            .addEngine(EngineType.PETROL)
            .createManufacturer("AUDI")
            .addVehicle()
            .setModelName("A4")
            .addEngine(EngineType.DIESEL)
            .setConstructionDate(toDate(2009,10,7))
            .setInspectionDate(toDate(2013,10,7))
            .persistAll();
    }

    private DBFixture setConstructionDate(Date date) {
        currentVehicle.setConstructionDate(date);
        return this;
    }

    public DBFixture persistAll() {
        persistAll(manufacturers);
        persistAll(engines);
        persistAll(vehicles);
        return this;
    }
    
    private DBFixture clear() {
        manufacturers.clear();
        vehicles.clear();
        engines.clear();
        currentEngine = null;
        currentVehicle = null;
        currentManufacturer = null;
        return null;
    }
    
    public DBFixture removeAll() {
        em.createQuery("DELETE FROM Vehicle").executeUpdate();
        em.createQuery("DELETE FROM Engine").executeUpdate();
        em.createQuery("DELETE FROM Manufacturer").executeUpdate();
        em.createQuery("DELETE FROM ApplicationLog").executeUpdate();
        clear();
        return this;
    }
    
    private void persistAll(List<?> entities) {
        for (Object entity : entities) {
            System.out.println("--- persisting : "+entity);
            em.persist(entity);
        }
    }
    
    public Manufacturer build() {
        return currentManufacturer;
    }

    public DBFixture addEngine(EngineType engineType) {
        currentEngine = new Engine();
        engines.add(currentEngine);
        currentEngine.setEngineType(engineType);
        currentVehicle.setEngine(currentEngine);
        return this;
    }
    
    public DBFixture setEngineName(String name) {
        currentEngine.setName(name);
        return this;
    }
    public DBFixture setModelName(String modelName) {
        currentVehicle.setModelName(modelName);
        return this;
    }
    
    public DBFixture setPrice(Double nettoPrice) {
        currentVehicle.setPrice(nettoPrice);
        return this;
    }

    private DBFixture addVehicle() {
        currentVehicle = new Vehicle();
        vehicles.add(currentVehicle);
        currentManufacturer.addVehicle(currentVehicle);
        return this;
    }

    public DBFixture createManufacturer(String name) {
        currentManufacturer = buildManufacturer(name);
        return this;
    }

    public Manufacturer buildManufacturer(String manufacturerName) {
        Manufacturer manufacturer = new Manufacturer();
        manufacturer.setName(manufacturerName);
        manufacturers.add(manufacturer);
        return manufacturer;
    }

    public Vehicle buildVehicle(String model) {
        Vehicle vehicle = new Vehicle();
        vehicle.setModelName(model);
        return vehicle;
    }
    
    public void terminateAllActiveSessionInDB() {
        Query nativeQuery = em.createNativeQuery("SELECT pg_terminate_backend(procpid) FROM pg_stat_activity WHERE datname = 'vehicle-tmp'");
        nativeQuery.executeUpdate();
    }
    
    public List<Vehicle> getVehicles() {
        return Collections.unmodifiableList(vehicles);
    }
    
    public DBFixture setInspectionDate(Date date) {
        currentVehicle.setInspectionDate(date);
        return this;
    }
    
    private Date toDate(int year, int month, int day) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(year, month, day);
        return calendar.getTime();
    }

}
