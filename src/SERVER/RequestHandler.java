/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SERVER;

import MODEL.Activity;
import MODEL.Feedback;
import MODEL.Payment;
import MODEL.sharedResource;
import MODEL.user;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.*;
import SERVER.Task;
import java.util.ArrayList;
/**
 *
 * @author plab0n
 */
public class RequestHandler extends Thread implements Runnable{
    
    
    //MultiThreading
   
    Thread reg = new Thread(new Runnable() {
        public void run(){
            try {
                ServerSocket serv = new ServerSocket(9999);
                while(true){
                    new RequestHandler().initRegSock(9999, serv);
                }
            } catch (IOException ex) {
                Logger.getLogger(RequestHandler.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    });
    
    Thread logIn = new Thread(new Runnable(){
        public void run(){
            ServerSocket serv = null;
            try {
                serv = new ServerSocket(9900);
                while(true){
                new RequestHandler().initLogInSock(serv);
            }
            } catch (IOException ex) {
                Logger.getLogger(RequestHandler.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
    });
    
    Thread Share = new Thread(new Runnable(){
        public void run(){
           ServerSocket serv = null;
            try {
                serv = new ServerSocket(10000);
                while(true){
                    new RequestHandler().initShare(serv);
                }
            } catch (IOException ex) {
                Logger.getLogger(RequestHandler.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    
    });
    
    Thread resource = new Thread(new Runnable(){
        public void run(){
           ServerSocket serv = null;
            try {
                serv = new ServerSocket(10001);
                while(true){
                    new RequestHandler().onlineResource(serv);
                }
            } catch (IOException ex) {
                Logger.getLogger(RequestHandler.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    });
    
    Thread activity = new Thread(new Runnable() {
        public void run(){
            ServerSocket serv = null;
            try {
                serv = new ServerSocket(10002);
                while(true){
                    new RequestHandler().getActivity(serv);
                }
            } catch (IOException ex) {
                Logger.getLogger(RequestHandler.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    });
    
    Thread payemnt = new Thread(new Runnable(){
        public void run(){
            ServerSocket serv = null;
            
            try {
                serv = new ServerSocket(10003);
                while(true){
                    new RequestHandler().getPaymentDetails(serv);
                }
            } catch (IOException ex) {
                Logger.getLogger(RequestHandler.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    });
    
    Thread Feedback = new Thread(new Runnable(){
        public void run(){
            try {
                ServerSocket serv = new ServerSocket(10004);
                while(true){
                    new RequestHandler().feedInsert(serv);
                }
            } catch (IOException ex) {
                Logger.getLogger(RequestHandler.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    });
    
    private void initRegSock(int port, ServerSocket serv){
        try {
            String status = "";
            System.out.println("Waiting for Client...");
            
            Socket ss = serv.accept();
            System.out.println("Connection Established");
            
            BufferedReader br = new BufferedReader(new InputStreamReader(ss.getInputStream()));
            String str = br.readLine();
            
            JSONObject data = new JSONObject(str);
            System.out.println(data);
            if(data.getString("task").equals("registration")){
                Task t = new Task();
                boolean isReg = t.register(data);
                if(isReg){
                    status = "AC";
                }
                else
                    status = "WA";
            } else {
            }
            
            System.out.println(str);
            //  str = "FUcked Up";
            OutputStreamWriter os = new OutputStreamWriter(ss.getOutputStream());
            PrintWriter out = new PrintWriter(os);
            out.println(status);
            os.flush();
        } catch (IOException ex) {
            Logger.getLogger(RequestHandler.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
    private void initLogInSock(ServerSocket serv){
        try {
            String status = "";
            System.out.println("Waiting for Client...");
            Socket ss = serv.accept();
            System.out.println("Connection Established");
            
            BufferedReader br = new BufferedReader(new InputStreamReader(ss.getInputStream()));
            String str = br.readLine();
            System.out.println(str);
            //if(data.getString("task").equals("registration")){
                Task t = new Task();
                JSONObject data = new user().retrieve(str);
                data.toString();
                System.out.println(data);
            //} else {
            //}
            
            System.out.println(str);
            //  str = "FUcked Up";
            OutputStreamWriter os = new OutputStreamWriter(ss.getOutputStream());
            PrintWriter out = new PrintWriter(os);
            out.println(data);
            os.flush();
        } catch (IOException ex) {
            Logger.getLogger(RequestHandler.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
    private void initShare(ServerSocket serv){
           try {
            String status = "";
            System.out.println("Waiting for Client Share Therad...");
            Socket ss = serv.accept();
            System.out.println("Connection Established Share Thread");
            
            BufferedReader br = new BufferedReader(new InputStreamReader(ss.getInputStream()));
            String str = br.readLine();
            System.out.println(str);
            //if(data.getString("task").equals("registration")){
                JSONObject ob = new JSONObject(str);
                System.out.println(ob);
                Task t = new Task();
                boolean loc = new sharedResource().insert(ob);
                if(loc){
                    status = "AC";
                }
                else{
                    status = "WA";
                }
            //} else {
            //}
            
            System.out.println(status);
            //  str = "FUcked Up";
            OutputStreamWriter os = new OutputStreamWriter(ss.getOutputStream());
            PrintWriter out = new PrintWriter(os);
            out.println(status);
            os.flush();
            
        } catch (IOException ex) {
            Logger.getLogger(RequestHandler.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    public void onlineResource(ServerSocket serv){
        try {
            String status = "";
            System.out.println("Waiting for Get Online Resource Therad...");
            Socket ss = serv.accept();
            System.out.println("Connection Established Online Resource Thread");
            
            BufferedReader br = new BufferedReader(new InputStreamReader(ss.getInputStream()));
            String str = br.readLine();
            System.out.println(str);
            
            ArrayList<JSONObject>arr = new sharedResource().getData();
            
            //} else {
            //}
            
            //  str = "FUcked Up";
            OutputStreamWriter os = new OutputStreamWriter(ss.getOutputStream());
            PrintWriter out = new PrintWriter(os);
            out.println(arr.toString());
            os.flush();
            
        } catch (IOException ex) {
            Logger.getLogger(RequestHandler.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
   
    private void getActivity(ServerSocket serv) {
        try {
            String status = "";
            System.out.println("Waiting for Get Activity Therad...");
            Socket ss = serv.accept();
            System.out.println("Connection Established Get Activity Thread");
            
            BufferedReader br = new BufferedReader(new InputStreamReader(ss.getInputStream()));
            String str = br.readLine();
            System.out.println(str);
            JSONObject ob = new JSONObject(str);
            ArrayList<JSONObject>arr;
            if(ob.getString("who").equals("RU")){
                arr = new Activity().userActivity(ob.getString("name"));
            }
            else{
                arr = new Activity().providerActivity(ob.getString("name"));
            }
            
            //} else {
            //}
            
            //  str = "FUcked Up";
            OutputStreamWriter os = new OutputStreamWriter(ss.getOutputStream());
            PrintWriter out = new PrintWriter(os);
            out.println(arr.toString());
            os.flush();
        } catch (IOException ex) {
            Logger.getLogger(RequestHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void getPaymentDetails(ServerSocket serv) {
        try {
            String status = "";
            System.out.println("Waiting for Get Activity Therad...");
            Socket ss = serv.accept();
            System.out.println("Connection Established Get Activity Thread");
            
            BufferedReader br = new BufferedReader(new InputStreamReader(ss.getInputStream()));
            String str = br.readLine();
            System.out.println(str);
            JSONObject ob = new JSONObject(str);
            ArrayList<JSONObject>arr;
            if(ob.getString("who").equals("RU")){
                arr = new Payment().paymentDetailsForUser(ob.getString("name"));
            }
            else{
                arr = new Payment().paymentDetailsForProvider(ob.getString("name"));
            }
            
            
            OutputStreamWriter os = new OutputStreamWriter(ss.getOutputStream());
            PrintWriter out = new PrintWriter(os);
            out.println(arr.toString());
            os.flush();
        } catch (IOException ex) {
            Logger.getLogger(RequestHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
     private void feedInsert(ServerSocket serv) {
        try {
            String status = "";
            System.out.println("Waiting for Client...");
            
            Socket ss = serv.accept();
            System.out.println("Connection Established");
            
            BufferedReader br = new BufferedReader(new InputStreamReader(ss.getInputStream()));
            String str = br.readLine();
            
            JSONObject data = new JSONObject(str);
            boolean loc = new Feedback().insert(data);
            if(loc){
                status = "AC";
            }
            else{
                status = "WA";
            }
            System.out.println(str);
            //  str = "FUcked Up";
            OutputStreamWriter os = new OutputStreamWriter(ss.getOutputStream());
            PrintWriter out = new PrintWriter(os);
            out.println(status);
            os.flush();
        } catch (IOException ex) {
            Logger.getLogger(RequestHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public static void main(String args[]){
        new RequestHandler().reg.start();
        new RequestHandler().logIn.start();
        new RequestHandler().Share.start();
        new RequestHandler().resource.start();
        new RequestHandler().activity.start();
        new RequestHandler().payemnt.start();
    }

   

    

}
