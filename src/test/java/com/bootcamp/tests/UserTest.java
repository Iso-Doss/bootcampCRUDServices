/**
 *
 * @Bignon
 */
package com.bootcamp.tests;

import com.bootcamp.entities.User;
import com.bootcamp.service.crud.UserCRUD;
import java.sql.SQLException;
import java.util.List;
import org.testng.annotations.Test;

public class UserTest {
    
    @Test
    public void create() throws SQLException{
     User user = new User();         
     user.setLogin("user0");
     user.setPwd("pass0");
     UserCRUD.create(user);
     
     User user1 = new User();
     user.setLogin("user1");
     user.setPwd("pass1");
     UserCRUD.create(user1);
     
     User user2 = new User();
     user.setLogin("user3");
     user.setPwd("pass3");
     UserCRUD.create(user2);
    }
     //@Test
     public void update() throws SQLException{
         
     User user = UserCRUD.findByPropertyUnique("id", 3);
     
         UserCRUD.update(user);
    }
    
    
    public void delete() throws SQLException{
          User user = UserCRUD. findByPropertyUnique("id", 2);
         UserCRUD.delete(user);
    }
    
     @Test
     public void findall() throws SQLException{
     List<User> users = UserCRUD.findAll();
    }
}
