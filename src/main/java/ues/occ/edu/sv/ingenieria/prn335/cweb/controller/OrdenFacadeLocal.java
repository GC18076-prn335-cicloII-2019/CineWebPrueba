/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ues.occ.edu.sv.ingenieria.prn335.cweb.controller;

import java.util.List;
import javax.ejb.Local;
import ues.occ.edu.sv.ingenieria.prn335.centities.Orden;

/**
 *
 * @author fernando
 */
@Local
public interface OrdenFacadeLocal {

    void create(Orden orden);

    void edit(Orden orden);

    void remove(Orden orden);

    Orden find(Object id);

    List<Orden> findAll();

    List<Orden> findRange(int[] range);

    int count();
    
}
