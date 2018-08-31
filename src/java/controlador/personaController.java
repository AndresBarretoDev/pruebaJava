/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import entidades.Persona;
import facade.PersonaFacade;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.Dependent;

/**
 *
 * @author Andres
 */
@Named(value = "personaController")
@Dependent
public class personaController {

    /**
     * Creates a new instance of personaController
     */
    public personaController() {
        persona = new Persona();
    }
    @EJB
    PersonaFacade personaFacade;
    private Persona persona;

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }
    public List<Persona> listarPersona() {
        return personaFacade.findAll();
    }

    public void registrarPersona() {
        personaFacade.create(persona);
        persona = new Persona();
    }

    public void eliminarPersona(Persona newPersona) {
        persona = newPersona;
        personaFacade.remove(persona);
        persona = new Persona();
    }

    public String editarPersona(Persona newPersona) {
        persona = newPersona;
        return "/persona/Modificar";

    }

    public String editarPersona() {
        personaFacade.edit(persona);
        persona = new Persona();
        return "/documento/Listar";
    }

}
