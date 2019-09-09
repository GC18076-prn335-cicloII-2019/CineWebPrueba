/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ues.occ.edu.sv.ingenieria.prn335.cweb.controller;

import java.util.List;
import javax.ejb.Local;
import ues.occ.edu.sv.ingenieria.prn335.centities.CaracteristicaFuncion;

/**
 *
 * @author fernando
 */
@Local
public interface CaracteristicaFuncionFacadeLocal {

    void create(CaracteristicaFuncion caracteristicaFuncion);

    void edit(CaracteristicaFuncion caracteristicaFuncion);

    void remove(CaracteristicaFuncion caracteristicaFuncion);

    CaracteristicaFuncion find(Object id);

    List<CaracteristicaFuncion> findAll();

    List<CaracteristicaFuncion> findRange(int[] range);

    int count();
    
}
