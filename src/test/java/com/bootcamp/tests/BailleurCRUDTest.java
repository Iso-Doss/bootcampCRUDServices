package com.bootcamp.tests;

import com.bootcamp.constants.AppConstants;
import com.bootcamp.entities.Bailleur;
import com.bootcamp.service.crud.BailleurCRUD;
import org.testng.annotations.Test;

import javax.persistence.Persistence;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Random;

public class BailleurCRUDTest {

    @Test
    public void generateTables(){

        Persistence.createEntityManagerFactory(AppConstants.PERSISTENCE_UNIT, new Properties() {});
    }

    @Test
    public void createBailleurs() {
        Bailleur bailleur;
        List<Bailleur> bailleurs= new ArrayList<Bailleur>();
        String noms[]= {"abladon","Moudjib","gerauld","faroud","mariam","barriath",
                "bachiroudine","fatai","mansour"};
        String[] pays= {"Algerie","Afganistan","Allmangne","Belgique","Benin","Burkina-Faso",
                "Canada","Malie","France","Londre","Togo","Ghana","Niger","Nigeria"};
        for(String name:noms) {
            bailleur=new Bailleur();
            System.out.println("bailleur "+name);
            Random rand = new Random();
            int  n = rand.nextInt(pays.length-1) + 1;
            bailleur.setNom(name);
            //System.out.println("bailleur name "+bailleur.getNom());
            bailleur.setPays(pays[n]);
            bailleurs.add(bailleur);
            for (Bailleur current:bailleurs){
                BailleurCRUD.create(current);
            }

        }

    }

    @Test
    public void updateBailleur(){
        Bailleur bailleur = new Bailleur();
        bailleur.setId(1L);
        bailleur.setNom("ABLADON Ibrahim");
        bailleur.setPays("London");
        BailleurCRUD.update(bailleur);
    }

    @Test
    public void readOne(){
        System.out.println("ReadOne : Name :"+BailleurCRUD.read(1L).getNom()+" Pays:"+BailleurCRUD.read(1L).getPays());
    }

    @Test
    public void readAll(){
        for(Bailleur bailleur: BailleurCRUD.readAll()){
            System.out.println(bailleur.getNom()+" de "+bailleur.getPays());
        }
    }



}
