package rent.a.vehicle.dto;

import java.io.Serializable;
import java.util.Date;

public class VehicleDto implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;
    private String manufacturerName;

    private String modelName;
    private Date constructionDate;
    private Date inspectionDate;
    
    private String eningeType;

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

    public String getManufacturerName() {
        return manufacturerName;
    }

    public void setManufacturerName(String manufacturerName) {
        this.manufacturerName = manufacturerName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEningeType() {
        return eningeType;
    }

    public void setEningeType(String eningeType) {
        this.eningeType = eningeType;
    }

}
