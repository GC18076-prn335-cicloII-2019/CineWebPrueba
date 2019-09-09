/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ues.occ.edu.sv.ingenieria.prn335.cweb.controller;

import java.util.List;
import javax.ejb.Local;
import ues.occ.edu.sv.ingenieria.prn335.centities.MenuConsumible;

/**
 *
 * @author fernando
 */
@Local
public interface MenuConsumibleFacadeLocal {

    void create(MenuConsumible menuConsumible);

    void edit(MenuConsumible menuConsumible);

    void remove(MenuConsumible menuConsumible);

    MenuConsumible find(Object id);

    List<MenuConsumible> findAll();

    List<MenuConsumible> findRange(int[] range);

    int count();
    
}
