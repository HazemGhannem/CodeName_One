/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myapp.services;

import com.codename1.io.CharArrayReader;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.JSONParser;
import com.codename1.io.NetworkEvent;
import com.codename1.io.NetworkManager;
import com.codename1.ui.events.ActionListener;
import com.mycompany.myapp.entities.User;
import com.mycompany.myapp.utils.Statics;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author bhk
 */
public class ServiceTask {

    public ArrayList<User> User;
    
    public static ServiceTask instance=null;
    public boolean resultOK;
    private ConnectionRequest req;

    private ServiceTask() {
         req = new ConnectionRequest();
    }

    public static ServiceTask getInstance() {
        if (instance == null) {
            instance = new ServiceTask();
        }
        return instance;
    }

    public boolean addUsers(User u) {
        System.out.println(u);
        System.out.println("********");
       String url = Statics.BASE_URL + "register?username=" + u.getUsername() + "&email=" + u.getEmail()+"&Telephone=" +u.getTel()+"&password="+u.getPassword();
      // String url = Statics.BASE_URL + "create";
    
       req.setUrl(url);
       
//       req.addArgument("username", u.getUsername());
//       req.addArgument("email", u.getEmail()+"");
       req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                resultOK = req.getResponseCode() == 200; //Code HTTP 200 OK
                req.removeResponseListener(this);
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
        return resultOK;
    }

    public ArrayList<User> parseTasks(String jsonText){
        try {
            User =new ArrayList<>();
            JSONParser j = new JSONParser();
            Map<String,Object> tasksListJson = 
               j.parseJSON(new CharArrayReader(jsonText.toCharArray()));
            
            List<Map<String,Object>> list = (List<Map<String,Object>>)tasksListJson.get("root");
            for(Map<String,Object> obj : list){
                User u = new User();
                float id = Float.parseFloat(obj.get("id").toString());
                u.setId((int)id);
                String email= obj.get("email").toString() ;
                u.setEmail(email);
                u.setPassword((obj.get("password").toString()));
                String Username= obj.get("username").toString() ;
                u.setUsername(Username);
                String tel= obj.get("Telephone").toString() ;
                u.setTel(tel);
//                    String email= obj.get("email").toString() ;
//                    float id = Float.parseFloat(obj.get("id").toString());
//                    String username= obj.get("username").toString() ;
//                    String password= obj.get("password").toString() ;
//                    String tel= obj.get("tel").toString() ;
               
              
                User.add(u);
            }
            
            
        } catch (IOException ex) {
            
        }
        return User;
    }
    
    public ArrayList<User> getAllUser(){
        //String url = Statics.BASE_URL+"/tasks/";
        String url = Statics.BASE_URL+"allusers/";
        req.setUrl(url);
        req.setPost(false);
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                User = parseTasks(new String(req.getResponseData()));
                req.removeResponseListener(this);
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
        return User;
    }
}
