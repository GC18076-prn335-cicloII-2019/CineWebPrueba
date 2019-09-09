/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ues.occ.edu.sv.ingenieria.prn335.cweb.controller;

import java.io.Serializable;
import java.sql.Date;
import java.util.Collections;
import java.util.List;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TemporalType;
import ues.occ.edu.sv.ingenieria.prn335.centities.Boleto;
import ues.occ.edu.sv.ingenieria.prn335.centities.Funcion;
import ues.occ.edu.sv.ingenieria.prn335.centities.MenuConsumible;
import ues.occ.edu.sv.ingenieria.prn335.centities.Pelicula;
import ues.occ.edu.sv.ingenieria.prn335.centities.Sala;
import ues.occ.edu.sv.ingenieria.prn335.centities.Sucursal;

/**
 *
 * @author fernando
 */
@Stateless
@LocalBean
public class Prueba implements Serializable {

    @PersistenceContext(unitName = "cPruebaPU")
    private EntityManager em;

    public EntityManager getEm() {
        return em;
    }

    public List<Sala> tipoAsiento(String caracteristica){
        try {
            if (caracteristica != null) {
                Query query = em.createQuery("SELECT s FROM Sala s JOIN s.asientoSalaList al JOIN al.asiento.atributoAsientoList at WHERE at.caracteristicaAsiento.caracteristica = :cs");
                query.setParameter("cs", caracteristica);
                return query.getResultList();
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println(e.getLocalizedMessage());
            System.out.println(e.getCause());
        }
        return Collections.emptyList();
    }
    
    public List<Funcion> funcionPorDirector(String director){
        String nombre = "";
        String apellido = "";
        boolean vacio = false;
        try {
            if (director != null) {
                for (int i = 0; i < director.length(); i++) {
                    if (vacio == false) {
                        nombre += director.charAt(i);
                        if (Character.isWhitespace(director.charAt(i+1))) {
                            vacio = true;
                            i++;
                        }
                    } else{
                        apellido += director.charAt(i);
                    }
                }
                Query query = em.createQuery("SELECT f FROM Funcion f JOIN f.idPelicula.idDirector id WHERE id.nombre = :nombre AND id.apellido = :apellido");
                query.setParameter("nombre", nombre);
                query.setParameter("apellido", apellido);
                return query.getResultList();
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println(e.getLocalizedMessage());
            System.out.println(e.getCause());
        }
        return Collections.emptyList();
    }
    
    public List<Sala> salasPorFuncion(Date fecha) {
        try {
            if (fecha != null) {
                Query query = em.createQuery("SELECT s FROM Sala s JOIN s.asientoSalaList al JOIN al.boletoList b WHERE b.idFuncion.fecha > :fecha");
                query.setParameter("fecha", fecha, TemporalType.DATE);
                return query.getResultList();
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println(e.getLocalizedMessage());
            System.out.println(e.getCause());
        }
        return Collections.emptyList();
    }

    public void setEm(EntityManager em) {
        this.em = em;
    }
    
    public List<Pelicula> tipoPelicula(String clasificacion, String genero) {
        //clasificacion B genero terror
        try {
            if (clasificacion != null || genero != null) {
                Query query = em.createQuery("SELECT p FROM Pelicula p JOIN p.generoList gl WHERE gl.nombre = :genero AND p.idClasificacion.clasificacion = :clasificacion");
                query.setParameter("clasificacion", clasificacion);
                query.setParameter("genero", genero);
                return query.getResultList();
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println(e.getLocalizedMessage());
            System.out.println(e.getCause());
        }
        return Collections.emptyList();
    }
    
    public List<MenuConsumible> productoDescuento(String tipoDescuento) {
        try {
            if (tipoDescuento != null) {
                Query query = em.createQuery("SELECT m FROM MenuConsumible m JOIN m.ordenConsumibleList oc WHERE oc.orden.idDescuento.idTipoDescuento.tipo = :tipo");
                query.setParameter("tipo", tipoDescuento);
                return query.getResultList();
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println(e.getLocalizedMessage());
            System.out.println(e.getCause());
        }
        return Collections.emptyList();
    }
    
    public List<Sucursal> sucursalSala(String tipoProyeccion) {
        //Proyeccion 4DX.
        try {
            if (tipoProyeccion != null) {
                Query query = em.createQuery("SELECT s FROM Sucursal s JOIN s.salaList sl JOIN sl.atributoSalaList at WHERE at.caracteristicaSala.caracteristica = :tipo");
                query.setParameter("tipo", tipoProyeccion);
                return query.getResultList();
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println(e.getLocalizedMessage());
            System.out.println(e.getCause());
        }
        return Collections.emptyList();
    }
    
    public List<Boleto> boletoPago(String formaPago) {
        try {
            if (formaPago != null) {
                Query query = em.createQuery("SELECT b FROM Boleto b JOIN b.facturaList f JOIN f.pagoList p WHERE p.idTipoPago.tipoPago = :forma");
                query.setParameter("forma", formaPago);
                return query.getResultList();
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println(e.getLocalizedMessage());
            System.out.println(e.getCause());
        }
        return Collections.emptyList();
    }
    
    public List<Pelicula> peliculaFamiliar(String clasificacion, Date fecha) {
        //clasificacion B fecha 2019-09-11
        try {
            if (clasificacion != null || fecha != null) {
                Query query = em.createQuery("SELECT p FROM Pelicula p JOIN p.funcionList f JOIN f.boletoList b WHERE b.idFuncion.fecha = :fecha AND p.idClasificacion.clasificacion = :clasificacion");
                query.setParameter("clasificacion", clasificacion);
                query.setParameter("fecha", fecha);
                return query.getResultList();
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println(e.getLocalizedMessage());
            System.out.println(e.getCause());
        }
        return Collections.emptyList();
    }
    
    public List<Pelicula> formatoPelicula(String formato, Date fecha) {
        //clasificacion B fecha 2019-09-11
        try {
            if (formato != null || fecha != null) {
                Query query = em.createQuery("SELECT p FROM Pelicula p JOIN p.funcionList f JOIN f.boletoList b JOIN f.atributoFuncionList af WHERE b.idFuncion.fecha = :fecha AND af.caracteristicaFuncion.caracteristica = :formato");
                query.setParameter("formato", formato);
                query.setParameter("fecha", fecha);
                return query.getResultList();
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println(e.getLocalizedMessage());
            System.out.println(e.getCause());
        }
        return Collections.emptyList();
    }

}
