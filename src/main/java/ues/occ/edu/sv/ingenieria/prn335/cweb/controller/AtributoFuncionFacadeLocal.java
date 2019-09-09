/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ues.occ.edu.sv.ingenieria.prn335.cweb.controller;

import java.util.List;
import javax.ejb.Local;
import ues.occ.edu.sv.ingenieria.prn335.centities.AtributoFuncion;

/**
 *
 * @author fernando
 */
@Local
public interface AtributoFuncionFacadeLocal {

    void create(AtributoFuncion atributoFuncion);

    void edit(AtributoFuncion atributoFuncion);

    void remove(AtributoFuncion atributoFuncion);

    AtributoFuncion find(Object id);

    List<AtributoFuncion> findAll();

    List<AtributoFuncion> findRange(int[] range);

    int count();
    
}
