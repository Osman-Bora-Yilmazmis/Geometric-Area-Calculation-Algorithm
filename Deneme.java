/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vize;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author fikre
 */
public class Deneme {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner fileIn = null; 
        try{
        fileIn = new Scanner(new FileInputStream("input.txt")); //OKUNACAK DOSYAMIZ
        }
        catch (FileNotFoundException e)//KONTROL EDİLİR
        {
            System.out.println("File not found.");
            System.exit(0);
        }
        //WHILE DONGUSUNDEKI ISLEMLERI GERCEKLESTİRMEK ICIN GEREKLEI DEGISKENLER BURADA BULUNUR        
        int toplamsekilsayisi=0;
        int toplamsilindirsayisi = 0;
        String etiket=null;
        String etiket1=null;
        String etiket2=null;
        double toplamcevre = 0; 
        double toplamalan =0;
        double toplamhacim =0;
        double en=0;
        double boy=0;
        double yaricapsilindir=0;
        Date tarih1=null;
        double uzunluk=0;
        double yaricap = 0;
        Date tarih = null;
        
        List<Double> cevrelistesi = new ArrayList<>();//BUTUN SEKILLERIN CEVRELERI BU LISTEDE TOPLANIR
        List<Double> alanlistesi = new ArrayList<>();//BUTUN SEKILLERIN ALANLARI BU LISTEDE TOPLANIR
        List<Double> hacimlistesi = new ArrayList<>();//SILINDIRLERIN HACIMLERI BU LISTEDE BULUNUR 
        List<GeometrikNesne> tumsekillerinlistesi = new ArrayList<>();//BUTUN SEKILLER VERILERIYLE BERABER BU LISTEDE TOPLANIR
     
        while (fileIn.hasNext()){//TEXTTEKI SEKILE GORE IF BLOGUNA YONLENDIRIR VE ISLEMLER YAPILIR
            String kontrol= fileIn.next();
            
            if("daire".equals(kontrol)){//DAİRE SEKLININ TEXT VERILERININ ATANMASI
                toplamsekilsayisi++;
             
                etiket = fileIn.next(); 
                String a =fileIn.next();               
                yaricap = Double.parseDouble(a);
                fileIn.next(); //BURADAKI KOMUT TEXT DOSYASINDAKI DATE YAZISININ ATLANMASI ICIN YAZILMISTIR
                tarih= new Date(fileIn.nextInt(),fileIn.nextInt(),fileIn.nextInt());    
                GeometrikNesne daire1 =  new Daire(etiket,yaricap,tarih);
                double alandaire=daire1.alanHesapla();
                double cevredaire= daire1.cevreHesapla();
                toplamcevre += cevredaire;
                toplamalan += alandaire;
                cevrelistesi.add(cevredaire);
                alanlistesi.add(alandaire);
                tumsekillerinlistesi.add(daire1);
            }
            
            else if("dikdortgen".equals(kontrol)){//DIKDORTGEN SEKLININ TEXT VERILERININ ATANMASI
                toplamsekilsayisi++;
                
                etiket1 = fileIn.next();
                String b =fileIn.next();               
                en = Double.parseDouble(b);
                String c =fileIn.next();               
                boy = Double.parseDouble(c);
                fileIn.next();//BURADAKI KOMUT TEXT DOSYASINDAKI DATE YAZISININ ATLANMASI ICIN YAZILMISTIR
                tarih1= new Date(fileIn.nextInt(),fileIn.nextInt(),fileIn.nextInt());      
                GeometrikNesne dikdortgen1 =  new Dikdortgen(etiket1,en,boy,tarih1);
                double alandikdortgen=dikdortgen1.alanHesapla();
                double cevredikdortgen=dikdortgen1.cevreHesapla();
                toplamcevre+= cevredikdortgen;
                toplamalan+= alandikdortgen;
                cevrelistesi.add(cevredikdortgen);
                alanlistesi.add(alandikdortgen);
                tumsekillerinlistesi.add(dikdortgen1);
            }
            
            else if("silindir".equals(kontrol)){//SILINDIR SEKLININ TEXT VERILERININ ATANMASI
                toplamsekilsayisi++;
                toplamsilindirsayisi++;
                
                etiket2 = fileIn.next();
                String d =fileIn.next();               
                yaricapsilindir= Double.parseDouble(d);
                String e =fileIn.next();               
                uzunluk= Double.parseDouble(e);
                fileIn.next();//BURADAKI KOMUT TEXT DOSYASINDAKI DATE YAZISININ ATLANMASI ICIN YAZILMISTIR
                Date tarih2= new Date(fileIn.nextInt(),fileIn.nextInt(),fileIn.nextInt());    
                GeometrikNesne silindir1 =  new Silindir(etiket2,yaricapsilindir,uzunluk,tarih2);
                double alansilindir=silindir1.alanHesapla();
                double cevresilindir=silindir1.cevreHesapla();
                double hacimsilindir=silindir1.hacimHesapla();
                toplamcevre+=cevresilindir;
                toplamalan+=alansilindir;
                toplamhacim+=hacimsilindir;
                cevrelistesi.add(cevresilindir);
                alanlistesi.add(alansilindir);
                hacimlistesi.add(hacimsilindir);
                tumsekillerinlistesi.add(silindir1);
            }
             
        }
        //BURADA SON EKLENEN SEKİLLER KLONLANIR VE TUM SEKİLLERİN LİSTESININ İCİNE GONDERİLİR
        GeometrikNesne clonedaire = new Daire(etiket,yaricap,tarih);
        GeometrikNesne clonedikdortgen = new Dikdortgen(etiket1,en,boy,tarih1);
        GeometrikNesne clonesilindir = new Silindir(etiket2,yaricapsilindir,uzunluk,tarih);
        tumsekillerinlistesi.add(clonedaire);
        tumsekillerinlistesi.add(clonedikdortgen);
        tumsekillerinlistesi.add(clonesilindir);
        System.out.println("TEXT DOSYAMIZDA KULLANILAN VE KLONLANIP SONRADAN EKLENEN SEKILLERIN LISTESI:");
        System.out.println(tumsekillerinlistesi);
        
        //DEGERLERE ATAMALAR YAPILIR VE ORTALAMA DEGERLER HESAPLANIR
        double ortalamacevre = toplamcevre/toplamsekilsayisi;
        double ortalamaalan = toplamalan/toplamsekilsayisi;
        double ortalamahacim = toplamhacim/toplamsilindirsayisi;
        double maxcevre = Collections.max(cevrelistesi);
        double mincevre = Collections.min(cevrelistesi);
        double maxalan= Collections.max(alanlistesi);
        double minalan= Collections.min(alanlistesi);
        double maxhacim = Collections.max(hacimlistesi);
        double minhacim = Collections.min(hacimlistesi);
       
        System.out.println();//BU BOLUM ORTALAMA VE MAX MIN CIKTILARININ OLUSTUGU BOLUMDUR
        System.out.println("Ortalama cevre: "+ortalamacevre);
        System.out.println("Ortalama alan: "+ortalamaalan);
        System.out.println("Ortalama hacim: "+ortalamahacim);
        System.out.println("Maximum cevre: "+maxcevre);
        System.out.println("Minimum cevre: "+mincevre);
        System.out.println("Maximum alan: "+maxalan);
        System.out.println("Minimum alan: "+minalan);
        System.out.println("Maximum hacim: "+maxhacim);
        System.out.println("Minimum hacim: "+minhacim);
        
        
        
    
    }
            
}
