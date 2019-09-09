/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ues.occ.edu.sv.ingenieria.prn335.cweb.controller;

import java.util.List;
import javax.ejb.Local;
import ues.occ.edu.sv.ingenieria.prn335.centities.Descuento;

/**
 *
 * @author fernando
 */
@Local
public interface DescuentoFacadeLocal {

    void create(Descuento descuento);

    void edit(Descuento descuento);

    void remove(Descuento descuento);

    Descuento find(Object id);

    List<Descuento> findAll();

    List<Descuento> findRange(int[] range);

    int count();
    
}
