/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ues.occ.edu.sv.ingenieria.prn335.cweb.controller;

import java.util.List;
import javax.ejb.Local;
import ues.occ.edu.sv.ingenieria.prn335.centities.CaracteristicaAsiento;

/**
 *
 * @author fernando
 */
@Local
public interface CaracteristicaAsientoFacadeLocal {

    void create(CaracteristicaAsiento caracteristicaAsiento);

    void edit(CaracteristicaAsiento caracteristicaAsiento);

    void remove(CaracteristicaAsiento caracteristicaAsiento);

    CaracteristicaAsiento find(Object id);

    List<CaracteristicaAsiento> findAll();

    List<CaracteristicaAsiento> findRange(int[] range);

    int count();
    
}
