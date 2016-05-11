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
import javax.faces.convert.FacesConverter;
import prod.dao.ClassifDaoImpl;
import prod.dao.ProductDaoImpl;
import prod.model.City;
import prod.model.VolumeClassif;

/**
 *
 * @author Altarix
 */
@ManagedBean
@RequestScoped
@FacesConverter
public class CityConverter implements Converter{

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
          ClassifDaoImpl proddao = new ClassifDaoImpl();
      for(City c : proddao.getPlacesList()){
			if(c.getCityId().toString().equals(value)){
				return c;
			}
		}
		return null;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
         if (value instanceof City) {

            City vol = (City) value;

            return vol.getName();

        }

        return "";
    }
    
    
    
}
