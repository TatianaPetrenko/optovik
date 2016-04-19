/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prod.model;

import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import prod.dao.WholesalerDaoImpl;

/**
 *
 * @author Tatiana
 */
@ManagedBean
@SessionScoped
public class UserModel implements Serializable{

    private String login;
    private String pwd;
    private String pwdConfirm;
  private String name;
  private String email;
     private String site;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSite() {
        return site;
    }

    public void setSite(String site) {
        this.site = site;
    }


    public void reset() {
        this.login = null;
        this.pwd = null;
        this.pwdConfirm = null;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getPwdConfirm() {
        return pwdConfirm;
    }

    public void setPwdConfirm(String pwdConfirm) {
        this.pwdConfirm = pwdConfirm;
    }
    
    
    public void regWholesaler() {

          WholesalerDaoImpl whdao = new WholesalerDaoImpl();
         whdao.newWH(this);

}
}