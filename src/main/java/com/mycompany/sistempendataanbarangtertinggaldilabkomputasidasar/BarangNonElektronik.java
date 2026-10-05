package com.mycompany.sistempendataanbarangtertinggaldilabkomputasidasar;

public class BarangNonElektronik extends BarangTertinggal {

    private String warna;
    private String jenisBarang;

    public BarangNonElektronik(String namaBarang, String lokasiDitemukan, String tanggalDitemukan, int status, String warna, String jenisBarang) {

        super(namaBarang, lokasiDitemukan, tanggalDitemukan, status);

        this.warna = warna;
        this.jenisBarang = jenisBarang;
    }

    public String getWarna() {
        return this.warna;
    }

    public String getJenisBarang() {
        return this.jenisBarang;
    }

    public void setWarna(String warna) {
        this.warna = warna;
    }

    public void setJenisBarang(String jenisBarang) {
        this.jenisBarang = jenisBarang;
    }

    @Override
    public void tampilkanInfo() {
        System.out.println("=== Barang Non-Elektronik ===");
        super.tampilkanInfo();
        System.out.println("Warna             : " + this.warna);
        System.out.println("Jenis Barang      : " + this.jenisBarang);
    }
}