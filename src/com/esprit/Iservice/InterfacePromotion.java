/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.Iservice;

import com.esprit.entities.Promotion;

/**
 *
 * @author Kais Fatnassi
 */
public interface InterfacePromotion {
    public void ajouterPromotion(Promotion a);
    public void modifierActualite(Promotion a);
    public void supprimerPromotion(Promotion a);
}
