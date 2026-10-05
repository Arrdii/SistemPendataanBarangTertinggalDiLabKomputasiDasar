package com.mycompany.sistempendataanbarangtertinggaldilabkomputasidasar;

public class BarangDokumen extends BarangTertinggal {

    private String jenisDokumen;
    private String namaPemilik;

    public BarangDokumen(String namaBarang, String lokasiDitemukan, String tanggalDitemukan, int status, String jenisDokumen, String namaPemilik) {

        super(namaBarang, lokasiDitemukan, tanggalDitemukan, status);

        this.jenisDokumen = jenisDokumen;
        this.namaPemilik = namaPemilik;
    }

    public String getJenisDokumen() {
        return this.jenisDokumen;
    }

    public String getNamaPemilik() {
        return this.namaPemilik;
    }

    public void setJenisDokumen(String jenisDokumen) {
        this.jenisDokumen = jenisDokumen;
    }

    public void setNamaPemilik(String namaPemilik) {
        this.namaPemilik = namaPemilik;
    }

    @Override
    public void tampilkanInfo() {
        System.out.println("=== Barang Dokumen ===");
        super.tampilkanInfo();
        System.out.println("Jenis Dokumen     : " + this.jenisDokumen);
        System.out.println("Nama Pemilik      : " + this.namaPemilik);
    }
}