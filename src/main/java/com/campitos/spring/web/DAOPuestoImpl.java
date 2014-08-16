/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.campitos.spring.web;

import static com.campitos.spring.web.DAO.close;
import static com.campitos.spring.web.DAO.getSession;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Criteria;

import org.hibernate.Query;

/**
 *
 * @author CDFF
 */
public class DAOPuestoImpl extends DAO {
   
    
    public void agregarPuesto(Puesto puesto){
        begin();
        getSession().save(puesto);
        commit();
        close();
    }
    public void actualizarProducto(Puesto puesto) {
        begin();
        getSession().update(puesto);
        commit();
        close();
    }
     public ArrayList<Puesto> buscarProducto() {
        begin();
        Criteria c = getSession().createCriteria(Puesto.class);
        ArrayList<Puesto> prod = (ArrayList<Puesto>) c.list();
        commit();
        close();

        return prod;
     }
     public void borrarProducto(Puesto puesto) {
        begin();
        getSession().delete(puesto);
        commit();
        close();
    }
    
    public List<Puesto> buscarPuestos(){
        begin();
        Criteria c=getSession().createCriteria(Puesto.class);
        List<Puesto> puesto=(List<Puesto>)c.list();
        commit();
        close();
        
        return puesto;
    }
    
}
