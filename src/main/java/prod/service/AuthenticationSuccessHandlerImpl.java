/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prod.service;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.simple.parser.ParseException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import prod.dao.WholesalerDaoImpl;
import prod.model.Wholesaler;
import prod.servicebeans.WhServBean;

/**
 *
 * @author Altarix
 */
public class AuthenticationSuccessHandlerImpl implements AuthenticationSuccessHandler {

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException, FileNotFoundException {
        //   System.out.println("Success");
        //  response.getOutputStream().write("success".getBytes());
        Set<String> roles = AuthorityUtils.authorityListToSet(authentication.getAuthorities());
        if (roles.contains("ROLE_WHOLESALER")) {

            WholesalerDaoImpl whdao = new WholesalerDaoImpl();
            Wholesaler n = whdao.getCurrentWh();

            FacesContext facesContext = FacesUtil.getFacesContext(request, response);

            ExternalContext ec = facesContext.getCurrentInstance().getExternalContext();
            ec.getSessionMap().put("wholesaler", n);

            response.sendRedirect("main/wholesaler/wholesaler.xhtml");
        }
    }

}
