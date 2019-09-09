/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ues.occ.edu.sv.ingenieria.prn335.cweb.controller;

import java.util.List;
import javax.ejb.Local;
import ues.occ.edu.sv.ingenieria.prn335.centities.TipoPago;

/**
 *
 * @author fernando
 */
@Local
public interface TipoPagoFacadeLocal {

    void create(TipoPago tipoPago);

    void edit(TipoPago tipoPago);

    void remove(TipoPago tipoPago);

    TipoPago find(Object id);

    List<TipoPago> findAll();

    List<TipoPago> findRange(int[] range);

    int count();
    
}
