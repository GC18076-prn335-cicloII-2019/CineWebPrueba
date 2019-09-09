/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ues.occ.edu.sv.ingenieria.prn335.cweb.controller;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import ues.occ.edu.sv.ingenieria.prn335.centities.MenuConsumible;

/**
 *
 * @author fernando
 */
@Stateless
public class MenuConsumibleFacade extends AbstractFacade<MenuConsumible> implements MenuConsumibleFacadeLocal {

    @PersistenceContext(unitName = "cPruebaPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public MenuConsumibleFacade() {
        super(MenuConsumible.class);
    }
    
}
