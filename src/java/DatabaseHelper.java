
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Viral
 */
public class DatabaseHelper {
    Connection con;
    String driver,url;
    
    public DatabaseHelper(String driver,String url) {
        this.driver = driver;
        this.url = url;
        getConnection();
    }
    
    
     private void getConnection(){
        try {
            Class.forName(driver);
            con = DriverManager.getConnection(url, "root", "");
        } catch (Exception e) {
            System.out.println("Error in connection "+e.getMessage());
        }
    }
     
      public int insertRecord(User u){
        int status = 10;
        try {
            String query = "insert into credentials_tb (username, password) values (?,?)";
            PreparedStatement statement = con.prepareStatement(query);
            statement.setString(1, u.username);
            statement.setString(2, u.password);
            if (statement.executeUpdate() > 0){
            Statement s = con.createStatement();
            query = "select id from credentials_tb where username='"+u.username+"'";
            ResultSet rs =s.executeQuery(query);
            rs.next();
            u.credential_id = rs.getInt("id");
            }
            if(u.credential_id > 0 ){
            query = "insert into user_reistration_tb (name, gender, credential_id) values (?,?,?)";
            PreparedStatement statement1 = con.prepareStatement(query);
            statement1.setString(1, u.name);
            statement1.setString(2, u.gender);
            statement1.setInt(3, u.credential_id);
           return statement1.executeUpdate();
            }
           
        } catch (Exception e) {
            e.printStackTrace();
             System.out.println("Error in insert item "+e.getMessage());
        }
        return status;
    }
}
