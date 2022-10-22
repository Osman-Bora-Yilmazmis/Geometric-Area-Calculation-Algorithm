package vize;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author fikre
 */
public abstract class GeometrikNesne implements Comparable{
    String etiket;
    Date tarih;
    

    public GeometrikNesne(){//PARAMETRESIZ CONSTRUCTER
        etiket="null";
        tarih= new Date();
    }
    public GeometrikNesne(String etiket, Date tarih){//PARAMETRELI CONSTRUCTER
        this.etiket = etiket;
        this.tarih = tarih;
    }
    public GeometrikNesne(GeometrikNesne other){//COPY CONSTRUCTER
        this.etiket = other.etiket;
        this.tarih = other.tarih;
    }

    /**
     * @return the etiket
     */
    public String getEtiket() {//GET VE SET METODLARI
        return etiket;
    }

    /**
     * @param etiket the etiket to set
     */
    public void setEtiket(String etiket) {
        this.etiket = etiket;
    }

    /**
     * @return the tarih
     */
    public Date getTarih() {
        return tarih;
    }
    

    /**
     * @param tarih the tarih to set
     */
    public void setTarih(Date tarih) {
        this.tarih = tarih;
    }
    
    @Override
    public String toString( ){//TOSTRING METODU
        return("etiket" + etiket + "tarih" + tarih);
    }
    public abstract double alanHesapla();//SOYUT METODLARIN IMZALARI
    
    public abstract double cevreHesapla();//SOYUT METODLARIN IMZALARI
    
    @Override
    public abstract int compareTo(Object other);//SOYUT METODLARIN IMZALARI
    
    public abstract double hacimHesapla();//SOYUT METODLARIN IMZALARI
    





}

