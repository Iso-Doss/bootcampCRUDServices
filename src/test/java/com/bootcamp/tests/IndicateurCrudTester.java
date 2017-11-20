package com.bootcamp.tests;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
 
import com.bootcamp.entities.Indicateur;
import com.bootcamp.enums.TypeIndicateur;
import com.bootcamp.service.crud.IndicateurCRUD;

import java.util.Properties;
import javax.persistence.Persistence;

import org.testng.annotations.Test;

/**
 *
 * @author root
 */
public class IndicateurCrudTester {
      
            Indicateur indicateur1 = new Indicateur("libelle1" , "nom1" , "nature1" , "propriete1" , TypeIndicateur.QUALITATIF , "valeur1" );
            Indicateur indicateur2 = new Indicateur("libelle2" , "nom2" , "nature2" , "propriete2" , TypeIndicateur.QUANTITATIF , "valeur2" );
            Indicateur indicateur3 = new Indicateur("libelle3" , "nom3" , "nature3" , "propriete3" , TypeIndicateur.QUALITATIF , "valeur3" );
            Indicateur indicateur4 = new Indicateur("libelle4" , "nom4" , "nature4" , "propriete4" , TypeIndicateur.QUANTITATIF , "valeur4" );
            Indicateur indicateur5= new Indicateur("libelle5" , "nom5" , "nature5" , "propriete5" , TypeIndicateur.QUALITATIF , "valeur5");
       @Test
       public void generateTables(){
           
           Persistence.generateSchema("databasePU", new Properties());
       }
       //Creation
        @Test
        public void createTester(){
          
            IndicateurCRUD.create(indicateur1);
            IndicateurCRUD.create(indicateur2);
            IndicateurCRUD.create(indicateur3);
            IndicateurCRUD.create(indicateur4);
            IndicateurCRUD.create(indicateur5);
        }

         //Mise à jour
        @Test
         public void updateTester(){
             indicateur5.setNom("Apres mise a jour");
          IndicateurCRUD.update(indicateur5);
         }
}
