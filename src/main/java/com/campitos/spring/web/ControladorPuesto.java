package com.campitos.spring.web;




import com.campitos.spring.web.DAOPuestoImpl;
import com.campitos.spring.web.Nomina2;
import com.campitos.spring.web.Puesto;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/")

public class ControladorPuesto {

    @RequestMapping(value = "/puesto",method=RequestMethod.GET,headers={"Accept=Application/json"})
    
    public @ResponseBody String metodoBuscarPuestos()throws Exception{
        
     ObjectMapper maper=new ObjectMapper();
     DAOPuestoImpl nom=new DAOPuestoImpl();
     return maper.writeValueAsString(nom.buscarPuestos());
     
      }
    
    @RequestMapping(value = "/puesto/{id_pues}/{tipo_puesto}",method = RequestMethod.GET,headers = {"Accept=text/html"})
    
    public @ResponseBody String metodoInsertarPuesto (@PathVariable int id_pues,@PathVariable String tipo_puesto){
     String mensaje;
        try{
        
    DAOPuestoImpl d=new DAOPuestoImpl();
    d.agregarPuesto(new Puesto(tipo_puesto, new Nomina2(id_pues)));
    mensaje="puesto agregado con exito"; 
    }
    catch(Exception e){
    mensaje="lo siento no existe ese puesto:"+e.getMessage();
    }
    return mensaje;
    
     }
     }
