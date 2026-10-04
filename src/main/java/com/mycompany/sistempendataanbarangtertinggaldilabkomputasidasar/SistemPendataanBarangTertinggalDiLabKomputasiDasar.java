package com.mycompany.sistempendataanbarangtertinggaldilabkomputasidasar;

import java.util.Scanner;

public class SistemPendataanBarangTertinggalDiLabKomputasiDasar {

    public static void cariBarang(String namaBarang, BarangTertinggal[] daftarBarang, int jumlahBarang) {
        System.out.println("Mencari barang dengan Nama (Teks): " + namaBarang);
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

        System.out.println("Mencari barang dengan Status: " + statusCari);
        boolean ditemukan = false;

        for (int i = 0; i < jumlahBarang; i++) {
            if (daftarBarang[i].getStatus().equalsIgnoreCase(statusCari)) {
                daftarBarang[i].tampilkanInfo();
                ditemukan = true;
            }
        }

        if (!ditemukan) {
            System.out.println("Barang tidak ditemukan.");
        }
    }

    public static void tandaiDikembalikan(String namaBarang, BarangTertinggal[] daftarBarang, int jumlahBarang) {
        boolean ditemukan = false;

        for (int i = 0; i < jumlahBarang; i++) {
            if (daftarBarang[i].getNamaBarang().equalsIgnoreCase(namaBarang)) {
                daftarBarang[i].setStatus("Sudah Dikembalikan");
                ditemukan = true;
                System.out.println("Status barang berhasil diperbarui.");
            }
        }

        if (!ditemukan) {
            System.out.println("Barang tidak ditemukan.");
        }
    }

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
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
                System.out.println("5. Keluar");
                System.out.print("Pilih Menu: 1-5: ");

                int pilihan = scanner.nextInt();
                scanner.nextLine();

                switch (pilihan) {
                    case 1 -> {
                        if (jumlahBarang < daftarBarang.length) {
                            System.out.println("\n-- Pilih Jenis Barang --");
                            System.out.println("1. Barang Elektronik");
                            System.out.println("2. Barang Non-Elektronik");
                            System.out.print("Pilihan (1/2): ");

                            int jenis = scanner.nextInt();
                            scanner.nextLine();

                            if (jenis == 1 || jenis == 2) {
                                System.out.print("Masukkan Nama Barang: ");
                                String namaBarang = scanner.nextLine();

                                System.out.print("Masukkan Lokasi Ditemukan: ");
                                String lokasiDitemukan = scanner.nextLine();

                                System.out.print("Masukkan Tanggal Ditemukan: ");
                                String tanggalDitemukan = scanner.nextLine();

                                System.out.println("\n-- Status Barang --");
                                System.out.println("1. Belum Diklaim");
                                System.out.println("2. Sudah Dikembalikan");
                                System.out.print("Pilihan (1/2): ");

                                int pilihanStatus = scanner.nextInt();
                                scanner.nextLine();

                                String status;

                                if (pilihanStatus == 1) {
                                    status = "Belum Diklaim";
                                } else if (pilihanStatus == 2) {
                                    status = "Sudah Dikembalikan";
                                } else {
                                    status = "Belum Diklaim";
                                    System.out.println("Pilihan status tidak valid.");
                                }

                                if (jenis == 1) {
                                    System.out.print("Masukkan Merek: ");
                                    String merek = scanner.nextLine();

                                    System.out.print("Masukkan Kondisi: ");
                                    String kondisi = scanner.nextLine();

                                    daftarBarang[jumlahBarang] = new BarangElektronik(
                                            namaBarang, lokasiDitemukan, tanggalDitemukan,
                                            status, merek, kondisi
                                    );
                                } else {
                                    System.out.print("Masukkan Warna: ");
                                    String warna = scanner.nextLine();

                                    System.out.print("Masukkan Jenis Barang: ");
                                    String jenisBarang = scanner.nextLine();

                                    daftarBarang[jumlahBarang] = new BarangNonElektronik(
                                            namaBarang, lokasiDitemukan, tanggalDitemukan,
                                            status, warna, jenisBarang
                                    );
                                }

                                jumlahBarang++;
                                System.out.println("Sukses! Barang berhasil ditambahkan.");
                                System.out.print("Tekan Enter untuk melanjutkan...");
                                scanner.nextLine();
                            } else {
                                System.out.println("Pilihan jenis barang tidak valid.");
                            }
                        } else {
                            System.out.println("Kapasitas data barang sudah penuh!");
                        }
                    }

                    case 2 -> {
                        System.out.println("\n-- Daftar Barang Tertinggal --");

                        if (jumlahBarang == 0) {
                            System.out.println("Belum ada barang yang tersimpan.");
                        } else {
                            for (int i = 0; i < jumlahBarang; i++) {
                                System.out.print((i + 1) + ". ");
                                daftarBarang[i].tampilkanInfo();
                                System.out.println();
                            }

                            System.out.println("Total Barang yang Terdaftar: "
                                    + BarangTertinggal.getJumlahBarang());
                        }

                        System.out.print("Tekan Enter untuk melanjutkan...");
                        scanner.nextLine();
                    }

                    case 3 -> {
                        System.out.println("\n-- Fitur Cari Barang --");
                        System.out.println("1. Cari berdasarkan Nama Barang");
                        System.out.println("2. Cari berdasarkan Status1");
                        System.out.print("Pilih (1/2): ");

                        int modeCari = scanner.nextInt();
                        scanner.nextLine();

                        if (modeCari == 1) {
                            System.out.print("Masukkan Nama Barang: ");
                            String kataKunci = scanner.nextLine();
                            cariBarang(kataKunci, daftarBarang, jumlahBarang);
                        } else if (modeCari == 2) {
                            System.out.println("1. Belum Diklaim");
                            System.out.println("2. Sudah Dikembalikan");
                            System.out.print("Pilih status (1/2): ");

                            int angkaKunci = scanner.nextInt();
                            scanner.nextLine();

                            cariBarang(angkaKunci, daftarBarang, jumlahBarang);
                        } else {
                            System.out.println("Pilihan tidak valid.");
                        }

                        System.out.print("Tekan Enter untuk melanjutkan...");
                        scanner.nextLine();
                    }

                    case 4 -> {
                        System.out.println("\n-- Tandai Barang Dikembalikan --");
                        System.out.print("Masukkan Nama Barang: ");

                        String namaBarang = scanner.nextLine();

                        tandaiDikembalikan(namaBarang, daftarBarang, jumlahBarang);

                        System.out.print("Tekan Enter untuk melanjutkan...");
                        scanner.nextLine();
                    }

                    case 5 -> {
                        System.out.println("Terima kasih telah menggunakan Sistem Pendataan Barang Tertinggal!");
                        isRunning = false;
                    }

                    default -> {
                        System.out.println("Pilihan tidak valid. Silahkan masukkan angka 1-5.");
                    }
                }
            }
        }
    }
}