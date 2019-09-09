/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ues.occ.edu.sv.ingenieria.prn335.cweb.controller;

import java.util.List;
import javax.ejb.Local;
import ues.occ.edu.sv.ingenieria.prn335.centities.Pelicula;

/**
 *
 * @author fernando
 */
@Local
public interface PeliculaFacadeLocal {

    void create(Pelicula pelicula);

    void edit(Pelicula pelicula);

    void remove(Pelicula pelicula);

    Pelicula find(Object id);

    List<Pelicula> findAll();

    List<Pelicula> findRange(int[] range);

    int count();
    
}
