/**
 * Realisation de quelques tests
 */
package com.bootcamp.tests;

import com.bootcamp.entities.PhaseProgramme;
import com.bootcamp.entities.Programme;
import com.bootcamp.enums.EtatProgramme;
import com.bootcamp.service.crud.ProgrammeCRUD;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.testng.annotations.Test;

/**
 *
 * @author soul
 */
public class GenerateTableTest  {
       
        //create a new objet phaseprogramme
        PhaseProgramme nPhase1=new PhaseProgramme();
        //create a new objet phaseprogramme
        PhaseProgramme nPhase2=new PhaseProgramme();
        //create a new objet phaseprogramme
        PhaseProgramme nPhase3=new PhaseProgramme();
        //create a new objet phaseprogramme
        PhaseProgramme nPhase4=new PhaseProgramme();
        ProgrammeCRUD crudProgram=new ProgrammeCRUD();

/**
 * test to verify the use of the CRUD service
 */
    @Test
    public void createPhases() {

        //set the name of the phase via the crud service
        nPhase1.setNomPhase("Phase de sensibilisation via CRUD");

        //set the name of the phase via the crud service
        nPhase2.setNomPhase("Phase de communication via CRUD");

        //set the name of the phase via the crud service
        nPhase3.setNomPhase("Phase de vulgarisation via CRUD");

        //set the name of the phase via the crud service
        nPhase4.setNomPhase("Phase de cohercision via CRUD");
        ProgrammeCRUD.addPhase(nPhase1);
        ProgrammeCRUD.addPhase(nPhase2);
        ProgrammeCRUD.addPhase(nPhase3);
        ProgrammeCRUD.addPhase(nPhase4);

    }

    /**
     * test to verify the use of the CRUD service
     */

    @Test
    public void createProgrammes() throws SQLException{


        //set the name of the phase via the crud service
        nPhase1.setNomPhase("Phase de sensibilisation via CRUD");

        //set the name of the phase via the crud service
        nPhase2.setNomPhase("Phase de communication via CRUD");

        //set the name of the phase via the crud service
        nPhase3.setNomPhase("Phase de vulgarisation via CRUD");

        //set the name of the phase via the crud service
        nPhase4.setNomPhase("Phase de cohercision via CRUD");


        String nom = "Luttre contre violence conjugale via CRUD";

        String description = "zero tolerance aux violences faites aux femmes via CRUD"; //description du programme

        int idObjectif = 1; //id to recevoir permettant de faire des recherche sur un objectif precis

        double budprevionnel = 200000;

        double coutreel = 500000;

        Date dateDebutPrev = new Date();

        Date dateFinPrev = new Date();

        Date dateDebutReel = new Date();

        Date dateFinReel = new Date();


    List<PhaseProgramme> nomPhases=new ArrayList<>();
    //add some phases tu this project
    nomPhases.add(nPhase1);
    nomPhases.add(nPhase2);
    nomPhases.add(nPhase3);
    nomPhases.add(nPhase4);

        //other programs may have other phases
        PhaseProgramme phaseActuelle = nPhase2; // the programme is at begenning

        EtatProgramme etatProgramme = EtatProgramme.PREETUDE;

        Programme nvoProg = new Programme();
        //Ajout des phases
        //definition des attributions du programmes
        nvoProg.setBudprevionnel(budprevionnel);
        nvoProg.setNom(nom);
        nvoProg.setDescription(description);
        nvoProg.setPhaseActuelle(phaseActuelle);
        nvoProg.setIdObjectif(idObjectif);
        nvoProg.setCoutreel(coutreel);
        nvoProg.setDateDebutPrev(dateDebutPrev);
        nvoProg.setDateDebutReel(dateDebutReel);
        nvoProg.setDateFinPrev(dateFinPrev);
        nvoProg.setDateFinReel(dateFinReel);
        nvoProg.setNomPhases(nomPhases);
        nvoProg.setEtatProgramme(etatProgramme);

     
        ProgrammeCRUD.addPhase(nPhase1);
         ProgrammeCRUD.addPhase(nPhase2);
          ProgrammeCRUD.addPhase(nPhase3);
           ProgrammeCRUD.addPhase(nPhase4);

        ProgrammeCRUD.create(nvoProg);

    }
}
