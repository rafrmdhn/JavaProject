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
public abstract class BangunDatar implements ViewData {
    protected String warna;
    
    public abstract double luas();
    
    public abstract double keliling();

    public String getWarna() {
        return warna;
    }

    public void setWarna(String warna) {
        this.warna = warna;
    }
}
