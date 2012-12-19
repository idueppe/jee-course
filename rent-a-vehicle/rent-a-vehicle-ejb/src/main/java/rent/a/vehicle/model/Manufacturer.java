package rent.a.vehicle.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity
public class Manufacturer extends AbstractEntity {

    private static final long serialVersionUID = 1L;

    @Column(unique=true)
    private String name;
    
    @OneToMany(cascade=CascadeType.ALL, mappedBy="manufacturer")
    private List<Vehicle> vehicles;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Vehicle> getVehicles() {
        if (vehicles == null) {
            vehicles = new ArrayList<>();
        }
        return vehicles;
    }

    public void setVehicles(List<Vehicle> vehicles) {
        this.vehicles = vehicles;
    }

}
