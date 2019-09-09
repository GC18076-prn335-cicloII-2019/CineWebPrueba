/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ues.occ.edu.sv.ingenieria.prn335.cweb.controller;

import java.util.List;
import javax.ejb.Local;
import ues.occ.edu.sv.ingenieria.prn335.centities.AtributoSala;

/**
 *
 * @author fernando
 */
@Local
public interface AtributoSalaFacadeLocal {

    void create(AtributoSala atributoSala);

    void edit(AtributoSala atributoSala);

    void remove(AtributoSala atributoSala);

    AtributoSala find(Object id);

    List<AtributoSala> findAll();

    List<AtributoSala> findRange(int[] range);

    int count();
    
}
