package com.bootcamp.service.crud;

import com.bootcamp.constants.AppConstants;
import com.bootcamp.entities.Fournisseur;
import com.bootcamp.jpa.FournisseurRepository;


import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FournisseurCRUD implements AppConstants {

    public static boolean create(Fournisseur fournisseur) {
       FournisseurRepository fournisseurRepository = new FournisseurRepository(AppConstants.PERSISTENCE_UNIT);
        try {
            return 	fournisseurRepository.create(fournisseur);

        } catch (SQLException e) {
            Logger.getLogger(Fournisseur.class.getName()).log(Level.SEVERE, null, e);

        }
        return false;
    }

    public static boolean update(Fournisseur bailleur) {
        FournisseurRepository fournisseurRepository = new FournisseurRepository(AppConstants.PERSISTENCE_UNIT);
        try {
            return fournisseurRepository.update(bailleur);
        } catch (SQLException e) {
            Logger.getLogger(Fournisseur.class.getName()).log(Level.SEVERE, null, e);
            return false;
        }

    }

    public static boolean delete(Fournisseur bailleur) {
        FournisseurRepository fournisseurRepository = new FournisseurRepository(AppConstants.PERSISTENCE_UNIT);
        try {
            fournisseurRepository.delete(bailleur);
            return true;
        } catch (SQLException e) {
            Logger.getLogger(Fournisseur.class.getName()).log(Level.SEVERE, null, e);
            return false;
        }
    }

    public static Fournisseur read(Long id){
        FournisseurRepository fournisseurRepository = new FournisseurRepository(AppConstants.PERSISTENCE_UNIT);
        try {
            return fournisseurRepository.findByPropertyUnique("id",id);
        } catch (SQLException e) {
            Logger.getLogger(Fournisseur.class.getName()).log(Level.SEVERE, null, e);

        }
        return null;
    }

    public static Fournisseur read(String name){
        FournisseurRepository fournisseurRepository = new FournisseurRepository(AppConstants.PERSISTENCE_UNIT);
        try {
            return fournisseurRepository.findByPropertyUnique("nom",name);
        } catch (SQLException e) {
            Logger.getLogger(Fournisseur.class.getName()).log(Level.SEVERE, null, e);

        }
        return null;
    }

    public static List<Fournisseur> readAll(String pays){
        FournisseurRepository fournisseurRepository = new FournisseurRepository(AppConstants.PERSISTENCE_UNIT);
        try {
            return fournisseurRepository.findByProperty("pays",pays);
        } catch (SQLException e) {
            Logger.getLogger(Fournisseur.class.getName()).log(Level.SEVERE, null, e);

        }
        return null;
    }

    public static List<Fournisseur> readAll(){
        FournisseurRepository fournisseurRepository = new FournisseurRepository(AppConstants.PERSISTENCE_UNIT);
        try {
            return fournisseurRepository.findAll();
        } catch (SQLException e) {
            Logger.getLogger(Fournisseur.class.getName()).log(Level.SEVERE, null, e);

        }
        return null;
    }
}
