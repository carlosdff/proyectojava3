

package com.campitos.spring.web;

import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
@RequestMapping("/")
public class ControladorUsuario2 {
    
    //definimos la de buscarTodos
    @RequestMapping(value="/usuario",method=RequestMethod.GET,headers={"Accept=Application/json"})
    
    public @ResponseBody String metodo1() throws Exception{
    
        ObjectMapper maper=new ObjectMapper();
        DAOUsuarioImpl d=new DAOUsuarioImpl();
        return maper.writeValueAsString(d.buscarTodosClientes());
    }
    
    // sigue la de insertar usuario,
    // lo haremos siguiendo la convencion de REST para servicios
        
    @RequestMapping(value = "/usuario/{nombre}/{sueldo}",method=RequestMethod.GET,
            headers = {"Accept=text/html"})
    
    public @ResponseBody String metodo2(@PathVariable String nombre,
                                     @PathVariable float sueldo){
        
    String mensaje;
        try{
        
    DAOUsuarioImpl d=new DAOUsuarioImpl();
    d.agregarProducto(new Usuario(nombre, sueldo));
    mensaje="usuario guardado";
    }  
        catch(Exception e){
        mensaje="lo siento tu id";
        }
         return mensaje;
    }
       
}

