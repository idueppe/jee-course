package rent.a.vehicle.model;

import javax.persistence.Entity;

@Entity
public class Engine extends AbstractEntity {

    private static final long serialVersionUID = 1L;

    private String name;
    private EngineType engineType;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public EngineType getEngineType() {
        return engineType;
    }

    public void setEngineType(EngineType engineType) {
        this.engineType = engineType;
    }

}
