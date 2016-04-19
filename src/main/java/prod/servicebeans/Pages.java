/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prod.servicebeans;

import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author Altarix
 */
@ManagedBean
@ViewScoped
public class Pages implements Serializable {
    String page;
     @PostConstruct
     public void init() {
         page = "content/table_view.xhtml"; //  Default include.
     }

    public String getPage() {
        return page;
    }

    public void setPage(String page) {
        this.page = page;
    }
     
}
