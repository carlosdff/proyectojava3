/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.campitos.spring.web;

/**
 *
 * @author Ramsses R6
 */
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Query;

public class DAONomina2Impl extends DAO {
    
    public void agregarNomina(Nomina2 nomina){
        begin();
        getSession().save(nomina);
        commit();
        close();
    }
    
    public void actualizarProducto(Nomina2 nomina) {
        begin();
        getSession().update(nomina);
        commit();
        close();
    }
    
     public ArrayList<Nomina2> buscarProducto() {
        begin();
        Criteria c = getSession().createCriteria(Nomina2.class);
        ArrayList<Nomina2> pr = (ArrayList<Nomina2>) c.list();
        commit();
        close();

        return pr;

     }
      public void borrarProducto(Nomina2 p) {
        begin();
        getSession().delete(p);
        commit();
        close();
      }
    
    public ArrayList<Nomina2> buscarNominas(){
        begin();
        Criteria c=getSession().createCriteria(Nomina2.class);
        ArrayList<Nomina2> nomina=(ArrayList<Nomina2>)c.list();
        commit();
        close();
        
        return nomina;
    }
    
    
    
}
