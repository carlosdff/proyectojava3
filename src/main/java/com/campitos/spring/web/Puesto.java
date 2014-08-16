
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.campitos.spring.web;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlTransient;
import org.codehaus.jackson.annotate.JsonIgnore;


@Entity
@Table(name = "puesto")

public class Puesto implements Serializable {
 
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_puesto")
    private Integer idPuesto;
    @Size(max = 80)
    @Column(name = "tipo_puesto")
    private String tipo_puesto;
 @JoinColumn(name = "id_pues", referencedColumnName = "id_nomina")
    @ManyToOne
    private Nomina2 idNomina;



public Puesto(){
    
}


    public String getTipo_puesto() {
        return tipo_puesto;
    }

    public void setTipo_puesto(String tipo_puesto) {
        this.tipo_puesto = tipo_puesto;
    }

    public Nomina2 getIdNomina() {
        return idNomina;
    }

    public void setIdNomina(Nomina2 idNomina) {
        this.idNomina = idNomina;
    }

    public Puesto( String tipo_puesto, Nomina2 idNomina) {
        this.tipo_puesto = tipo_puesto;
        this.idNomina = idNomina;
    }
  
@Override
    public int hashCode() {
        int hash = 0;
        hash += (idPuesto != null ? idPuesto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Puesto)) {
            return false;
        }
        Puesto other = (Puesto) object;
        if ((this.idPuesto == null && other.idPuesto != null) || (this.idPuesto != null && !this.idPuesto.equals(other.idPuesto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.campitos.spring.web.Puesto[ idPuesto=" + idPuesto + " ]";
    }

    
   } 



