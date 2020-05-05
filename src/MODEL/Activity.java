/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MODEL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.JSONObject;

/**
 *
 * @author plab0n
 */
public class Activity implements DB{
    private String url = "jdbc:sqlite:/home/plab0n/sqlite3/ORSS_DB";
    private Connection conn;
    private PreparedStatement pstmt;
    
    private Connection connect() throws ClassNotFoundException {
        Class.forName("org.sqlite.JDBC");

        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }
    
    
    @Override
    public boolean insert(JSONObject Data) {
        try{
            String query = "INSERT INTO Activity(User_Name, Provider_Name, startTimeDate) VALUES (?,?,?)"; 
            conn = this.connect();
            
            if(conn != null){
                System.out.println("Connected");
            }
            
            pstmt = conn.prepareStatement(query);
            pstmt.setString(1, (String) Data.get("userName"));
            pstmt.setString(2, (String) Data.get("providerName"));
            pstmt.setString(3, (String) Data.get("TimeDate"));
            int val = pstmt.executeUpdate();
            System.out.println(val);
        }catch(Exception e){
            System.out.println(e);
            return false;
        }
        return true;
        
    }

    @Override
    public boolean update(JSONObject Data) {
        try{
            conn = this.connect();
            if(conn != null){
                String query = "UPDATE Activity set endTimeDate = ?";
                pstmt = conn.prepareStatement(query);
                pstmt.setString(1, (String) Data.getString("endTimeDate"));
                
                pstmt.executeUpdate();
                System.out.println(pstmt);
                return true;
            }
            else return false;
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(user.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } catch (SQLException ex) {
            Logger.getLogger(user.class.getName()).log(Level.SEVERE, null, ex);
        }
        return true;

    }

    @Override
    public JSONObject retrieve(String userName) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public JSONObject retrieve(int resourceID) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    public ArrayList<JSONObject> userActivity(String userName){
        ArrayList<JSONObject>arr = new ArrayList<JSONObject>();
        try {
            conn = this.connect();
            

            if(conn != null){
                String query = "Select * from Activity where User_Name=? ORDER BY startTimeDate DESC";
                pstmt = conn.prepareStatement(query);
                pstmt.setString(1, userName);
                ResultSet rs = pstmt.executeQuery();
                while(rs.next()){
                JSONObject data = new JSONObject();
                    data.put("User_Name", rs.getString("User_Name"));
                    data.put("Provider_Name", rs.getString("Provider_Name"));
                    data.put("startTimeDate", rs.getString("startTimeDate"));
                    data.put("endTimeDate", rs.getString("endTimeDate"));
                    arr.add(data);
                }
                return arr;
            }
           
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(user.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(user.class.getName()).log(Level.SEVERE, null, ex);
        }
        return arr;
    }
    
    public ArrayList<JSONObject> providerActivity(String userName){
        ArrayList<JSONObject>arr = new ArrayList<JSONObject>();
        try {
            conn = this.connect();
            if(conn != null){
                String query = "Select * from Activity where Provider_Name=?";
                pstmt = conn.prepareStatement(query);
                pstmt.setString(1, userName);
                ResultSet rs = pstmt.executeQuery();
                while(rs.next()){
                JSONObject data = new JSONObject();
                data.put("User_Name", rs.getString("User_Name"));
                data.put("Provider_Name", rs.getString("Provider_Name"));
                data.put("startTimeDate", rs.getString("startTimeDate"));
                data.put("endTimeDate", rs.getString("endTimeDate"));
                arr.add(data);
                }
                
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(user.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(user.class.getName()).log(Level.SEVERE, null, ex);
        }
        return arr;
    }
    
}
