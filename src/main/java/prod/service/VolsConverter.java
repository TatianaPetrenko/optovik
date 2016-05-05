/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prod.service;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.*;
import prod.dao.ProductDaoImpl;
import prod.model.VolumeClassif;

/**
 *
 * @author Altarix
 */
@ManagedBean
@RequestScoped
@FacesConverter
public class VolsConverter implements Converter {

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
         ProductDaoImpl proddao = new ProductDaoImpl();
      for(VolumeClassif p : proddao.getVols()){
			if(p.getId().toString().equals(value)){
				return p;
			}
		}
		return null;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if (value instanceof VolumeClassif) {

            VolumeClassif vol = (VolumeClassif) value;

            return vol.getName();

        }

        return "";
    }

}
