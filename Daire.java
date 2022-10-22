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
public class Daire extends GeometrikNesne {
    
    private double yaricap;
    
    
    public Daire(){//PARAMETRESIZ CONSTRUCTER
    super();
    yaricap = 1.0;
    
    
    }
    
    public Daire(String etiket,double yaricap,Date tarih){//PARAMETRELI CONSTRUCTER
    super(etiket,tarih);
    this.yaricap = yaricap;
    
    
    }
    
    public Daire(Daire other){//COPY CONSTURCTER
        this.yaricap = other.yaricap;
        super.etiket = other.etiket;
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
    
    @Override
     public String toString( ){//TO STRING METODU
        return("  etiket: "+ etiket + " yaricap: " + yaricap +" tarih: "+ tarih);
    }

    @Override
    public double alanHesapla() {//ALAN METODU
        return(Math.PI*getYaricap()*getYaricap()); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public double cevreHesapla() {//CEVRE METODU
        return(Math.PI*2*getYaricap()); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int compareTo(Object other) {
        throw new UnsupportedOperationException("Not supported yet.");   
    }



    @Override
    public double hacimHesapla() {//HACIM METODU
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
    
    
   
}
