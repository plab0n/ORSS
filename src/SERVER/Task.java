/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SERVER;

import org.json.JSONObject;
import MODEL.*;
/**
 *
 * @author plab0n
 */
public class Task {
    
    public boolean register(JSONObject data){
        user obj = new user();
        return obj.insert(data);
    }
    public JSONObject logIn(String userName){
        user obj = new user();
        return obj.retrieve(userName);
    }
    public boolean shareResource(JSONObject data){
        return new sharedResource().insert(data);
    }
}
