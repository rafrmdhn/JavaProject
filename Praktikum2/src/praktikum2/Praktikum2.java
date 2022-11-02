/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package praktikum2;

import java.util.Scanner;
import javax.swing.J0ptionPane;
import javax.swing.JOptionPane;

/**
 *
 * @author Praktikan
 */
public class Praktikum2 {
    public static void main(String[] sgra){
//        int angka = 5;
//        double angkaDouble = 2.5;
//        float angkaFloat = 2.5f;
//        long angkaLong = 20L;
//        
//        System.out.println(angka);
//        System.out.println(angkaDouble);
//        System.out.println(angkaFloat);
//        System.out.println(angkaLong);
//        
//        char karakter = 'c';
//        String kata = "ilkomp";
//        
//        System.out.println(karakter);
//        System.out.println(kata);
//        
//        boolean kondisi = true;
//        
//        System.out.println(kondisi);
//        
//        double fromInt = angka;
//        int fromDouble = (int) angkaDouble;
//        
//        System.out.println(fromInt);
//        System.out.println(fromDouble);
//        
//        Scanner inputUser= new Scanner(System.in);
//        
//        System.out.print("Tahun angkatan: ");
//        int umur = inputUser.nextInt();
//        inputUser.nextLine();
//        
//        System.out.print("Nama: ");
//        String nama = inputUser.nextLine();
//        
//        System.out.print("Alamat: ");
//        String alamat = inputUser.nextLine();
//        
//        System.out.println("Nama            : " + nama);
//        System.out.println("Tahun angkatan  : " + umur);
//        System.out.println("Alamat          : " + alamat);
//        
        int num1 = 55555;
        int num2 = 55555;
        
        long result = num1 * num2;
        
        System.out.println(result);
        
        String huruf = JOptionPane.showInputDialog("Input nama anda");
        JOptionPane.showMessageDialog(null, "Hello " + huruf);
        String tempat = JOptionPane.showInputDialog("Input alamat anda");
        JOptionPane.showMessageDialog(null, "di " + tempat);
        String tahun = JOptionPane.showInputDialog("Input tahun angkatan anda");
        JOptionPane.showMessageDialog(null,"angkatan " + tahun);
    } 
}


