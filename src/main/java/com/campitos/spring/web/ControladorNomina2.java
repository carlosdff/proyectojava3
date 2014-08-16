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
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/")
public class ControladorNomina2 {
    
    @RequestMapping(value = "/nomina",method=RequestMethod.GET,headers={"Accept=Application/json"})
    
    public @ResponseBody String metodoBuscarNominas()throws Exception{
        
        ObjectMapper maper=new ObjectMapper();
        DAONomina2Impl nom=new DAONomina2Impl();
        return maper.writeValueAsString(nom.buscarNominas());
    }
    
    @RequestMapping(value = "/nomina/{id_usuario}/{saldo}",method = RequestMethod.GET,headers = {"Accept=text/html"})
    
    public @ResponseBody String metodoInsertarNomina (@PathVariable int id_usuario,@PathVariable float saldo){
     String mensaje;
        try{
        
    DAONomina2Impl d=new DAONomina2Impl();
    d.agregarNomina(new Nomina2(saldo, new Usuario(id_usuario)));
    mensaje="nomina agregada con exito"; 
    }
    catch(Exception e){
    mensaje="lo siento no existe el id usuario";
    }
    return mensaje;
    }
}
