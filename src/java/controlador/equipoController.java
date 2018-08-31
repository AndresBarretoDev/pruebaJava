/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import entidades.Equipo;
import entidades.Linea;
import facade.EquipoFacade;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.Dependent;

/**
 *
 * @author Andres
 */
@Named(value = "equipoController")
@Dependent
public class equipoController {

    /**
     * Creates a new instance of equipoController
     */
    public equipoController() {
        equipo = new Equipo();
        linea = new Linea();
    }
    @EJB
    EquipoFacade equipoFacade;
    private Equipo equipo;
    private Linea linea;

    public Equipo getEquipo() {
        return equipo;
    }

    public Linea getLinea() {
        return linea;
    }

    public void setLinea(Linea linea) {
        this.linea = linea;
    }

    public void setEquipo(Equipo equipo) {
        this.equipo = equipo;
    }

    public List<Equipo> listarEquipo() {
        return equipoFacade.findAll();
    }

    public void registrarEquipo() {
        equipo.setLINEAnumlinea(linea);
        equipoFacade.create(equipo);
        equipo = new Equipo();
    }

    public void eliminarEquipo(Equipo newEquipo) {
        equipo = newEquipo;
        equipoFacade.remove(equipo);
        equipo = new Equipo();
    }

    public String editarEquipo(Equipo newEquipo) {
        equipo = newEquipo;
        return "/equipo/Modificar";
    }

    public String editarEquipo() {
        equipo.setLINEAnumlinea(linea);
        equipoFacade.edit(equipo);
        equipo = new Equipo();
        return "/equipo/Listar";
    }

}
