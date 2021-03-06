package rent.a.vehicle.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;

@Entity
@NamedQueries(
    value = { 
       @NamedQuery(name = Vehicle.FIND_ALL, query = "SELECT v FROM Vehicle v") 
    }
)
//@Table(name="tbl_vehicle")
public class Vehicle extends AbstractEntity {

    private static final long serialVersionUID = 1L;

    public static final String FIND_ALL = "Vehicle.findAll";
    
//    @Column(name="model_name",length=100, nullable=false)
    private String modelName;
    
    @Temporal(TemporalType.DATE)
    private Date constructionDate;
    
    @Temporal(TemporalType.DATE)
    private Date inspectionDate;
    
    private Double price;
    
    @ManyToOne(cascade={CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    private Manufacturer manufacturer;
    
    @OneToOne(cascade=CascadeType.ALL)
    private Engine engine;
    
    @Version
    private long version;

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public Date getConstructionDate() {
        return constructionDate;
    }

    public void setConstructionDate(Date constructionDate) {
        this.constructionDate = constructionDate;
    }

    public Date getInspectionDate() {
        return inspectionDate;
    }

    public void setInspectionDate(Date inspectionDate) {
        this.inspectionDate = inspectionDate;
    }

    public Manufacturer getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(Manufacturer manufacturer) {
        this.manufacturer = manufacturer;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Engine getEngine() {
        return engine;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }


}
