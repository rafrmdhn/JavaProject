/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Praktikum15;

/**
 *
 * @author Praktikan
 */
public class Mahasiswa {
    private String Nama;
    private String Npm;
    private String Alamat;

    public Mahasiswa(String Npm, String Nama, String Alamat) {
        this.Nama = Nama;
        this.Npm = Npm;
        this.Alamat = Alamat;
    }
    
    public String getNama() {
        return Nama;
    }

    public void setNama(String Nama) {
        this.Nama = Nama;
    }

    public String getNpm() {
        return Npm;
    }

    public void setNpm(String NPM) {
        this.Npm = NPM;
    }

    public String getAlamat() {
        return Alamat;
    }

    public void setAlamat(String Alamat) {
        this.Alamat = Alamat;
    }    
}
