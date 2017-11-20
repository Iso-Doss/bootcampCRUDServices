package com.bootcamp.service.crud;

import com.bootcamp.constants.AppConstants;
import com.bootcamp.entities.Bailleur;
import com.bootcamp.entities.Beneficiaire;
import com.bootcamp.jpa.BailleurRepository;
import com.bootcamp.jpa.BeneficiaireRepository;

import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class BeneficiaireCRUD implements AppConstants {


    public static boolean create(Beneficiaire beneficiaire) {
        BeneficiaireRepository beneficiaireRepository = new BeneficiaireRepository(AppConstants.PERSISTENCE_UNIT);
        try {
            return beneficiaireRepository.create(beneficiaire);

        } catch (SQLException ex) {

            Logger.getLogger(BeneficiaireCRUD.class.getName()).log(Level.SEVERE, null, ex);

        }
        return false;
    }

    public static boolean update(Beneficiaire beneficiaire) {
        BeneficiaireRepository beneficiaireRepository = new BeneficiaireRepository(AppConstants.PERSISTENCE_UNIT);
        try {
            return beneficiaireRepository.update(beneficiaire);
        } catch (SQLException ex) {
            Logger.getLogger(BeneficiaireCRUD.class.getName()).log(Level.SEVERE, null, ex);

        }
        return false;

    }


    public static Beneficiaire read(String name){
        BeneficiaireRepository beneficiaireRepository = new BeneficiaireRepository(AppConstants.PERSISTENCE_UNIT);
        try {
            return beneficiaireRepository.findByPropertyUnique("nom",name);

        } catch (SQLException e) {
            Logger.getLogger(BeneficiaireCRUD.class.getName()).log(Level.SEVERE, null, e);

        }
        return null;
    }




    public static boolean delete(Beneficiaire beneficiaire) {
        BeneficiaireRepository beneficiaireRepository = new BeneficiaireRepository(AppConstants.PERSISTENCE_UNIT);
        try {
            beneficiaireRepository.delete(beneficiaire);
            return true;
        } catch (SQLException ex) {

            Logger.getLogger(BeneficiaireCRUD.class.getName()).log(Level.SEVERE, null, ex);

        }
        return false;
    }

    public static Beneficiaire read(Long id) {
        BeneficiaireRepository beneficiaireRepository = new BeneficiaireRepository(AppConstants.PERSISTENCE_UNIT);
        try {
            return beneficiaireRepository.findByPropertyUnique("id",id);

        } catch (SQLException ex) {
            Logger.getLogger(BeneficiaireCRUD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public static List<Beneficiaire> readAll() {
        BeneficiaireRepository beneficiaireRepository = new BeneficiaireRepository(AppConstants.PERSISTENCE_UNIT);
        try {
            return beneficiaireRepository.findAll();
        } catch (SQLException ex) {
            Logger.getLogger(BailleurCRUD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

}
