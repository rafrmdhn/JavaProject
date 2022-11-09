/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Praktikum9;


/**
 *
 * @author Praktikan
 */
public class Praktikum9 {
    public String atributBukanStatic = "Atribut Bukan Static";
    static String atributStatic = "Atribut Static";
    
    public void bukanStatic(){
        System.out.println("Bukan Static");
    }
    static void methodStatic(){
        System.out.println("Method Static");
    }
    public static class Tabung {
        private static final double phi = 3.14;
        
        public static double Volume(double jari, double tinggi){
            double volume = phi * jari * jari * tinggi;
            return volume;
        }
        
        public static double LuasPermukaan(double jari, double tinggi){
            double luasPermukaan = 2 * phi * jari * (jari + tinggi);
            return luasPermukaan;
        }
    }
    

    public static void main(String[] args) {
        Praktikum praktikum = new Praktikum();
        System.out.println(praktikum.atributBukanStatic);
        System.out.println(atributStatic);
        praktikum.bukanStatic();
        methodStatic();
        
        double r = 13;
        double t = 30;
        double vol = Tabung.Volume(r, t);
        double lp = Tabung.LuasPermukaan(r, t);
        
        System.out.println(vol);
        System.out.println(lp);
    }    
}
