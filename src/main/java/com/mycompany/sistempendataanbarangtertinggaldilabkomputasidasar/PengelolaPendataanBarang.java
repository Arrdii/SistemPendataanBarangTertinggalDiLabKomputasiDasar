package com.mycompany.sistempendataanbarangtertinggaldilabkomputasidasar;

import java.util.ArrayList;
import java.util.HashMap;

public class PengelolaPendataanBarang {

    private ArrayList<BarangTertinggal> daftarBarang;
    private HashMap<String, Petugas> dataPetugas;

    private RuangPenyimpanan ruangPenyimpanan;

    public PengelolaPendataanBarang() {

        daftarBarang = new ArrayList<>();
        dataPetugas = new HashMap<>();

     
        ruangPenyimpanan = new RuangPenyimpanan(
                "Ruang Penyimpanan Lab Komputasi", 50);
    }

    public void tambahBarang(BarangTertinggal barang) {
        daftarBarang.add(barang);
        System.out.println("Barang berhasil ditambahkan!");
    }

    public void lihatSemuaBarang() {

        if (daftarBarang.isEmpty()) {
            System.out.println("Belum ada data barang.");
            return;
        }

        for (int i = 0; i < daftarBarang.size(); i++) {
            System.out.println("\nNomor Barang: " + (i + 1));
            daftarBarang.get(i).tampilkanInfo();
            System.out.println("---------------------------");
        }

        System.out.println("Jumlah Barang: " + daftarBarang.size());
    }

    public BarangTertinggal cariBarang(String nama)
            throws KoleksiBarangTidakDitemukanException {

        if (nama == null || nama.isEmpty()) {
            throw new KoleksiBarangTidakDitemukanException(
                    "Nama barang tidak boleh kosong!");
        }

        for (int i = 0; i < daftarBarang.size(); i++) {

            if (daftarBarang.get(i).getNamaBarang()
                    .equalsIgnoreCase(nama)) {
                return daftarBarang.get(i);
            }
        }

        throw new KoleksiBarangTidakDitemukanException(
                "Barang tidak ditemukan!");
    }

    public BarangTertinggal getBarang(int nomor) {
        return daftarBarang.get(nomor - 1);
    }

    public int getJumlahBarang() {
        return daftarBarang.size();
    }

    public void tambahPetugas(Petugas petugas) {
        dataPetugas.put(petugas.getNip(), petugas);
        System.out.println("Petugas berhasil ditambahkan!");
    }

    public Petugas cariPetugas(String nip) {

        if (dataPetugas.containsKey(nip)) {
            return dataPetugas.get(nip);
        }

        return null;
    }

    public void lihatSemuaPetugas() {

        if (dataPetugas.isEmpty()) {
            System.out.println("Belum ada data petugas.");
            return;
        }

        for (String nip : dataPetugas.keySet()) {
            dataPetugas.get(nip).tampilkanInfo();
            System.out.println("---------------------------");
        }

        System.out.println("Jumlah Petugas: " + dataPetugas.size());
    }

    public void tampilkanRuangPenyimpanan() {
        ruangPenyimpanan.tampilkanInfo();
    }
}
