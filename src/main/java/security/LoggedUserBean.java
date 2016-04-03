/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package security;

import dao.SecurityDAO;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

/**
 *
 * @author Tatyana
 */
public class LoggedUserBean {

    private Integer id;

    private String username;

    private String password;

    private boolean loggedIn;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isLoggedIn() {
        return loggedIn;
    }

    public void setLoggedIn(boolean loggedIn) {
        this.loggedIn = loggedIn;
    }
    
    
    
        /**
     * Login operation.
     * @return
     */
    public String doLogin() {
        // Get every user from our sample database :)
          SecurityDAO sdao = new SecurityDAO();
          
            // Successful login
            if (sdao.thyPass(username).getPassword().equals(password)) {
                
                loggedIn = true;
                return "secure/welcome";
                
            }
        
         
        // Set login ERROR
        FacesMessage msg = new FacesMessage("Login error!", "ERROR MSG");
        msg.setSeverity(FacesMessage.SEVERITY_ERROR);
        FacesContext.getCurrentInstance().addMessage(null, msg);
         
        // To to login page
        return "login";
         
    }


}
