/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ues.occ.edu.sv.ingenieria.prn335.cweb.controller;

import java.util.List;
import javax.ejb.Local;
import ues.occ.edu.sv.ingenieria.prn335.centities.CaracteristicaSala;

/**
 *
 * @author fernando
 */
@Local
public interface CaracteristicaSalaFacadeLocal {

    void create(CaracteristicaSala caracteristicaSala);

    void edit(CaracteristicaSala caracteristicaSala);

    void remove(CaracteristicaSala caracteristicaSala);

    CaracteristicaSala find(Object id);

    List<CaracteristicaSala> findAll();

    List<CaracteristicaSala> findRange(int[] range);

    int count();
    
}
