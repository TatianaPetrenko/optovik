/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prod.servicebeans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import prod.dao.ClassifDaoImpl;
import prod.model.City;
import prod.model.Region;


/**
 *
 * @author Altarix
 */
@ManagedBean
@SessionScoped
public class ClassifServBean implements Serializable {

    private City ct;

    public City getCt() {
        return ct;
    }

    public void setCt(City ct) {
        this.ct = ct;
    }
    
    
    
    public List<City> getCities() {
        ClassifDaoImpl classdao = new ClassifDaoImpl();
        List<City> cities = classdao.getPlacesList();
        return cities;
    }

    
    public List<City> completeCity(String query) {
        List<City> allThemes = getCities();
        List<City> filteredThemes = new ArrayList<City>();
         
        for (int i = 0; i < allThemes.size(); i++) {
            City skin = allThemes.get(i);
            if(skin.getName().toLowerCase().startsWith(query)) {
                filteredThemes.add(skin);
            }
        }
         
        return filteredThemes;
    }
    
    
    public List<Region> getRegions() {
        ClassifDaoImpl classdao = new ClassifDaoImpl();
        List<Region> regions = classdao.getRegionList();
        return regions;
    }

    
    public List<Region> completeRegion(String query) {
        List<Region> allThemes = getRegions();
        List<Region> filteredReg = new ArrayList<Region>();
         
        for (int i = 0; i < allThemes.size(); i++) {
            Region reg = allThemes.get(i);
            if(reg.getName().toLowerCase().startsWith(query)) {
                filteredReg.add(reg);
            }
        }
         
        return filteredReg;
    }
    
}
