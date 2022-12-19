package project_uap;

import java.util.ArrayList;

public class Barang extends Produk{
    private String barcode;
    private String expired;
    private String kategori;
    private ArrayList<Kategori> Kategori = new ArrayList<Kategori>();
    
    public Barang(String nama_produk, double harga, int jumlah, double diskon ,String barcode, String expired, String kategori) {
        super(nama_produk, harga, jumlah, diskon);
        this.barcode = barcode;
        this.expired = expired;
        this.kategori = kategori;
    }
    
    public Barang(String nama_produk, double harga, int jumlah, String barcode, String expired, String kategori) {
        super(nama_produk, harga, jumlah);
        this.barcode = barcode;
        this.expired = expired;
        this.kategori = kategori;
    }

    public Barang(String barcode){
        this.barcode = barcode;
    }

    public Barang(){
    }
    
    public String getBarcode() {
        return barcode;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }

    public String getExpired() {
        return expired;
    }

    public void setExpired(String expired) {
        this.expired = expired;
    }

    public boolean isExpired(){
        return true;
    }

    public String getKategori(){
        return kategori;
    }

    public void setKategori(String kategori) {
        this.kategori = kategori;
    }
}