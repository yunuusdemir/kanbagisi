/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kontrol;

import com.dbquery.DataQuery;

import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import com.entity.Login;
import com.entity.Register;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import org.primefaces.context.RequestContext;



@ManagedBean(name="register")
@SessionScoped
public class kayitgonder implements Serializable{
    private Integer id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    private String ad;
    private String soyad;
    private String eposta;
    private String telno;
    private String kangrubu;
    private String adres;
private static String degisken1;
    public static List<Register> getListe() {
        return liste;
    }

    public static void setListe(List<Register> liste) {
        kayitgonder.liste = liste;
    }
    
    private static List<Register> liste = new ArrayList<>();
    DataQuery query=new DataQuery();
   
    
    public String getAd() {
        return ad;
    }

    public void setAd(String ad) {
        this.ad = ad;
    }

    public String getSoyad() {
        return soyad;
    }

    public void setSoyad(String soyad) {
        this.soyad = soyad;
    }

    public String getEposta() {
        return eposta;
    }

    public void setEposta(String eposta) {
        this.eposta = eposta;
    }

    public String getTelno() {
        return telno;
    }

    public void setTelno(String telno) {
        this.telno = telno;
    }

    public String getKangrubu() {
        return kangrubu;
    }

    public void setKangrubu(String kangrubu) {
        this.kangrubu = kangrubu;
    }

    public String getAdres() {
        return adres;
    }

    public void setAdres(String adres) {
        this.adres = adres;
    }

    public String getSehir() {
        return sehir;
    }

    public void setSehir(String sehir) {
        this.sehir = sehir;
    }
    private String sehir;
    
    public List<Register> ara()
    {
        
        try{
    liste = query.getListeler();
    
    return liste;
        }
        catch(Exception e){
       query.bildiri("Hata Oluştu.");
            
        }
        return liste;
    }
    
    public String bilgilendir(){
        
        query.bilgiguncelle(ad, soyad, eposta, telno, kangrubu, adres, sehir);
        return null;
        
    }

    
}
