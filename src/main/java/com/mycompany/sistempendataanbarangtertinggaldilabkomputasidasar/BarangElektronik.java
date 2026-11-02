package com.mycompany.sistempendataanbarangtertinggaldilabkomputasidasar;

public class BarangElektronik extends BarangTertinggal
        implements DapatDikembalikan {

    private String merek;
    private String kondisi;

    public BarangElektronik(String namaBarang, String lokasiDitemukan,
            String tanggalDitemukan, int status, String merek, String kondisi) {

        super(namaBarang, lokasiDitemukan, tanggalDitemukan, status);
        this.merek = merek;
        this.kondisi = kondisi;
    }

    @Override
    public void tampilkanInfo() {
        super.tampilkanInfo();
        System.out.println("Merek           : " + merek);
        System.out.println("Kondisi         : " + kondisi);
    }

    @Override
    public void prosesBarang() {
        System.out.println("Memproses barang elektronik.");
    }

    @Override
    public void prosesPengembalian() {
        setStatus(2);
        System.out.println("Barang elektronik berhasil dikembalikan.");
    }
}