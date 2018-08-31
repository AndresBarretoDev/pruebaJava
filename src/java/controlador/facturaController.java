/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import entidades.Factura;
import entidades.Linea;
import facade.FacturaFacade;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.Dependent;

/**
 *
 * @author Andres
 */
@Named(value = "facturaController")
@Dependent
public class facturaController {

    /**
     * Creates a new instance of facturaController
     */
    public facturaController() {
        factura = new Factura();
        linea = new Linea();
    }
    @EJB
    FacturaFacade facturaFacade;
    private Factura factura;
    private Linea linea;

    public Factura getFactura() {
        return factura;
    }

    public void setFactura(Factura factura) {
        this.factura = factura;
    }

    public Linea getLinea() {
        return linea;
    }

    public void setLinea(Linea linea) {
        this.linea = linea;
    }

    public List<Factura> listarFactura() {
        return facturaFacade.findAll();
    }

    public void registrarEquipo() {
        factura.setLINEAnumlinea(linea);
        facturaFacade.create(factura);
        factura = new Factura();
    }

    public void eliminarFactura(Factura newFactura) {
        factura = newFactura;
        facturaFacade.remove(factura);
        factura = new Factura();
    }

    public String editarFactura(Factura newFactura) {
        factura = newFactura;
        return "/factura/Modificar";
    }

    public String editarFactura() {
        factura.setLINEAnumlinea(linea);
        facturaFacade.edit(factura);
        factura = new Factura();
        return "/factura/Listar";
    }

}
