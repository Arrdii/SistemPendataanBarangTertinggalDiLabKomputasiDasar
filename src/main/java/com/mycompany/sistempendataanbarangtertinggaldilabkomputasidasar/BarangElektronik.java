package com.mycompany.sistempendataanbarangtertinggaldilabkomputasidasar;

public class BarangElektronik extends BarangTertinggal {

    private String merek;
    private String kondisi;

    public BarangElektronik(String namaBarang, String lokasiDitemukan, String tanggalDitemukan, int status, String merek, String kondisi) {

        super(namaBarang, lokasiDitemukan, tanggalDitemukan, status);

        this.merek = merek;
        this.kondisi = kondisi;
    }

    public String getMerek() {
        return this.merek;
    }

    public String getKondisi() {
        return this.kondisi;
    }

    public void setMerek(String merek) {
        this.merek = merek;
    }

    public void setKondisi(String kondisi) {
        this.kondisi = kondisi;
    }

    @Override
    public void tampilkanInfo() {
        System.out.println("=== Barang Elektronik ===");
        super.tampilkanInfo();
        System.out.println("Merek             : " + this.merek);
        System.out.println("Kondisi           : " + this.kondisi);
    }
}