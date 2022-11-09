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
public class Praktikum11 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        BangunDatar lingkaran = new Lingkaran(10, "Merah");
        BangunDatar segitiga  = new SegiTiga(13, 5, "Biru");
        BangunDatar segiempat = new SegiEmpat(5, "Hitam");
        
        BangunDatar[] bangundatar = new BangunDatar[3];
        bangundatar[0] = lingkaran;
        bangundatar[1] = segitiga;
        bangundatar[2] = segiempat; 
        
        for(int i = 0; i < 3; i++){
//            System.out.println("Bangun Datar " + (i + 1));
//            System.out.println("Warna : " + bangundatar[i].getWarna());
//            System.out.println("Luas : " + bangundatar[i].luas());
//            System.out.println("Keliling : " + bangundatar[i].keliling());
//            System.out.println();
            bangundatar[i].print();
        }
    }   
    
}
