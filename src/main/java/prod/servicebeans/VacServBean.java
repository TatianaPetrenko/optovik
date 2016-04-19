/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prod.servicebeans;

import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import prod.model.Wholesaler;

/**
 *
 * @author Altarix
 */
@ManagedBean
@SessionScoped
public class VacServBean implements Serializable{
     private Integer id;

    private String name;

    private String text;

    private String salary;

    private Wholesaler whId;

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
