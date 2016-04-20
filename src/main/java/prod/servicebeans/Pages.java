/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prod.servicebeans;

import java.io.IOException;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import org.primefaces.context.RequestContext;

/**
 *
 * @author Altarix
 */
@ManagedBean
@SessionScoped
public class Pages implements Serializable {

    String page;
    int vacid;

    @PostConstruct
    public void init() {
        page = "content/table_view.xhtml"; //  Default include.
        vacid = 0;
    }

    public String getPage() {
        return page;
    }

    public void setPage(String page) {
        this.page = page;
    }

    public int getVacid() {
        return vacid;
    }

    public void setVacid(int vacid) {
        
        this.vacid = vacid;
    }

    public void showVac( int id) throws IOException {
        this.vacid = id;
        this.page = "/content/vac.xhtml";
        FacesContext.getCurrentInstance().getExternalContext()
            .redirect("vacancy.xhtml");
    }

}
