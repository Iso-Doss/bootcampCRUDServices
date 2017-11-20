package com.bootcamp.service.crud;

import com.bootcamp.entities.Programme;
import com.bootcamp.jpa.ProgrammeRepository;
import com.bootcamp.constants.AppConstants;
import com.bootcamp.entities.PhaseProgramme;
import com.bootcamp.jpa.PhaseProgrammeRepository;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author soul
 */
public class ProgrammeCRUD implements AppConstants {

    public static boolean create(Programme programme) {

        try {
            ProgrammeRepository progRepo = new ProgrammeRepository(PERSISTENCE_UNIT);
            progRepo.create(programme);
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(ProgrammeCRUD.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }

    }
    public static List<Programme> findAll() {

        List<Programme> laListe = null;
        try {
            ProgrammeRepository progRepo = new ProgrammeRepository(PERSISTENCE_UNIT);
           laListe= progRepo.findAll();

        } catch (SQLException ex) {
            Logger.getLogger(ProgrammeCRUD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return laListe;
    }

    public static void update(Programme programme){
        ProgrammeRepository progRepo=new ProgrammeRepository(PERSISTENCE_UNIT);

        try {
            progRepo.update(programme);
        } catch (SQLException ex) {
            Logger.getLogger(ProgrammeCRUD.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void delete(Programme programme) {
        ProgrammeRepository progRepo = new ProgrammeRepository(PERSISTENCE_UNIT);
        try {
            progRepo.delete(programme);
        } catch (SQLException ex) {
            Logger.getLogger(ProgrammeCRUD.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
     public static boolean addPhase(PhaseProgramme phase){

        try {
            PhaseProgrammeRepository phaseRepo=new PhaseProgrammeRepository(PERSISTENCE_UNIT);
            phaseRepo.create(phase);
            
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(ProgrammeCRUD.class.getName()).log(Level.SEVERE, null, ex);
         return false;
        }

    }
      public static boolean deletePhase(PhaseProgramme phase){

        try {
            PhaseProgrammeRepository phaseRepo=new PhaseProgrammeRepository(PERSISTENCE_UNIT);
            phaseRepo.delete(phase);

            return true;
        } catch (SQLException ex) {
            Logger.getLogger(ProgrammeCRUD.class.getName()).log(Level.SEVERE, null, ex);
         return false;
        }

    }
       public static boolean updatePhase(PhaseProgramme phase){

        try {
            PhaseProgrammeRepository phaseRepo=new PhaseProgrammeRepository(PERSISTENCE_UNIT);
            phaseRepo.update(phase);

            return true;
        } catch (SQLException ex) {
            Logger.getLogger(ProgrammeCRUD.class.getName()).log(Level.SEVERE, null, ex);
         return false;
        }

    }

  
}
