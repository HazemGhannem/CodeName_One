/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myapp.entities;

/**
 *
 * @author Hazem
 */
public class User {
    private  int id ;
    private String username,email,password,Image,tel;
    private String[] Role;
    private boolean isExpired,isVerified;

    public User() {
    }
      public User(String tel, String username, String email, String password) {
        this.tel = tel;
        this.username = username;
        this.email = email;
        this.password = password;
       
    }
    

    public User(String email, String password) {
        this.email = email;
        this.password = password;
    }
    

    public User(int id, String tel, String username, String email, String password) {
        this.id = id;
        this.tel = tel;
        this.username = username;
        this.email = email;
        this.password = password;
    }

    public User(int id, String tel, String username, String email, String password, String Image, String[] Role, boolean isExpired, boolean isVerified) {
        this.id = id;
        this.tel = tel;
        this.username = username;
        this.email = email;
        this.password = password;
        this.Image = Image;
        this.Role = Role;
        this.isExpired = isExpired;
        this.isVerified = isVerified;
    }

  

    public String getImage() {
        return Image;
    }

    public void setImage(String Image) {
        this.Image = Image;
    }

    public String[] getRole() {
        return Role;
    }

    public void setRole(String[] Role) {
        this.Role = Role;
    }

    public boolean isIsExpired() {
        return isExpired;
    }

    public void setIsExpired(boolean isExpired) {
        this.isExpired = isExpired;
    }

    public boolean isIsVerified() {
        return isVerified;
    }

    public void setIsVerified(boolean isVerified) {
        this.isVerified = isVerified;
    }

  
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

 

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" + "id=" + id + ", username=" + username + ", email=" + email + ", password=" + password + ", tel=" + tel + '}';
    }

   

   
    
    
    
}
