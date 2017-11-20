package com.bootcamp.tests;

import com.bootcamp.AppConstants;
import com.bootcamp.entities.Fournisseur;
import com.bootcamp.service.crud.FournisseurCRUD;
import org.testng.annotations.Test;

import javax.persistence.Persistence;
import java.util.List;
import java.util.Properties;
import java.util.Random;


public class FournisseurCRUDTest {

    @Test
    public void generateTables(){

        Persistence.createEntityManagerFactory(AppConstants.PERSISTENCE_UNIT, new Properties() {});
    }

    @Test
    public void createFournisseurs() {
        Fournisseur fournisseur;
        String noms[]= {"fournisseur 1","fournisseur 2","fournisseur 3","fournisseur 4","fournisseur 5","fournisseur 6",
                "fournisseur 7","fournisseur 8","fournisseur 9","fournisseur 10"};
        String[] pays= {"Algerie","Afganistan","Allmangne","Belgique","Benin","Burkina-Faso",
                "Canada","Malie","France","Londre","Togo","Ghana","Niger","Nigeria"};
        for(String name:noms) {
            fournisseur=new Fournisseur();
            System.out.println("fournisseur "+name);
            Random rand = new Random();
            int  n = rand.nextInt(pays.length-1) + 1;
            fournisseur.setNom(name);
            fournisseur.setPays(pays[n]);
            FournisseurCRUD.create(fournisseur);
        }

    }


    @Test
    public void update(){
            Fournisseur fournisseur = FournisseurCRUD.read(2L);
            fournisseur.setNom("fournisseur 99");
            FournisseurCRUD.update(fournisseur);

    }

    @Test
    public void readOne(){
        Fournisseur fournisseur = FournisseurCRUD.read(2L);
        System.out.println("Nom : "+fournisseur.getNom()+" pays: "+fournisseur.getPays());

    }

    @Test
    public void readAll(){
                    List<Fournisseur> fournisseurs = FournisseurCRUD.readAll();
            for(Fournisseur current : fournisseurs)
                System.out.println("name : "+current.getNom()+" pays: "+current.getPays());

    }
}
