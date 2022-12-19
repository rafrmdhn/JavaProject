package project_uap;

public class Produk{
    private String nama_produk;
    private double harga;
    private int jumlah;
    private double diskon;

    public Produk(String nama_produk, double harga, int jumlah, double diskon) {
        this.nama_produk = nama_produk;
        this.harga = harga;
        this.jumlah = jumlah;
        this.diskon = diskon;
    }

    public Produk(String nama_produk, double harga, int jumlah){
        this.nama_produk = nama_produk;
        this.harga = harga;
        this.jumlah = jumlah;
    }

    public Produk(){
    }

    public String getNama_produk() {
        return nama_produk;
    }

    public void setNama_produk(String nama_produk) {
        this.nama_produk = nama_produk;
    }

    public double getHarga() {
        return harga;
    }

    public void setHarga(double harga) {
        this.harga = harga;
    }

    public int getJumlah() {
        return jumlah;
    }

    public void setJumlah(int jumlah) {
        this.jumlah = jumlah;
    }

    public double getDiskon() {
        return diskon;
    }

    public void setDiskon(double diskon) {
        this.diskon = diskon;
    }

    private double hargaDiskon(){
        return 0;
    }
}