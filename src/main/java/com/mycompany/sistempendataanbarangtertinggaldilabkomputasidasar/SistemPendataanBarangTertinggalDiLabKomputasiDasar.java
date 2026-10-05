package com.mycompany.sistempendataanbarangtertinggaldilabkomputasidasar;

import java.util.Scanner;

public class SistemPendataanBarangTertinggalDiLabKomputasiDasar {

    public static void cariBarang(String namaBarang, BarangTertinggal[] daftarBarang, int jumlahBarang) {
        System.out.println("\nMencari barang dengan Nama: " + namaBarang);

        boolean ditemukan = false;

        for (int i = 0; i < jumlahBarang; i++) {
            if (daftarBarang[i].getNamaBarang().equalsIgnoreCase(namaBarang)) {
                daftarBarang[i].tampilkanInfo();
                ditemukan = true;
            }
        }

        if (!ditemukan) {
            System.out.println("Barang tidak ditemukan.");
        }
    }

    public static void cariBarang(int status, BarangTertinggal[] daftarBarang, int jumlahBarang) {
        String statusCari;

        if (status == 1) {
            statusCari = "Belum Diklaim";
        } else {
            statusCari = "Sudah Dikembalikan";
        }

        System.out.println("\nMencari barang dengan Status: " + statusCari);

        boolean ditemukan = false;

        for (int i = 0; i < jumlahBarang; i++) {
            if (daftarBarang[i].getStatus() == status) {
                daftarBarang[i].tampilkanInfo();
                ditemukan = true;
            }
        }

        if (!ditemukan) {
            System.out.println("Barang tidak ditemukan.");
        }
    }

    public static void prosesBarang(BarangTertinggal barang) {
        System.out.println("\n=== Proses Pengembalian Barang ===");
        barang.tampilkanInfo();
        barang.setStatus(2);
        System.out.println("\nBarang berhasil diproses untuk dikembalikan.");
    }

    public static void tandaiDikembalikan(String namaBarang, BarangTertinggal[] daftarBarang, int jumlahBarang) {
        boolean ditemukan = false;

        for (int i = 0; i < jumlahBarang; i++) {
            if (daftarBarang[i].getNamaBarang().equalsIgnoreCase(namaBarang)) {
                daftarBarang[i].setStatus(2);
                ditemukan = true;
                System.out.println("Status barang berhasil diperbarui.");
            }
        }

        if (!ditemukan) {
            System.out.println("Barang tidak ditemukan.");
        }
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        BarangTertinggal[] daftarBarang = new BarangTertinggal[10];

        int jumlahBarang = 0;
        boolean isRunning = true;

        System.out.println("========================================");
        System.out.println(" SISTEM PENDATAAN BARANG TERTINGGAL");
        System.out.println("       LAB KOMPUTASI DASAR");
        System.out.println("========================================");

        while (isRunning) {

            System.out.println("\nMenu Utama:");
            System.out.println("1. Tambah Barang");
            System.out.println("2. Lihat Daftar Barang");
            System.out.println("3. Cari Barang");
            System.out.println("4. Tandai Barang Dikembalikan");
            System.out.println("5. Proses Pengembalian Barang");
            System.out.println("6. Keluar");
            System.out.print("Pilih Menu: ");

            int pilihan = scanner.nextInt();
            scanner.nextLine();

            switch (pilihan) {

                case 1:

                    if (jumlahBarang < daftarBarang.length) {

                        System.out.println("\n-- Pilih Jenis Barang --");
                        System.out.println("1. Barang Elektronik");
                        System.out.println("2. Barang Non-Elektronik");
                        System.out.println("3. Barang Dokumen");
                        System.out.print("Pilihan: ");

                        int jenis = scanner.nextInt();
                        scanner.nextLine();

                        if (jenis == 1 || jenis == 2 || jenis == 3) {

                            System.out.print("Masukkan Nama Barang: ");
                            String namaBarang = scanner.nextLine();

                            System.out.print("Masukkan Lokasi Ditemukan: ");
                            String lokasiDitemukan = scanner.nextLine();

                            System.out.print("Masukkan Tanggal Ditemukan: ");
                            String tanggalDitemukan = scanner.nextLine();

                            System.out.println("\n-- Status Barang --");
                            System.out.println("1. Belum Diklaim");
                            System.out.println("2. Sudah Dikembalikan");
                            System.out.print("Pilihan: ");

                            int pilihanStatus = scanner.nextInt();
                            scanner.nextLine();

                            int status;

                            if (pilihanStatus == 1) {
                                status = 1;
                            } else if (pilihanStatus == 2) {
                                status = 2;
                            } else {
                                status = 1;
                                System.out.println("Pilihan status tidak valid.");
                            }

                            if (jenis == 1) {

                                System.out.print("Masukkan Merek: ");
                                String merek = scanner.nextLine();

                                System.out.print("Masukkan Kondisi: ");
                                String kondisi = scanner.nextLine();

                                daftarBarang[jumlahBarang] = new BarangElektronik(
                                        namaBarang,
                                        lokasiDitemukan,
                                        tanggalDitemukan,
                                        status,
                                        merek,
                                        kondisi
                                );

                            } else if (jenis == 2) {

                                System.out.print("Masukkan Warna: ");
                                String warna = scanner.nextLine();

                                System.out.print("Masukkan Jenis Barang: ");
                                String jenisBarang = scanner.nextLine();

                                daftarBarang[jumlahBarang] = new BarangNonElektronik(
                                        namaBarang,
                                        lokasiDitemukan,
                                        tanggalDitemukan,
                                        status,
                                        warna,
                                        jenisBarang
                                );

                            } else {

                                System.out.print("Masukkan Jenis Dokumen: ");
                                String jenisDokumen = scanner.nextLine();

                                System.out.print("Masukkan Nama Pemilik: ");
                                String namaPemilik = scanner.nextLine();

                                daftarBarang[jumlahBarang] = new BarangDokumen(
                                        namaBarang,
                                        lokasiDitemukan,
                                        tanggalDitemukan,
                                        status,
                                        jenisDokumen,
                                        namaPemilik
                                );
                            }

                            jumlahBarang++;

                            System.out.println("\nBarang berhasil ditambahkan.");

                        } else {
                            System.out.println("Pilihan jenis barang tidak valid.");
                        }

                    } else {
                        System.out.println("Kapasitas data barang sudah penuh.");
                    }

                    break;

                case 2:

                    System.out.println("\n=== DAFTAR BARANG TERTINGGAL ===");

                    if (jumlahBarang == 0) {

                        System.out.println("Belum ada barang yang tersimpan.");

                    } else {

                        for (int i = 0; i < jumlahBarang; i++) {

                            System.out.println("\nData Barang ke-" + (i + 1));

                            daftarBarang[i].tampilkanInfo();

                            System.out.println("----------------------------------------");
                        }

                        System.out.println("Total Barang: "
                                + BarangTertinggal.getJumlahBarang());
                    }

                    break;

                case 3:

                    System.out.println("\n=== CARI BARANG ===");
                    System.out.println("1. Cari berdasarkan Nama");
                    System.out.println("2. Cari berdasarkan Status");
                    System.out.print("Pilih: ");

                    int modeCari = scanner.nextInt();
                    scanner.nextLine();

                    if (modeCari == 1) {

                        System.out.print("Masukkan Nama Barang: ");
                        String namaCari = scanner.nextLine();

                        cariBarang(namaCari, daftarBarang, jumlahBarang);

                    } else if (modeCari == 2) {

                        System.out.println("1. Belum Diklaim");
                        System.out.println("2. Sudah Dikembalikan");
                        System.out.print("Pilih Status: ");

                        int statusCari = scanner.nextInt();
                        scanner.nextLine();

                        cariBarang(statusCari, daftarBarang, jumlahBarang);

                    } else {

                        System.out.println("Pilihan tidak valid.");
                    }

                    break;

                case 4:

                    System.out.println("\n=== TANDAI BARANG DIKEMBALIKAN ===");

                    System.out.print("Masukkan Nama Barang: ");
                    String namaBarang = scanner.nextLine();

                    tandaiDikembalikan(
                            namaBarang,
                            daftarBarang,
                            jumlahBarang
                    );

                    break;

                case 5:

                    System.out.println("\n=== PROSES PENGEMBALIAN BARANG ===");

                    if (jumlahBarang == 0) {

                        System.out.println("Belum ada barang yang tersimpan.");

                    } else {

                        System.out.println("Daftar Barang:");

                        for (int i = 0; i < jumlahBarang; i++) {
                            System.out.println((i + 1) + ". "
                                    + daftarBarang[i].getNamaBarang());
                        }

                        System.out.print("Pilih nomor barang: ");
                        int nomorBarang = scanner.nextInt();
                        scanner.nextLine();

                        if (nomorBarang >= 1 && nomorBarang <= jumlahBarang) {

                            prosesBarang(daftarBarang[nomorBarang - 1]);

                        } else {

                            System.out.println("Nomor barang tidak valid.");
                        }
                    }

                    break;

                case 6:

                    System.out.println("\nTerima kasih telah menggunakan sistem.");
                    isRunning = false;

                    break;

                default:

                    System.out.println("Pilihan tidak valid. Silakan pilih 1-6.");
            }
        }

        scanner.close();
    }
}