/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import entidades.Linea;
import entidades.Persona;
import facade.LineaFacade;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.Dependent;

/**
 *
 * @author Andres
 */
@Named(value = "lineaController")
@Dependent
public class lineaController {

    /**
     * Creates a new instance of lineaController
     */
    public lineaController() {
        linea = new Linea();
        persona = new Persona();
    }

    @EJB
    LineaFacade lineaFacade;
    private Persona persona;
    private Linea linea;

    public Linea getLinea() {
        return linea;
    }

    public void setLinea(Linea linea) {
        this.linea = linea;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public List<Linea> ListarLinea() {
        return lineaFacade.findAll();
    }

    public void registrarLinea() {
        linea.setPERSONAidpersona(persona);
        lineaFacade.create(linea);
        linea = new Linea();
    }

    public void eliminarLinea(Linea newLinea) {
        linea = newLinea;
        lineaFacade.remove(linea);
        linea = new Linea();
    }

    public String editarLinea(Linea newLinea) {
        linea = newLinea;
        return "/linea/Modificar";
    }

    public String editarLinea() {
        linea.setPERSONAidpersona(persona);
        lineaFacade.edit(linea);
        linea = new Linea();
        return "/linea/Listar";
    }

}
