/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ues.occ.edu.sv.ingenieria.prn335.cweb.managed;

import java.io.Serializable;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import ues.occ.edu.sv.ingenieria.prn335.centities.Funcion;
import ues.occ.edu.sv.ingenieria.prn335.centities.Pelicula;
import ues.occ.edu.sv.ingenieria.prn335.centities.Sala;
import ues.occ.edu.sv.ingenieria.prn335.centities.Sucursal;
import ues.occ.edu.sv.ingenieria.prn335.cweb.controller.PeliculaFacadeLocal;
import ues.occ.edu.sv.ingenieria.prn335.cweb.controller.Prueba;

/**
 *
 * @author fernando
 */
@Named(value = "managedBeans")
@ViewScoped
public class ManagedBeans implements Serializable {

    /**
     * Creates a new instance of ManagedBeans
     */
    @Inject
    private PeliculaFacadeLocal facadePelicula;

    @Inject
    private Prueba facadePrueba;

    private String tipo;
    private String director;
    private Date fecha;
    private String clasificacion;
    private String genero;
    private String tipoProyeccion;

    public ManagedBeans() {
    }

    public List<Pelicula> mostrarPeliculas() {
        return facadePelicula.findAll();
    }

    public List<Sala> salasAsiento() {
        return facadePrueba.tipoAsiento(this.tipo);
    }

    public List<Funcion> funcionesDirector() {
        return facadePrueba.funcionPorDirector(this.director);
    }

    public List<Sala> salasFuncion() {
        if (this.fecha != null) {
            return facadePrueba.salasPorFuncion(new java.sql.Date(this.fecha.getTime()));
        }
        return Collections.emptyList();
    }

    public List<Pelicula> peliculasTipo() {
        return facadePrueba.tipoPelicula(this.clasificacion, this.genero);
    }

    public List<Sucursal> sucursalSala() {
        return facadePrueba.sucursalSala(this.tipoProyeccion);
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Prueba getFacadePrueba() {
        return facadePrueba;
    }

    public void setFacadePrueba(Prueba facadePrueba) {
        this.facadePrueba = facadePrueba;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getClasificacion() {
        return clasificacion;
    }

    public void setClasificacion(String clasificacion) {
        this.clasificacion = clasificacion;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getTipoProyeccion() {
        return tipoProyeccion;
    }

    public void setTipoProyeccion(String tipoProyeccion) {
        this.tipoProyeccion = tipoProyeccion;
    }

    public void mensajesControl() {
        Object[] parametros = {this.tipo, this.director, this.clasificacion + this.genero, this.tipoProyeccion, this.fecha};
        List[] metodos = {this.salasAsiento(), this.funcionesDirector(), this.peliculasTipo(), this.sucursalSala(), this.salasFuncion()};
        String[] consultas = {"salas con asientos " + this.tipo, "funciones por director " + this.director,
            "peliculas clasificacion " + this.clasificacion + " y genero " + this.genero,
            "sucursales con " + this.tipoProyeccion, "salas con funciones despues de " + this.fecha};
        FacesMessage mensaje;
        for (int i = 0; i < metodos.length; i++) {
            if (parametros[i] != null) {
                if (!(parametros[i].toString().isEmpty())) {
                    if (metodos[i].isEmpty()) {
                        mensaje = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Consulta " + consultas[i] + " fallida", null);
                    } else {
                        mensaje = new FacesMessage(FacesMessage.SEVERITY_INFO, "Consulta " + consultas[i] + " exitosa", null);
                    }
                    FacesContext.getCurrentInstance().addMessage(null, mensaje);
                }
            }
        }
    }
}
