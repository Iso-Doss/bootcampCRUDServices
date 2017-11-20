/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bootcamp.tests;

import com.bootcamp.entities.Livrable;
import com.bootcamp.enums.EtatLivrable;
import com.bootcamp.service.crud.LivrableCRUD;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.testng.annotations.Test;

/**
 *
 * @author leger
 */
public class LivrableCRUDTest {

    // Création d'instance de LivrableCRUD
    LivrableCRUD livrableCRUD = new LivrableCRUD();

    @Test
    public void createLivrable() {

        // Création de liste d'objectis
        List<Object> objectifs = new ArrayList<Object>();
        objectifs.add("objectif1");
        objectifs.add("objectif2");
        objectifs.add("objectif3");

        //Création de liste de lieux
        List<Object> lieux = new ArrayList<Object>();
        lieux.add("lieu1");
        lieux.add("lieu2");
        lieux.add("lieu3");

        // Création d'instances de Livrable
        for (int i = 0; i < 20; i++) {
            EtatLivrable etat = (i % 2 == 0) ? EtatLivrable.realisation : EtatLivrable.livre;
            int j = i + 1;
            Livrable li = new Livrable(j, "reference" + j, "description" + j, objectifs, lieux, etat);
            try {
                livrableCRUD.create(li);
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }
      
    }
    
    //@Test
    public void updateLivrable (){
        
    }

}
