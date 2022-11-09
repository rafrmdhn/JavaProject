/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package praktikum7;

/**
 *
 * @author Praktikan
 */

public class Praktikum7 {
    public static void main(String[] args) {
        Mahasiswa mhs = new Mahasiswa();
        
        int result = mhs.sumValue(5,8);
        mhs.printData("Ilmu Komputer");
        mhs.hitungNA(1.34,5.4,6.4);
        
        System.out.println(result);
    }
    
}
