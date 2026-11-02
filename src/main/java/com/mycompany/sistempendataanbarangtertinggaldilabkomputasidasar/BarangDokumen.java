package com.mycompany.sistempendataanbarangtertinggaldilabkomputasidasar;

public class BarangDokumen extends BarangTertinggal
        implements DapatDiverifikasi {

    private String jenisDokumen;
    private String namaPemilik;

    public BarangDokumen(String namaBarang, String lokasiDitemukan,
            String tanggalDitemukan, int status,
            String jenisDokumen, String namaPemilik) {

        super(namaBarang, lokasiDitemukan, tanggalDitemukan, status);
        this.jenisDokumen = jenisDokumen;
        this.namaPemilik = namaPemilik;
    }

    @Override
    public void tampilkanInfo() {
        super.tampilkanInfo();
        System.out.println("Jenis Dokumen   : " + jenisDokumen);
        System.out.println("Nama Pemilik    : " + namaPemilik);
    }

    @Override
    public void prosesBarang() {
        System.out.println("Memproses barang dokumen.");
    }

    @Override
    public void verifikasiBarang() {
        System.out.println("Dokumen berhasil diverifikasi.");
    }
}