/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vize;

/**
 *
 * @author fikre
 */
public class Silindir extends GeometrikNesne {
    private double yaricap;
    private double uzunluk;
    
    public Silindir(){//PARAMETRESIZ CONSTRUCTERLAR
        super();
        yaricap=1;
        uzunluk=1;
    }
    
    public Silindir(String etiket,double yaricap, double uzunluk,Date tarih){//PARAMETRELI CONSTRUCTERLAR
        super(etiket,tarih);
        this.yaricap=yaricap;
        this.uzunluk=uzunluk;
    }
    
    public Silindir(Silindir other){//COPY CONSTRUCTERLAR
        super.etiket = other.etiket;
        this.yaricap=other.yaricap;
        this.uzunluk=other.uzunluk;
        super.tarih = other.tarih;
    }

    /**
     * @return the yaricap
     */
    public double getYaricap() {//GET VE SET METODLARI
        return yaricap;
    }

    /**
     * @param yaricap the yaricap to set
     */
    public void setYaricap(double yaricap) {//GET VE SET METODLARI
        if(yaricap<0){
            System.out.println("HATALI VERI GIRISI");
        }
        else{
            this.yaricap = yaricap;
        }
        
    }

    /**
     * @return the uzunluk
     */
    public double getUzunluk() {//GET VE SET METODLARI
        return uzunluk;
        
    }

    /**
     * @param uzunluk the uzunluk to set
     */
    public void setUzunluk(double uzunluk) {//GET VE SET METODLARI
        if(uzunluk<0){
            System.out.println("HATALI VERI GIRISI");
        }
        else{
            this.uzunluk = uzunluk;
        }
    }
    
    @Override
    public String toString( ){//TO STRING METODU
        return("  etiket: "+etiket +" yaricap: " + yaricap + " uzunluk: " + uzunluk+ " tarih: "+ tarih);
    }
    
    @Override
    public double hacimHesapla(){//HACIM METODU
        return(Math.PI * getYaricap()* getYaricap()* getUzunluk());
    
    }
    
    @Override
    public double alanHesapla() {//ALAN METODU
        return(2* Math.PI * getYaricap() * (getYaricap() + getUzunluk())); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public double cevreHesapla() {//CEVRE METODU
        return((2 * 2 * getYaricap()* Math.PI)+(2*getUzunluk())); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int compareTo(Object other) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
    
    
        
     
    
    
}
