package com.bootcamp.tests;

import com.bootcamp.AppConstants;
import com.bootcamp.entities.Beneficiaire;
import com.bootcamp.entities.Programme;
import com.bootcamp.enums.EtatProgramme;
import com.bootcamp.service.crud.BeneficiaireCRUD;
import com.bootcamp.service.crud.ProgrammeCRUD;
import org.testng.annotations.Test;

import javax.persistence.Persistence;
import java.util.*;

public class ProgrammeCRUDTest {
    @Test
    public void generateTables(){

        Persistence.createEntityManagerFactory(AppConstants.PERSISTENCE_UNIT, new Properties() {});
    }

    @Test
    public void create() {
        Programme programme;
        List<Programme> programmes= new ArrayList<Programme>();
        String noms[]= {"abladon","Moudjib","gerauld","faroud","mariam","barriath",
                "bachiroudine","fatai","mansour"};
        String[] descriptions= {"description 1","description 2","description 3","description 4","description 5","description 6",
                "description 7","description 8","description 9","description 10","description 11","description 12","description 13","description 14"};
        double bugProvns[]={1200000.0,140000.0,15000.0,16000.0,13000.0,170000.0,18000.0,017000.0};
        double coutreeles[]={12000000.0,1400000.0,1500000.0,1600000.0,1300000.0,17000000.0,01700000.0};
        for(String name:noms) {
            programme=new Programme();

            Random rand = new Random();
            int  n = rand.nextInt(descriptions.length-1) + 1;
            int  nBg = rand.nextInt(bugProvns.length-1) + 1;
            int  nCR = rand.nextInt(coutreeles.length-1) + 1;
            programme.setNom(name);
            //System.out.println("bailleur name "+bailleur.getNom());
            programme.setDescription(descriptions[n]);
            programme.setBudprevionnel(bugProvns[nBg]);
            programme.setCoutreel(coutreeles[nCR]);
            programmes.add(programme);
            programme.setDateDebutPrev(new Date());
            programme.setDateFinPrev(new Date());
            programme.setDateDebutReel(new Date());
            programme.setDateFinReel(new Date());
            programme.setEtatProgramme(EtatProgramme.PREETUDE);
            programme.setIdObjectif(n);
            programme.setNomPhases(null);
            programme.setPhaseActuelle(null);

            for (Programme current:programmes){
                ProgrammeCRUD.create(current);
            }

        }

    }

}
