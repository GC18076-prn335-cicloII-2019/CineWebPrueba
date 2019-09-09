/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ues.occ.edu.sv.ingenieria.prn335.cweb.controller;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import ues.occ.edu.sv.ingenieria.prn335.centities.CaracteristicaAsiento;

/**
 *
 * @author fernando
 */
@Stateless
public class CaracteristicaAsientoFacade extends AbstractFacade<CaracteristicaAsiento> implements CaracteristicaAsientoFacadeLocal {

    @PersistenceContext(unitName = "cPruebaPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CaracteristicaAsientoFacade() {
        super(CaracteristicaAsiento.class);
    }
    
}
