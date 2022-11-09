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
public class Mahasiswa {
    private String nama = "Rafi";
    private String npm = "2117051044";
    private double nilaiTugas = 80;
    private double nilaiUas = 90;
    private double nilaiUts = 70;
    private double NA;

    public Mahasiswa() {
        this.nama = nama;
        this.npm = npm;
        this.nilaiTugas = nilaiTugas;
        this.nilaiUas = nilaiUas;
        this.nilaiUts = nilaiUts;
        this.NA = NA;
    }

    public Mahasiswa(String nama, String npm, double nilaiTugas, double nilaiUas, double nilaiUts, double NA) {
        this.nama = nama;
        this.npm = npm;
        this.nilaiTugas = nilaiTugas;
        this.nilaiUas = nilaiUas;
        this.nilaiUts = nilaiUts;
        this.NA = NA;
    }


    
    public void printData(String jurusan){
        System.out.println("NPM\t:" + this.npm);
        System.out.println("Nama\t:" + this.nama);
        System.out.println("Jurusan\t:" + jurusan);
        System.out.println("Nilai Akhir\t:" + NA);
    }
    
    public int sumValue(int x, int y){
        return x + y;
    }
    
    public void hitungNA(){
        this.NA = (this.nilaiTugas*0.3) + (this.nilaiUas*0.35) + (this.nilaiUas*0.35);
    }
    
    public void hitungNA(double nilaiTugas, double nilaiUas, double nialiUts){
        this.NA = (this.nilaiTugas*0.3) + (this.nilaiUas*0.35) + (this.nilaiUas*0.35);
    }
    
    public void hitungNA(String pesan){
        System.out.println("Nilai tidak valid");
    }
}


