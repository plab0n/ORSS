/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MODEL;

import org.json.JSONObject;

/**
 *
 * @author plab0n
 */
public interface DB {
    public abstract boolean insert(JSONObject Data);
    public abstract boolean update(JSONObject Data);
    public abstract JSONObject retrieve(String userName);
    public abstract JSONObject retrieve(int resourceID);
    
    
}
