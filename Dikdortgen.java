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
public class Dikdortgen extends GeometrikNesne {
    
    private double en;
    private double boy;
    
    public Dikdortgen(){//PARAMETRESIZ CONSTRUCTER
    super();    
    en=1;
    boy=1;
    }
    public Dikdortgen(String etiket,double en , double boy, Date tarih){//PARAMETRELI CONSTRUCTER
    super(etiket , tarih);
    this.en=en;
    this.boy=boy;
    }
    public Dikdortgen(Dikdortgen other){//COPY CONSTRUCTER
    super.etiket = other.etiket;
    this.en=other.en;
    this.boy=other.boy;
    super.tarih = other.tarih;
    
    }

    /**
     * @return the en
     */
    public double getEn() {//GET VE SET METODLARI
        return en;
    }

    /**
     * @param en the en to set
     */
    public void setEn(double en) {//GET VE SET METODLARI
        if(en<0){
            System.out.println("HATALI VERI GIRISI");
        }
        else{
            this.en = en;
        }
    }

    /**
     * @return the boy
     */
    public double getBoy() {//GET VE SET METODLARI
        return boy;
    }

    /**
     * @param boy the boy to set
     */
    public void setBoy(double boy) {//GET VE SET METODLARI
        if(boy<0){
            System.out.println("HATALI VERI GIRISI");
        }
        else{
            this.boy = boy;
        }
    }
    
    @Override
    public String toString( ){//TO STRING METODU
        return("  etiket: "+etiket + " en: " + en + " boy: " + boy + " tarih: "+ tarih );
        
    }

    @Override
    public double alanHesapla() {//ALAN METODU
        return(getEn()*getBoy()); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public double cevreHesapla() {//CEVRE METODU
        return(2*getEn()+2*getBoy()); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int compareTo(Object other) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public double hacimHesapla() {//HACIM METODU 
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
    
}
