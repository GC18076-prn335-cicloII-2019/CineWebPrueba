/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ues.occ.edu.sv.ingenieria.prn335.cweb.controller;

import java.util.List;
import javax.ejb.Local;
import ues.occ.edu.sv.ingenieria.prn335.centities.AsientoSala;

/**
 *
 * @author fernando
 */
@Local
public interface AsientoSalaFacadeLocal {

    void create(AsientoSala asientoSala);

    void edit(AsientoSala asientoSala);

    void remove(AsientoSala asientoSala);

    AsientoSala find(Object id);

    List<AsientoSala> findAll();

    List<AsientoSala> findRange(int[] range);

    int count();
    
}
