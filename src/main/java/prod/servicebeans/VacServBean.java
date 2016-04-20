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

    private Integer id;

    private String name;

    private String text;

    private String salary;

    private Wholesaler whId;

    public void saveListener() {
        text = text.replaceAll("\\r|\\n", "");

        final FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Content",
                text.length() > 150 ? text.substring(0, 100) : text);

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
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    public Wholesaler getWhId() {
        return whId;
    }

    public void setWhId(Wholesaler whId) {
        this.whId = whId;
    }

}
