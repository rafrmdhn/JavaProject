/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Praktikum11;

/**
 *
 * @author Praktikan
 */
public class SegiTiga extends BangunDatar {
    private double alas;
    private double tinggi;
    
    public SegiTiga(double alas, double tinggi, String warna){
        this.warna = warna;
        this.alas = alas;
        this.tinggi = tinggi;
    }
    
    public SegiTiga(){
    }

    @Override
    public double luas() {
        return 0.5 * alas * tinggi;//To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public double keliling() {
        return alas * 3; //To change body of generated methods, choose Tools | Templates.
    }

    public double getAlas() {
        return alas;
    }

    public void setAlas(double alas) {
        this.alas = alas;
    }

    public double getTinggi() {
        return tinggi;
    }

    public void setTinggi(double tinggi) {
        this.tinggi = tinggi;
    }
    
    @Override
    public void print(){
        System.out.println("SegiTiga");
        System.out.println("Warna : " + warna);
        System.out.println("Alas : " + alas);
        System.out.println("Tinggi : " + tinggi);
        System.out.println("Luas : " + luas());
        System.out.println("Keliling : " + keliling());
        System.out.println();
    }
}
