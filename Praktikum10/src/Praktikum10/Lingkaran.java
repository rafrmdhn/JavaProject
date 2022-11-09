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
public class Lingkaran extends BangunDatar {
    private double jari;
    
    public Lingkaran(String warna, double jari){
        super(warna);
        this.jari = jari;
    }
    
    public Lingkaran(){
    }

    @Override
    public double keliling() {
        return Math.PI * this.jari * this.jari; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public double luas() {
        return 2 * Math.PI * this.jari; //To change body of generated methods, choose Tools | Templates.
    }
    
    public double getJari() {
        return jari;
    }

    public void setJari(double jari) {
        this.jari = jari;
    }
    
    
}
