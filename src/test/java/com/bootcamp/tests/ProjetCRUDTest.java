/**
 *
 * @Bignon
 */
package com.bootcamp.tests;

import com.bootcamp.entities.Projet;
import com.bootcamp.service.crud.ProjetCRUD;
import java.sql.SQLException;
import java.util.List;
import org.testng.annotations.Test;

public class ProjetCRUDTest {
    
    @Test
    public void create() throws SQLException{
     Projet projet = new Projet();     
     ProjetCRUD.create(projet);
     
     projet.setNom("nom1");
     ProjetCRUD.create(projet);
     
     projet.setNom("nom2");
     projet.setReference("ref1");
     ProjetCRUD.create(projet);
    }
     @Test
     public void update() throws SQLException{
     List<Projet> projets = ProjetCRUD.findByProperty("id", 3);
     
        for (Projet projet : projets) {
         ProjetCRUD.update(projet);
        }
    }
    
    
    public void delete() throws SQLException{
     List<Projet> projets = ProjetCRUD.findByProperty("id", 2);
        for (Projet projet : projets) {
         ProjetCRUD.delete(projet);

        }
    }
    
     @Test
     public void findall() throws SQLException{
     List<Projet> projets = ProjetCRUD.findAll();
    }
}
