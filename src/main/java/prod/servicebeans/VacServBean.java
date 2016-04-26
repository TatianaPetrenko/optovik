/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prod.servicebeans;

import java.io.Serializable;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import prod.model.Wholesaler;
import prod.dao.VacancyDaoImpl;
import prod.model.Vacancy;

/**
 *
 * @author Altarix
 */
@ManagedBean
@SessionScoped
public class VacServBean implements Serializable {

    private Vacancy vac = new Vacancy();

    private Wholesaler whId;

    public void saveListener() {
        
        vac.setText(vac.getText().replaceAll("\\r|\\n", "")); 

        final FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Content",
                vac.getText().length() > 150 ? vac.getText().substring(0, 100) : vac.getText());

        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
// сохранить вакансию
    public void saveVac() {
        VacancyDaoImpl vacdao = new VacancyDaoImpl();
        vacdao.newVac(this);

    }
    
    public List<Vacancy> getVacs(){
    
    VacancyDaoImpl vacdao = new VacancyDaoImpl();
       return vacdao.getWhVac();
    }

    public Vacancy getVacById(int id) {
    VacancyDaoImpl vacdao = new VacancyDaoImpl();
    Vacancy vacancy = vacdao.getVacByID(id);
    return vacancy;
    }

    public Vacancy getVac() {
        return vac;
    }

    public void setVac(Vacancy vac) {
        this.vac = vac;
    }
    
  
    public Wholesaler getWhId() {
        return whId;
    }

    public void setWhId(Wholesaler whId) {
        this.whId = whId;
    }

}
