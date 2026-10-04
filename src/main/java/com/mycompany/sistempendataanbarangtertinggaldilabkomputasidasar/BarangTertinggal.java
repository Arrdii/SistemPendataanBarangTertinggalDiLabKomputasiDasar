package com.mycompany.sistempendataanbarangtertinggaldilabkomputasidasar;

public class BarangTertinggal {

    private String namaBarang;
    private String lokasiDitemukan;
    private String tanggalDitemukan;
    private String status;

    private static int jumlahBarang = 0;

    public BarangTertinggal(String namaBarang, String lokasiDitemukan, String tanggalDitemukan, String status) {

        this.namaBarang = namaBarang;
        this.lokasiDitemukan = lokasiDitemukan;
        this.tanggalDitemukan =tanggalDitemukan;
        this.status = status;

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

    public String getStatus() {
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

    public void setStatus(String status) {

        if (status.equalsIgnoreCase("Belum Diklaim")) {
            this.status = "Belum Diklaim";

        } else if (status.equalsIgnoreCase("Sudah Dikembalikan")) {
            this.status = "Sudah Dikembalikan";

        } else {
            this.status = "Belum Diklaim";
        }
    }

    public static int getJumlahBarang() {
        return jumlahBarang;
    }

    public void tampilkanInfo() {

        System.out.println("Nama Barang       : " + this.namaBarang);
        System.out.println("Lokasi Ditemukan  : " + this.lokasiDitemukan);
        System.out.println("Tanggal Ditemukan : " + this.tanggalDitemukan);
        System.out.println("Status            : " + this.status);
    }
}