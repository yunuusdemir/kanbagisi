/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dbquery;

import com.entity.Login;
import static com.entity.Login_.id;
import com.entity.Register;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.servlet.http.HttpServletRequest;
import org.primefaces.context.RequestContext;


/**
 *
 * @author yemre
 */
public class DataQuery {
    
    EntityManagerFactory emf;
    EntityManager em;
    Login bilgi=new Login();
    Register arama=new Register();
    
     private List<Register> listeler = new ArrayList<>();

    public List<Register> getListeler() {
        listeler = em.createNamedQuery("Register.arabul",Register.class).getResultList();
            
        return listeler;
    }

    

    
    
    public DataQuery() {
        
        emf= Persistence.createEntityManagerFactory("kanbagisiPU");
        em= emf.createEntityManager() ;
        em.getTransaction().begin();
        
        
        
    }
    public boolean loginControl(String username,String password){
        
        try{
            Login l=em.createNamedQuery("Login.control",Login.class).setParameter("username",username).setParameter("password", password).getSingleResult();
            
            if(l!=null){
                
                return true;
            }
        return false;
        }
        catch (Exception e){
            
            return false;
        }
        
    }
    public void bildiri(String x){
    RequestContext.getCurrentInstance().update("bildiri");
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"", x));
        context.getExternalContext().getFlash().setKeepMessages(true);
    }
    
    
    public boolean verigonder(String username,String password){
        try{
    
            Login l=new Login();
    l.setUsername(username); l.setPassword(password);
   
    em.persist(l);
    em.getTransaction().commit();
    bildiri("Üyelik Oluşturuldu."); reload();
    em.flush();
    
        }
        catch(Exception e){
            
            em.getTransaction().rollback();
            
        }
        
        
        System.out.print("İslem Tamamlandi");
        return true;
    }
    public void reload() throws IOException {
            ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
            ec.redirect(((HttpServletRequest) ec.getRequest()).getRequestURI());
}
    public Login AdminBilgileri() {
        bilgi = em.createNamedQuery("Login.findAll",Login.class).getSingleResult();
        return bilgi;
        
    }
    
    public Register aramabilgisi(){
        
        arama=em.createNamedQuery("Register.arabul", Register.class).getSingleResult();
        
        return arama;
    }
    
public void AdminDuzenle(String veri,String password ,int tip) throws IOException  {
        
        if(password.equals(AdminBilgileri().getPassword())){
        if(tip==1)AdminBilgileri().setUsername(veri);
        if(tip==3)AdminBilgileri().setPassword(veri);
        
        bildiri("İşleminiz başarılı.");
        
            em.getTransaction().commit();
             reload();     
        }
        else 
            bildiri("İşleminiz başarısız.Şifreniz yanlış.");
             reload();     
}

Register r1=new Register();
Login l1=new Login();


public boolean bilgiguncelle(String ad,String soyad,String eposta,String telno,String kangrubu, String adres,String sehir){
    
   int b= l1.getId();
   r1.setId(b);
   
   em.createNamedQuery("Register.guncelle",Register.class).setParameter("ad",ad).setParameter("soyad", soyad).setParameter("eposta", eposta).setParameter("telno", telno).setParameter("kangrubu", kangrubu).setParameter("adres", adres).setParameter("sehir", sehir);
   
   bildiri("Veri Güncellendi.");

   return true;

}



}

