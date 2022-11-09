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
public class Mahasiswa {
    public char huruf_mutu;
    public String nama;
    public String npm;
    double nilaiKuis;
    double nilaiUas;
    double nilaiUts;
    double jumlah;
    
    public void insertNilaiKuis(double nilai){
        nilaiKuis = nilai;
    }
    public void insertNilaiUas(double nilai){
        nilaiUas = nilai;
    }
    public void insertNilaiUts(double nilai){
        nilaiUts = nilai;
    }
    public void dataMhs(){
        System.out.println("Nama : " + nama);
        System.out.println("NPM : " + npm);
        System.out.println("Nilai Kuis : " + nilaiKuis);
        System.out.println("Nilai UAS : " + nilaiUas);
        System.out.println("Nilai UTS : " + nilaiUts);
        System.out.println(nilaiAkhir());
    }
    public String nilaiAkhir(){
        jumlah = (nilaiUas + nilaiUts + nilaiKuis) /3;
            if(jumlah >= 76){
                huruf_mutu = 'A';
                System.out.println("Nilai Akhir : " + jumlah);
                System.out.println("Nilai Mutu : A");
            }else if(jumlah >= 71){
                huruf_mutu = 'B';
                System.out.println("Nilai Akhir : " + jumlah);
                System.out.println("Nilai Mutu : B+");
            }else if(jumlah >= 66){
                huruf_mutu = 'B';
                System.out.println("Nilai Akhir : " + jumlah);
                System.out.println("Nilai Mutu : B");
            }else if(jumlah >= 61){
                huruf_mutu = 'C';
                System.out.println("Nilai Akhir : " + jumlah);
                System.out.println("Nilai Mutu : C+");
            }else if(jumlah >= 56){
                huruf_mutu = 'C';
                System.out.println("Nilai Akhir : " + jumlah);
                System.out.println("Nilai Mutu : C");
            }else if(jumlah >= 51){
                huruf_mutu = 'D';
                System.out.println("Nilai Akhir : " + jumlah);
                System.out.println("Nilai Mutu : D");
            }else{
                huruf_mutu = 'E';
                System.out.println("Nilai Akhir : " + jumlah);
                System.out.println("Nilai Mutu : E");
            }
            return "";
        }
}
