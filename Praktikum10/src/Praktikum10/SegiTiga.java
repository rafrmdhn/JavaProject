/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Praktikum10;

/**
 *
 * @author Praktikan
 */
public class SegiTiga extends BangunDatar {
    private double alas;
    private double tinggi;
    
    public SegiTiga(String warna, double alas, double tinggi){
        super(warna);
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
}
