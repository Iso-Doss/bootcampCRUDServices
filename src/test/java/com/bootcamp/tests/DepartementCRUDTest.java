package com.bootcamp.tests;

import com.bootcamp.constants.AppConstants;
import com.bootcamp.entities.Commune;
import com.bootcamp.entities.Departement;
import com.bootcamp.jpa.DepartementRepository;
import com.bootcamp.service.crud.DepartementCRUD;
import org.testng.annotations.Test;

import javax.persistence.Persistence;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import static com.bootcamp.AppConstants.PERSISTENCE_UNIT;

public class DepartementCRUDTest {
    @Test
    public void generateTables(){

        Persistence.createEntityManagerFactory(AppConstants.PERSISTENCE_UNIT, new Properties() {});
    }
    @Test
    public void createDepartements() throws SQLException {
        Departement dep = new Departement("Zou", 22, 2.066520, 7.346927);

        Commune com1 = new Commune ("Bohicon", 2.0667000, 7.1782600);
        Commune com2 = new Commune ("Abomey", 1.9911900, 7.1828600);
        Commune com3 = new Commune ("Zogbodomey", 2.0999996, 7.083333);

        ArrayList listCommune = new ArrayList();
        listCommune.add(com1);
        listCommune.add(com2);
        listCommune.add(com3);

        dep.setCommuneList(listCommune);

        DepartementCRUD.create(dep);
    }

    @Test
    public void getDepartements() throws SQLException{
        DepartementRepository depRep = new DepartementRepository(PERSISTENCE_UNIT);
        List<Departement> departementList=DepartementCRUD.readAll();
        for(Departement current:departementList)
           System.out.println(current.getNom()+" "+
           current.getNumero()+"\n");
    }



}
