package rent.a.vehicle.web.views;

import java.io.Serializable;
import java.util.List;
import java.util.logging.Logger;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.context.FacesContext;

import rent.a.vehicle.controller.ManufacturerAlreadyExistsException;
import rent.a.vehicle.controller.ManufacturerController;
import rent.a.vehicle.dto.ManufacturerDto;

/**
 * @author idueppe
 * @since 1.0
 */
@ManagedBean
@SessionScoped
public class ManufacturerView implements Serializable {

    private static final long serialVersionUID = 1L;

    private static final Logger LOG = Logger.getLogger(ManufacturerView.class.getName());

    @EJB
    private ManufacturerController manufacturerController;
    
    private ManufacturerDto selectedManufacturer;
    private String uniqueManufacturerName;

    public List<ManufacturerDto> getAllManufacturers() {
        return manufacturerController.findAll();
    }

    public ManufacturerDto getManufacturer() {
        if (selectedManufacturer == null) {
            selectedManufacturer = new ManufacturerDto();
        }
        return selectedManufacturer;
    }

    public String getUniqueManufacturerName() {
        return uniqueManufacturerName;
    }

    public void validateManufacturerName(FacesContext context, UIComponent component, Object value) {
        if (value != null && doManufacturerNameExistis((String)value)) {
            ((UIInput) component).setValid(false);
            FacesMessage msg = new FacesMessage("Name existiert bereits.");
            msg.setSeverity(FacesMessage.SEVERITY_ERROR);
            context.addMessage(component.getClientId(), msg);
        } else {
            ((UIInput) component).setValid(true);
        }
    }

    private boolean doManufacturerNameExistis(String manufacturerName) {
        ManufacturerDto found = manufacturerController.byName(manufacturerName);
        // TODO mach lesbar mach richtig!
        if (found != null && found.getId() != null) {
            return !found.getId().equals(selectedManufacturer.getId());
        } else {
            return false;
        }
    }

    public String selectForUpdateManufacturer(ManufacturerDto manufacturer) {
        LOG.info("------- "+manufacturer.getName()+" ----------- SELECTED");
        this.selectedManufacturer = manufacturerController.byName(manufacturer.getName());
        return "/views/addmanufacturer";
    }
    
    public String updateManufacturer() {
        manufacturerController.update(selectedManufacturer);
        return "/views/manufacturers";
    }

    public String addManufacturer() {
        try {
            manufacturerController.newManufacturer(selectedManufacturer.getName());
            FacesMessage msg = new FacesMessage();
            msg.setSeverity(FacesMessage.SEVERITY_INFO);
            msg.setSummary("Neuer Herrsteller " + selectedManufacturer.getName() + " hinzugefügt.");
            FacesContext.getCurrentInstance().addMessage(null, msg);
            return "/views/manufacturers";
        } catch (ManufacturerAlreadyExistsException e) {
            FacesMessage msg = new FacesMessage();
            msg.setSeverity(FacesMessage.SEVERITY_INFO);
            msg.setSummary("Herrsteller " + selectedManufacturer.getName() + " existiert bereits.");
            FacesContext.getCurrentInstance().addMessage(null, msg);
            return "";
        }

    }

    public String cancelAdding() {
        return "/views/manufacturers";
    }
    
    public String startAddingNewManufacturer() {
        selectedManufacturer = new ManufacturerDto();
        return "/views/addmanufacturer";
    }

    
    public boolean isEditing() {
        return (selectedManufacturer.getId() != null);
    }    
}
