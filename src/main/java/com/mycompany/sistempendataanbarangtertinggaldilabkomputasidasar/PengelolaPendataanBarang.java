package com.mycompany.sistempendataanbarangtertinggaldilabkomputasidasar;

import java.io.File;
import java.io.FileWriter;
import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.io.ObjectOutputStream;
import java.io.ObjectInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

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
        catatAktivitas("Menambahkan barang: " + barang.getNamaBarang());
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
        catatAktivitas("Menambahkan petugas: " + petugas.getNama()
                + " (NIP: " + petugas.getNip() + ")");
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

    public void catatAktivitas(String aktivitas) {
        try {
            FileWriter penulis = new FileWriter("log_aktivitas.txt", true);
            penulis.write(aktivitas + "\n");
            penulis.close();
        } catch (IOException e) {
            System.out.println("Gagal mencatat aktivitas: " + e.getMessage());
        }
    }

    public void bacaLogAktivitas() {
        try {
            File fileLog = new File("log_aktivitas.txt");
            Scanner pembaca = new Scanner(fileLog);

            System.out.println("\n===== LOG AKTIVITAS =====");
            if (!pembaca.hasNextLine()) {
                System.out.println("Belum ada catatan aktivitas.");
            }

            while (pembaca.hasNextLine()) {
                System.out.println(pembaca.nextLine());
            }
            pembaca.close();
        } catch (java.io.FileNotFoundException e) {
            System.out.println("File log belum tersedia.");
        }
    }

    public void simpanDataKeFile() {
        try {
            FileOutputStream fileKeluar = new FileOutputStream("data_barang.dat");
            ObjectOutputStream objekKeluar = new ObjectOutputStream(fileKeluar);

            objekKeluar.writeObject(daftarBarang);
            objekKeluar.writeObject(dataPetugas);
            objekKeluar.writeObject(ruangPenyimpanan);

            objekKeluar.close();
            fileKeluar.close();

            System.out.println("Data barang dan petugas berhasil disimpan ke data_barang.dat.");
            catatAktivitas("Menyimpan data objek ke data_barang.dat");
        } catch (IOException e) {
            System.out.println("Gagal menyimpan data: " + e.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
    public void muatDataDariFile() {
        File fileData = new File("data_barang.dat");

        if (!fileData.exists()) {
            System.out.println("File data belum ditemukan. Program dimulai dengan data kosong.");
            return;
        }

        try {
            FileInputStream fileMasuk = new FileInputStream(fileData);
            ObjectInputStream objekMasuk = new ObjectInputStream(fileMasuk);

            daftarBarang = (ArrayList<BarangTertinggal>) objekMasuk.readObject();
            dataPetugas = (HashMap<String, Petugas>) objekMasuk.readObject();
            ruangPenyimpanan = (RuangPenyimpanan) objekMasuk.readObject();

            objekMasuk.close();
            fileMasuk.close();

            System.out.println("Data berhasil dimuat dari data_barang.dat.");
            System.out.println("Jumlah barang: " + daftarBarang.size());
            System.out.println("Jumlah petugas: " + dataPetugas.size());
            catatAktivitas("Memuat data objek dari data_barang.dat");
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Gagal memuat data: " + e.getMessage());
        }
    }
}
