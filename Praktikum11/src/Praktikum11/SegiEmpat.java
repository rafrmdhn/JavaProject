
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
public class SegiEmpat extends BangunDatar {
    private double sisi;
    
    public SegiEmpat(double sisi, String warna){
        this.warna = warna;
        this.sisi = sisi;
    }
    
    public SegiEmpat(){
    }

    @Override
    public double keliling() {
        return 4 * sisi; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public double luas() {
        return sisi * sisi; //To change body of generated methods, choose Tools | Templates.
    }

    public double getSisi() {
        return sisi;
    }

    public void setSisi(double sisi) {
        this.sisi = sisi;
    }
    
    @Override
    public void print(){
        System.out.println("SegiEmpat");
        System.out.println("Warna : " + warna);
        System.out.println("Sisi : " + sisi);
        System.out.println("Luas : " + luas());
        System.out.println("Keliling : " + keliling());
        System.out.println();
    }
}
