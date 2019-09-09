/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ues.occ.edu.sv.ingenieria.prn335.cweb.controller;

import java.util.List;
import javax.ejb.Local;
import ues.occ.edu.sv.ingenieria.prn335.centities.OrdenConsumible;

/**
 *
 * @author fernando
 */
@Local
public interface OrdenConsumibleFacadeLocal {

    void create(OrdenConsumible ordenConsumible);

    void edit(OrdenConsumible ordenConsumible);

    void remove(OrdenConsumible ordenConsumible);

    OrdenConsumible find(Object id);

    List<OrdenConsumible> findAll();

    List<OrdenConsumible> findRange(int[] range);

    int count();
    
}
