/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kontrol;

import com.dbquery.DataQuery;
import com.entity.Login;
import com.entity.Register;
import java.io.IOException;
import java.io.Serializable;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import org.primefaces.context.RequestContext;

 @ManagedBean(name="login")
@SessionScoped
public class giriskontrol implements Serializable{
     
     private static String degisken;

    public static String getDegisken() {
        return degisken;
    }

    public static void setDegisken(String degisken) {
        giriskontrol.degisken = degisken;
    }
    
    
    
     private String username;
    private String password;
    
        DataQuery query=new DataQuery();
       
    public String giriskontrolet(){
       
        if(query.loginControl(username, password)){
            
            return "home.xhtml?faces-redirect=true";
        } 
        
        RequestContext.getCurrentInstance().update("growl");
        FacesContext context= FacesContext.getCurrentInstance();
        
        context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Hata","Kullanıcı Adı veya Şifre hatalı.!!!"));
        
        return "";
        
    }
        public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    public String kayitgonderme(){
        
       if( query.verigonder(username,password)){
       return "login.xhtml?faces-redirect=true";
       }
       
       RequestContext.getCurrentInstance().update("growl");
        FacesContext context= FacesContext.getCurrentInstance();
        
        context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Hata","Üye Kaydı Başarısız!!!"));
        return "";
          
                   
        
    }
    
    public void adminDuzenle(int tip) throws IOException{
      try{
        query.AdminDuzenle(degisken, password, tip);
        
            password=""; degisken="";
            
      }
      
        catch(Exception e)
        {
            RequestContext.getCurrentInstance().update("growl");
            FacesContext context= FacesContext.getCurrentInstance();
            
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Hata","İşlem!!!"));
        }
        
        }
    
    
    }
    

     

