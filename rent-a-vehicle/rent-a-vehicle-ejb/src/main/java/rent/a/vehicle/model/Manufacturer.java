package rent.a.vehicle.model;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Manufacturer extends AbstractEntity {

    private static final long serialVersionUID = 1L;

    @Column(unique=true)
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
