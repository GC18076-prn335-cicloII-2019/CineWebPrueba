/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ues.occ.edu.sv.ingenieria.prn335.cweb.controller;

import java.util.List;
import javax.ejb.Local;
import ues.occ.edu.sv.ingenieria.prn335.centities.AtributoAsiento;

/**
 *
 * @author fernando
 */
@Local
public interface AtributoAsientoFacadeLocal {

    void create(AtributoAsiento atributoAsiento);

    void edit(AtributoAsiento atributoAsiento);

    void remove(AtributoAsiento atributoAsiento);

    AtributoAsiento find(Object id);

    List<AtributoAsiento> findAll();

    List<AtributoAsiento> findRange(int[] range);

    int count();
    
}
