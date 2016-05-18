/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prod.service;

import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Altarix
 */
public class OptServlet extends HttpServlet{
     public void doGet(HttpServletRequest request, HttpServletResponse response) {
        doSomething(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) {
        doSomething(request, response);
    }

    private void doSomething(HttpServletRequest request, HttpServletResponse response) {

        // Get the FacesContext inside HttpServlet.
        FacesContext facesContext = FacesUtil.getFacesContext(request, response);

        // Now you can do your thing with the facesContext.
    }
}
