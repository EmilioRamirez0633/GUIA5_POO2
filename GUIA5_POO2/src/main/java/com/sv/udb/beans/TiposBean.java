/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sv.udb.beans;

import com.sv.udb.controladores.TiposCtrl;
import com.sv.udb.modelos.Tipos;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import org.primefaces.context.RequestContext;

/**
 *
 * @author Estudiante
 */
@Named(value = "tiposBean")
@ViewScoped
public class TiposBean implements Serializable{
    private Tipos objeTipo;
    private List<Tipos> listTipo;
    /**
     * Creates a new instance of TiposBean
     */
    public TiposBean() {
    }

    public Tipos getObjeTipo() {
        return objeTipo;
    }

    public List<Tipos> getListTipo() {
        return listTipo;
    }
    
    

    public void setObjeTipo(Tipos objeTipo) {
        this.objeTipo = objeTipo;
        
    }
    
    
    
    //se ejecuta despues de que la pàgina carga
    @PostConstruct
    public void init()
    {
        this.objeTipo = new Tipos();
        this.listTipo = new TiposCtrl().cons();
    }
    
    public void guar()
    {
        RequestContext ctx = RequestContext.getCurrentInstance(); //Capturo el contexto de la página
        if(new TiposCtrl().guar(this.objeTipo))
        {
            this.objeTipo = new Tipos();
            ctx.execute("setMessage('MESS_SUCC', 'Atención', 'Datos guardados')");
            System.err.println("Guardó");
        }
        else
        {
            ctx.execute("setMessage('MESS_ERRO', 'Atención', 'No se guardó')");
            System.err.println("No guardó");
        }
    }
    
}
