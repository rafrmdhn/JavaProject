/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package praktikum6;

/**
 *
 * @author Praktikan
 */
public class Praktikum6 {
    public static void main(String[] sgra){
        Mahasiswa mhs1 = new Mahasiswa();
        
        mhs1.nama = "Rafi Ramadhan";
        mhs1.npm = "2117051044";
        
        mhs1.insertNilaiKuis(80);
        mhs1.insertNilaiUas(75);
        mhs1.insertNilaiUts(70);
        
        mhs1.dataMhs();
    }
}
