/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Praktikum12;

import java.util.ArrayList;

/**
 *
 * @author Praktikan
 */
public class Praktikum12 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
//        ArrayList<String> cars = new ArrayList<String>();
//        cars.add("Volvo");
//        cars.add("BMW");
//        cars.add("Ford");
//        cars.add("Mazda");
//        System.out.println(cars);
        
        ArrayList<Integer> nilai = new ArrayList<Integer>();
//        nilai.add(70);
//        nilai.add(75);
//        nilai.add(80);
        System.out.println(nilai);
        
        Mahasiswa mhs = new Mahasiswa("Rafi", "2117051044", nilai);
        mhs.setNilai(nilai);
        System.out.println("Nilai rata - rata = " + mhs.nilaiRataRata());
    }
    
}
