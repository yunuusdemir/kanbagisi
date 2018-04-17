/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author yemre
 */
@Entity
@Table(name = "register")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name="Register.guncelle", query="UPDATE Register SET ad= :ad , soyad= :soyad , eposta= :eposta , telno= :telno , kangrubu :kangrubu , adres= :adres , sehir = :sehir WHERE id= :id"),
    @NamedQuery(name ="Register.arabul", query="SELECT r FROM Register r WHERE r.sehir= :sehir and r.kangrubu= :kangrubu"),
    @NamedQuery(name = "Register.findAll", query = "SELECT r FROM Register r")
    , @NamedQuery(name = "Register.findById", query = "SELECT r FROM Register r WHERE r.id = :id")
    , @NamedQuery(name = "Register.findByAd", query = "SELECT r FROM Register r WHERE r.ad = :ad")
    , @NamedQuery(name = "Register.findBySoyad", query = "SELECT r FROM Register r WHERE r.soyad = :soyad")
    , @NamedQuery(name = "Register.findByEposta", query = "SELECT r FROM Register r WHERE r.eposta = :eposta")
    , @NamedQuery(name = "Register.findByTelno", query = "SELECT r FROM Register r WHERE r.telno = :telno")
    , @NamedQuery(name = "Register.findByKangrubu", query = "SELECT r FROM Register r WHERE r.kangrubu = :kangrubu")
    , @NamedQuery(name = "Register.findByAdres", query = "SELECT r FROM Register r WHERE r.adres = :adres")
    , @NamedQuery(name = "Register.findBySehir", query = "SELECT r FROM Register r WHERE r.sehir = :sehir")})

public class Register implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "ad")
    private String ad;
    @Basic(optional = false)
    @Column(name = "soyad")
    private String soyad;
    @Basic(optional = false)
    @Column(name = "eposta")
    private String eposta;
    @Basic(optional = false)
    @Column(name = "telno")
    private String telno;
    @Basic(optional = false)
    @Column(name = "kangrubu")
    private String kangrubu;
    @Basic(optional = false)
    @Column(name = "adres")
    private String adres;
    @Basic(optional = false)
    @Column(name = "sehir")
    private String sehir;

    public Register() {
    }

    public Register(Integer id) {
        this.id = id;
    }

    public Register(Integer id, String ad, String soyad, String eposta, String telno, String kangrubu, String adres, String sehir) {
        this.id = id;
        this.ad = ad;
        this.soyad = soyad;
        this.eposta = eposta;
        this.telno = telno;
        this.kangrubu = kangrubu;
        this.adres = adres;
        this.sehir = sehir;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Register)) {
            return false;
        }
        Register other = (Register) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.entity.Register[ id=" + id + " ]";
    }
    
}
