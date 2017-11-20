/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bootcamp.service.crud;

import static com.bootcamp.constants.AppConstants.PERSISTENCE_UNIT;
import com.bootcamp.entities.Livrable;
import com.bootcamp.jpa.LivrableRepository;
import java.sql.SQLException;

/**
 *
 * @author leger
 */
public class LivrableCRUD {
    
    public static void create(Livrable livrable) throws SQLException{
        LivrableRepository lr = new LivrableRepository(PERSISTENCE_UNIT);
        lr.create(livrable);
    }
    
    public static void update(Livrable livrable) throws SQLException{
        LivrableRepository lr = new LivrableRepository(PERSISTENCE_UNIT);
        lr.update(livrable);
    }
    
    public static void delete(Livrable livrable) throws SQLException{
        LivrableRepository lr = new LivrableRepository(PERSISTENCE_UNIT);
        lr.delete(livrable);
    }

}
