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
public class Praktikum10 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        BangunDatar bd = new BangunDatar("Hitam");
        System.out.println("Warna bangun datar: " + bd.getWarna());
        System.out.println();
        
        BangunDatar lingkaran = new Lingkaran("Merah", 26.0);
        System.out.println("Luas lingkaran: " + lingkaran.luas());
        System.out.println("Keliling lingkaran: " + lingkaran.keliling());
        System.out.println();
        
        BangunDatar segitiga = new SegiTiga("Kuning", 15, 7);
        System.out.println("Luas Segitiga: " + segitiga.luas());
        System.out.println("Keliling Segitiga: " + segitiga.keliling());
        System.out.println();
        
        BangunDatar segiempat = new SegiEmpat("Hijau", 10);
        System.out.println("Luas Segiempat: " + segiempat.luas());
        System.out.println("Keliling Segiempat: " + segiempat.keliling());
        System.out.println();
    }
    
}
