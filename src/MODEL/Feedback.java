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
public class Feedback implements DB{
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
            String query = "INSERT INTO Feedback(sender_uName, reciever_uName, message, time_date) VALUES (?,?,?,?)"; 
            conn = this.connect();
            
            if(conn != null){
                System.out.println("Connected");
            }
            
            pstmt = conn.prepareStatement(query);
            pstmt.setString(1, (String) Data.get("sender_uName"));
            pstmt.setString(2, (String) Data.get("reviever_uName"));
            pstmt.setString(3, (String) Data.get("message"));
            pstmt.setString(4, (String) Data.get("time_date"));
       
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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public JSONObject retrieve(String userName) {
        try {
            conn = this.connect();
            if(conn != null){
                String query = "Select * from Feedback where reciever_uName=? order by time_date";
                pstmt = conn.prepareStatement(query);
                pstmt.setString(1, userName);
                ResultSet rs = pstmt.executeQuery();
                JSONObject data = new JSONObject();
                data.put("senderName", rs.getString("sender_uName"));
                data.put("recieverName", rs.getString("recieverName"));
                data.put("msg", rs.getString("message"));
                
                return data;
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(user.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(user.class.getName()).log(Level.SEVERE, null, ex);
        }
        return new JSONObject();
    }
    public ArrayList<JSONObject> getFeed(String userName) {
        ArrayList<JSONObject>arr = new ArrayList<JSONObject>();
        try {
            conn = this.connect();
            if(conn != null){
                String query = "Select * from Feedback where reciever_uName=? order by time_date";
                pstmt = conn.prepareStatement(query);
                pstmt.setString(1, userName);
                ResultSet rs = pstmt.executeQuery();
                while(rs.next()){
                JSONObject data = new JSONObject();
                data.put("senderName", rs.getString("sender_uName"));
                data.put("recieverName", rs.getString("recieverName"));
                data.put("msg", rs.getString("message"));
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

    @Override
    public JSONObject retrieve(int resourceID) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
