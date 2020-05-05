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
public class sharedResource implements DB {
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
        System.out.println("JSONDATA" + Data);
        try{
            
            String query = "INSERT INTO SharedResource(uName,ipAddress,Port,OS,CPU,RAM,HDD,GraphicsCard, hourlyPrice, status, Desc, title, code) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)"; 
            conn = this.connect();
            
            if(conn != null){
                System.out.println("Connected In RS insert");
            }
            
            System.out.println("Code " + Data.getInt("code"));
            pstmt = conn.prepareStatement(query);
            pstmt.setString(1, (String) Data.get("uName"));
            pstmt.setString(2, (String) Data.get("ip"));
            pstmt.setString(3, (String) Data.get("port"));
            pstmt.setString(4, (String) Data.get("OS"));
            pstmt.setString(5, (String) Data.get("CPU"));
            pstmt.setString(6, (String) Data.get("RAM"));
            pstmt.setString(7, (String) Data.get("HDD"));
            pstmt.setString(8, (String) Data.get("GraphicsCard"));
            pstmt.setString(9, (String) Data.get("hourlyPrice"));
            pstmt.setString(10, (String)Data.get("status"));
            pstmt.setString(11, (String) Data.getString("desc"));
            pstmt.setString(12, (String) Data.getString("title"));
            pstmt.setString(13, Integer.toString(Data.getInt("code")));
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
                String query = "UPDATE SharedResource set ipAddress=?,Port=?,OS=?,CPU=?,RAM=?,HDD=?,GraphicsCard=?, hourlyPrice=?, status=?, Desc=? WHERE uName=?";
                pstmt = conn.prepareStatement(query);
                pstmt.setString(1, (String) Data.get("ip"));
                pstmt.setString(2, (String) Data.get("port"));
                pstmt.setString(3, (String) Data.get("OS"));
                pstmt.setString(4, (String) Data.get("CPU"));
                pstmt.setString(5, (String) Data.get("RAM"));
                pstmt.setString(6, (String) Data.get("HDD"));
                pstmt.setString(7, (String) Data.get("GraphicsCard"));
                pstmt.setString(8, (String) Data.get("hourlyPrice"));
                pstmt.setString(9, (String)Data.get("status"));
                pstmt.setString(10, (String) Data.getString("desc"));
                pstmt.setString(11, (String) Data.getString("uName"));
            
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

    /**
     *
     * @param resourceID
     * @return
     */
    public ArrayList<JSONObject> getData() {
            try {
            conn = this.connect();
            if(conn != null){
                System.out.println("Connected to the GETDATA");
                String query = "Select * from SharedResource where status=?";
                pstmt = conn.prepareStatement(query);
                pstmt.setString(1, "ONLINE");
                ResultSet rs = pstmt.executeQuery();
                ArrayList<JSONObject>arr = new ArrayList<JSONObject>();
                while(rs.next()){
                    JSONObject data = new JSONObject();
                    data.put("uname", rs.getString("uName"));
                    data.put("RAM", rs.getString("RAM"));
                    data.put("HDD", rs.getString("HDD"));
                    data.put("OS", rs.getString("OS"));
                    data.put("GraphicsCard", rs.getString("GraphicsCard"));
                    data.put("CPU", rs.getString("CPU"));
                    data.put("hourlyPrice", rs.getString("hourlyPrice"));
                    data.put("status", rs.getString("status"));
                    data.put("desc", rs.getString("Desc"));
                    data.put("title", rs.getString("title"));
                    data.put("code", rs.getString("code"));
                    arr.add(data);
            }
             return arr; 
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(user.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(user.class.getName()).log(Level.SEVERE, null, ex);
        }
        return new ArrayList<JSONObject>();
    }
    
    public static void main(String args[]){
        JSONObject data = new JSONObject();
        data.put("uName", "sajol");
        data.put("RAM", "2GB");
        data.put("HDD", "1TB");
        data.put("OS", "windows10");
        data.put("GraphicsCard", "NVIDIA");
        data.put("CPU", "coreI3");
        data.put("hourlyPrice", "100BDT");
        data.put("status", "online");
        data.put("desc", "This is a system.");
        data.put("ip", "192.168.3.205");
        data.put("port", "6666");
               
       sharedResource sr = new sharedResource();
        /*boolean loc = sr.insert(data);
        if(loc){
            System.out.println("Data INSERTED");
        }
        else {
            System.out.println("Snap!! Debug!! Debug!!");
        }
        JSONObject d = sr.retrieve(1);
        System.out.println(d.getString("uname"));
        System.out.println(d.getString("CPU"));*/
        
        ArrayList<JSONObject>ob = sr.getData();
        String[] res = new String[100];
            int i = 0;
            for(JSONObject o : ob){
                System.out.println(o);
                res[i] = o.toString();
                ++i;
            }
            //} else {
            //}

 
       
    }

    @Override
    public JSONObject retrieve(String userName) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public JSONObject retrieve(int resourceID) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
}
    