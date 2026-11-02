package com.mycompany.sistempendataanbarangtertinggaldilabkomputasidasar;

public abstract class BarangTertinggal {

    private String namaBarang;
    private String lokasiDitemukan;
    private String tanggalDitemukan;
    private int status;

    public BarangTertinggal(String namaBarang, String lokasiDitemukan,
            String tanggalDitemukan, int status) {
        this.namaBarang = namaBarang;
        this.lokasiDitemukan = lokasiDitemukan;
        this.tanggalDitemukan = tanggalDitemukan;
        this.status = status;
    }

    public String getNamaBarang() {
        return namaBarang;
    }

    public String getLokasiDitemukan() {
        return lokasiDitemukan;
    }

    public String getTanggalDitemukan() {
        return tanggalDitemukan;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public void tampilkanInfo() {
        System.out.println("Nama Barang     : " + namaBarang);
        System.out.println("Lokasi Ditemukan: " + lokasiDitemukan);
        System.out.println("Tanggal Ditemukan: " + tanggalDitemukan);

        if (status == 1) {
            System.out.println("Status          : Belum Diklaim");
        } else {
            System.out.println("Status          : Sudah Dikembalikan");
        }
    }

    public abstract void prosesBarang();
}