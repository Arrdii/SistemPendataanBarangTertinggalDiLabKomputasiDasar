package com.mycompany.sistempendataanbarangtertinggaldilabkomputasidasar;

public class BarangTertinggal {

    private String namaBarang;
    private String lokasiDitemukan;
    private String tanggalDitemukan;
    private int status;

    private static int jumlahBarang = 0;

    public BarangTertinggal(String namaBarang, String lokasiDitemukan, String tanggalDitemukan, int status) {

        this.namaBarang = namaBarang;
        this.lokasiDitemukan = lokasiDitemukan;
        this.tanggalDitemukan = tanggalDitemukan;
        this.setStatus(status);

        jumlahBarang++;
    }

    public String getNamaBarang() {
        return this.namaBarang;
    }

    public String getLokasiDitemukan() {
        return this.lokasiDitemukan;
    }

    public String getTanggalDitemukan() {
        return this.tanggalDitemukan;
    }

    public int getStatus() {
        return this.status;
    }

    public void setNamaBarang(String namaBarang) {
        this.namaBarang = namaBarang;
    }

    public void setLokasiDitemukan(String lokasiDitemukan) {
        this.lokasiDitemukan = lokasiDitemukan;
    }

    public void setTanggalDitemukan(String tanggalDitemukan) {
        this.tanggalDitemukan = tanggalDitemukan;
    }

    public void setStatus(int status) {
        if (status == 1 || status == 2) {
            this.status = status;
        } else {
            this.status = 1;
        }
    }

    public static int getJumlahBarang() {
        return jumlahBarang;
    }

    public void tampilkanInfo() {
        System.out.println("Nama Barang       : " + this.namaBarang);
        System.out.println("Lokasi Ditemukan  : " + this.lokasiDitemukan);
        System.out.println("Tanggal Ditemukan : " + this.tanggalDitemukan);

        if (this.status == 1) {
            System.out.println("Status            : Belum Diklaim");
        } else {
            System.out.println("Status            : Sudah Dikembalikan");
        }
    }
}