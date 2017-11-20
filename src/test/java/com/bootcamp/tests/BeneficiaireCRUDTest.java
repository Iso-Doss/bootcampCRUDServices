package com.bootcamp.tests;

import com.bootcamp.constants.AppConstants;
import com.bootcamp.entities.Beneficiaire;
import com.bootcamp.service.crud.BeneficiaireCRUD;
import org.testng.annotations.Test;

import javax.persistence.Persistence;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Random;

public class BeneficiaireCRUDTest {
    @Test
    public void generateTables(){

        Persistence.createEntityManagerFactory(AppConstants.PERSISTENCE_UNIT, new Properties() {});
    }

    @Test
    public void create() {
        Beneficiaire beneficiaire;
        List<Beneficiaire> beneficiaires= new ArrayList<Beneficiaire>();
        String noms[]= {"abladon","Moudjib","gerauld","faroud","mariam","barriath",
                "bachiroudine","fatai","mansour"};
        String[] descriptions= {"description 1","description 2","description 3","description 4","description 5","description 6",
                "description 7","description 8","description 9","description 10","description 11","description 12","description 13","description 14"};
        for(String name:noms) {
            beneficiaire=new Beneficiaire();
            System.out.println("beneficiaire "+name);
            Random rand = new Random();
            int  n = rand.nextInt(descriptions.length-1) + 1;
            beneficiaire.setNom(name);
            //System.out.println("bailleur name "+bailleur.getNom());
            beneficiaire.setDescription(descriptions[n]);
            beneficiaires.add(beneficiaire);
            for (Beneficiaire current:beneficiaires){
                BeneficiaireCRUD.create(current);
            }

        }

    }

    @Test
    public void update(){
        Beneficiaire beneficiaire = new Beneficiaire();
        beneficiaire.setId(1L);
        beneficiaire.setNom("ABLADON Ibrahim");
        beneficiaire.setDescription("Description 15");
        BeneficiaireCRUD.update(beneficiaire);
    }

    @Test
    public void readOne(){
        System.out.println("ReadOne : Name :"+BeneficiaireCRUD.read(1L).getNom()+" Description:"+BeneficiaireCRUD.read(1L).getDescription());
    }

    @Test
    public void readAll(){
        for(Beneficiaire beneficiaire: BeneficiaireCRUD.readAll()){
            System.out.println(beneficiaire.getNom()+" de "+beneficiaire.getDescription());
        }
    }

}
