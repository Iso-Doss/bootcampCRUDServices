
package com.bootcamp.service.crud;


import com.bootcamp.constants.AppConstants;
import com.bootcamp.entities.Indicateur;
import com.bootcamp.jpa.IndicateurRepository;
import java.beans.IntrospectionException;
import java.lang.reflect.InvocationTargetException;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author soul
 */
public class IndicateurCRUD implements AppConstants{
    
    
    public static boolean create(Indicateur indicateur){

        try {
            IndicateurRepository ir=new IndicateurRepository(PERSISTENCE_UNIT);
            ir.create(indicateur);
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(IndicateurCRUD.class.getName()).log(Level.SEVERE, null, ex);
         return false;
        }
       
    }
      public static void read(){

        try {
            IndicateurRepository ir=new IndicateurRepository(PERSISTENCE_UNIT);
            ir.findAll();

        } catch (SQLException ex) {
            Logger.getLogger(IndicateurCRUD.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public static void read(Indicateur indicateur){
        IndicateurRepository ir=new IndicateurRepository(PERSISTENCE_UNIT);

        try {
            ir.update(indicateur);
        } catch (SQLException ex) {
            Logger.getLogger(IndicateurCRUD.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void delete(Indicateur indicateur){
        IndicateurRepository ir=new IndicateurRepository(PERSISTENCE_UNIT);
        try {
            ir.delete(indicateur);
        } catch (SQLException ex) {
            Logger.getLogger(IndicateurCRUD.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void update(Indicateur indicateur){
        IndicateurRepository ir=new IndicateurRepository(PERSISTENCE_UNIT);
        try {
            ir.update(indicateur);
        } catch (SQLException ex) {
            Logger.getLogger(IndicateurCRUD.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
