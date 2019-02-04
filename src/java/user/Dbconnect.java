package user;


import user.UserServlet;
import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author hmz4ever
 */
public class Dbconnect {
    public Connection connect ()  {
        try {
               Class.forName("com.mysql.jdbc.Driver");
               Connection con =  (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/webapp", "root", "root");
               return con;
              }catch( ClassNotFoundException cex) {}
                catch (SQLException sqlex) {  java.util.logging.Logger.getLogger(UserServlet.class.getName()).log(Level.SEVERE, null, sqlex); }
        return null;
    }
    
}
