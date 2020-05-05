/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MODEL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.JSONObject;
import java.sql.ResultSet;
/**
 *
 * @author plab0n
 */
public class user implements DB {
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
            String query = "INSERT INTO userInfo(fName, lName, uName,BankName, AcNo, password, type, email) VALUES (?,?,?,?,?,?,?,?)"; 
            conn = this.connect();
            
            if(conn != null){
                System.out.println("Connected");
            }
            
            pstmt = conn.prepareStatement(query);
            pstmt.setString(1, (String) Data.get("fName"));
            pstmt.setString(2, (String) Data.get("lName"));
            pstmt.setString(3, (String) Data.get("uName"));
            pstmt.setString(4, (String) Data.get("BankName"));
            pstmt.setString(5, (String) Data.get("AcNo"));
            pstmt.setString(6, (String) Data.get("password"));
            pstmt.setString(7, (String) Data.get("type"));
            pstmt.setString(8, (String) Data.get("email"));
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
                String query = "UPDATE userInfo set fName = ?, lName = ?, BankName = ?, AcNo=?, password=? WHERE uName=?";
                pstmt = conn.prepareStatement(query);
                pstmt.setString(1, (String) Data.getString("fName"));
                pstmt.setString(2, (String) Data.getString("lName"));
                pstmt.setString(3, (String) Data.getString("BankName"));
                pstmt.setString(4, (String) Data.getString("AcNo"));
                pstmt.setString(5, (String) Data.getString("password"));
                pstmt.setString(6, (String) Data.getString("uName"));
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
        try {
            System.out.println("IN retrieve " + userName);
            conn = this.connect();
            if(conn != null){
                String query = "Select * from userInfo where uName=?";
                pstmt = conn.prepareStatement(query);
                pstmt.setString(1, userName);
                ResultSet rs = pstmt.executeQuery();
                JSONObject data = new JSONObject();
                int cnt  = 0;
                data.put("fName", rs.getString("fName"));
                data.put("lName", rs.getString("lName"));
                data.put("uName", rs.getString("uName"));
                data.put("BankName", rs.getString("BankName"));
                data.put("AcNo", rs.getString("AcNo"));
                data.put("email", rs.getString("email"));
                data.put("pass", rs.getString("password"));
                data.put("type", rs.getString("type"));
                
                return data;
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(user.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(user.class.getName()).log(Level.SEVERE, null, ex);
        }
        return new JSONObject();
    }
    
    public static void main(String args[]){
        JSONObject obj = new JSONObject();
        obj.put("fName", "Plabon");
        obj.put("lName", "Kumar");
        obj.put("uName", "plab0n");
        obj.put("BankName", "Asia");
        obj.put("AcNo", "123456");
        obj.put("password", "abc123");
        obj.put("type", "RU");
        user doQ = new user();
        boolean loc = doQ.update(obj);
        if(loc){
            System.out.println("Fucking Data Updated");
        }
        else{
            System.out.println("Fuck !!! Debug is required");
        }
        JSONObject obj2 = doQ.retrieve("plab0n");
        System.out.println(obj2.getString("fName") + obj2.getString("lName"));
                
    }

    @Override
    public JSONObject retrieve(int resourceID) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
