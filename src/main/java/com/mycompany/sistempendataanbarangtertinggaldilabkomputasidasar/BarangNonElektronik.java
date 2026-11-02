package com.mycompany.sistempendataanbarangtertinggaldilabkomputasidasar;

public class BarangNonElektronik extends BarangTertinggal
        implements DapatDikembalikan, DapatDiverifikasi {

    private String warna;
    private String jenisBarang;

    public BarangNonElektronik(String namaBarang, String lokasiDitemukan,
            String tanggalDitemukan, int status, String warna, String jenisBarang) {

        super(namaBarang, lokasiDitemukan, tanggalDitemukan, status);
        this.warna = warna;
        this.jenisBarang = jenisBarang;
    }

    @Override
    public void tampilkanInfo() {
        super.tampilkanInfo();
        System.out.println("Warna           : " + warna);
        System.out.println("Jenis Barang    : " + jenisBarang);
    }

    @Override
    public void prosesBarang() {
        System.out.println("Memproses barang non-elektronik.");
    }

    @Override
    public void prosesPengembalian() {
        setStatus(2);
        System.out.println("Barang non-elektronik berhasil dikembalikan.");
    }

    @Override
    public void verifikasiBarang() {
        System.out.println("Barang non-elektronik berhasil diverifikasi.");
    }
}