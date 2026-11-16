package com.mycompany.sistempendataanbarangtertinggaldilabkomputasidasar;

import java.util.Scanner;
import java.util.InputMismatchException;

public class SistemPendataanBarangTertinggalDiLabKomputasiDasar {
    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        PengelolaPendataanBarang pengelola =
                new PengelolaPendataanBarang();

        TransaksiPenanganan transaksi =
                new TransaksiPenanganan();

        int pilihan = 0;

        pengelola.muatDataDariFile();

        try {
            do {
                try {
                    System.out.println("\n==================================");
                    System.out.println(" SISTEM PENDATAAN BARANG TERTINGGAL");
                    System.out.println("       LAB KOMPUTASI DASAR");
                    System.out.println("==================================");
                    System.out.println("1. Informasi Ruang Penyimpanan");
                    System.out.println("2. Tampilkan Semua Barang");
                    System.out.println("3. Tambah Barang");
                    System.out.println("4. Cari Barang");
                    System.out.println("5. Kelola Data Petugas");
                    System.out.println("6. Transaksi Penanganan Barang");
                    System.out.println("7. Keluar");
                    System.out.println("8. Simpan Data");
                    System.out.println("9. Muat Data");
                    System.out.println("10. Tampilkan Log Aktivitas");
                    System.out.print("Pilih menu: ");

                    pilihan = input.nextInt();
                    input.nextLine();

                    switch (pilihan) {
                        case 1:
                            System.out.println("\n===== RUANG PENYIMPANAN =====");
                            pengelola.tampilkanRuangPenyimpanan();
                            break;

                        case 2:
                            System.out.println("\n===== DAFTAR BARANG =====");
                            pengelola.lihatSemuaBarang();
                            break;

                        case 3:
                            tambahBarang(pengelola);
                            break;

                        case 4:
                            System.out.print("Masukkan nama barang: ");
                            String namaCari = input.nextLine();

                            BarangTertinggal hasil =
                                    pengelola.cariBarang(namaCari);

                            System.out.println("\nBarang ditemukan!");
                            hasil.tampilkanInfo();
                            break;

                        case 5:
                            menuPetugas(pengelola);
                            break;

                        case 6:
                            jalankanTransaksi(pengelola, transaksi);
                            break;

                        case 7:
                            System.out.println(
                                    "Terima kasih telah menggunakan program.");
                            break;

                        case 8:
                            pengelola.simpanDataKeFile();
                            break;

                        case 9:
                            pengelola.muatDataDariFile();
                            break;

                        case 10:
                            pengelola.bacaLogAktivitas();
                            break;

                        default:
                            System.out.println(
                                    "Pilihan menu tidak tersedia.");
                    }

                } catch (InputMismatchException e) {
                    System.out.println(
                            "Error: Masukkan angka yang benar!");
                    input.nextLine();

                } catch (KoleksiBarangTidakDitemukanException e) {
                    System.out.println("Error: " + e.getMessage());

                } finally {
                    System.out.println("Proses menu selesai.");
                }

            } while (pilihan != 7);

        } finally {
            System.out.println("\nMenyimpan data sebelum program ditutup...");
            pengelola.simpanDataKeFile();
            System.out.println("Program ditutup.");
            input.close();
        }
    }

    public static void tambahBarang(
            PengelolaPendataanBarang pengelola) {

        System.out.println("\n===== TAMBAH BARANG =====");
        System.out.println("1. Elektronik");
        System.out.println("2. Non-Elektronik");
        System.out.println("3. Dokumen");
        System.out.print("Pilih jenis barang: ");

        int jenis = input.nextInt();
        input.nextLine();

        System.out.print("Nama Barang: ");
        String nama = input.nextLine();

        System.out.print("Lokasi Ditemukan: ");
        String lokasi = input.nextLine();

        System.out.print("Tanggal Ditemukan: ");
        String tanggal = input.nextLine();

        if (nama.isEmpty() || lokasi.isEmpty()
                || tanggal.isEmpty()) {
            System.out.println("Data tidak boleh kosong!");
            return;
        }

        if (jenis == 1) {
            System.out.print("Merek: ");
            String merek = input.nextLine();

            System.out.print("Kondisi: ");
            String kondisi = input.nextLine();

            pengelola.tambahBarang(new BarangElektronik(
                    nama, lokasi, tanggal, 1, merek, kondisi));

        } else if (jenis == 2) {
            System.out.print("Warna: ");
            String warna = input.nextLine();

            System.out.print("Jenis Barang: ");
            String jenisBarang = input.nextLine();

            pengelola.tambahBarang(new BarangNonElektronik(
                    nama, lokasi, tanggal, 1, warna, jenisBarang));

        } else if (jenis == 3) {
            System.out.print("Jenis Dokumen: ");
            String dokumen = input.nextLine();

            System.out.print("Nama Pemilik: ");
            String pemilik = input.nextLine();

            pengelola.tambahBarang(new BarangDokumen(
                    nama, lokasi, tanggal, 1, dokumen, pemilik));

        } else {
            System.out.println("Jenis barang tidak tersedia.");
        }
    }

    public static void menuPetugas(
            PengelolaPendataanBarang pengelola) {

        int menu = 0;

        do {
            try {
                System.out.println("\n===== MENU DATA PETUGAS =====");
                System.out.println("1. Tambah Petugas");
                System.out.println("2. Cari Petugas");
                System.out.println("3. Tampilkan Semua Petugas");
                System.out.println("4. Kembali");
                System.out.print("Pilih menu: ");

                menu = input.nextInt();
                input.nextLine();

                switch (menu) {
                    case 1:
                        System.out.print("Masukkan NIP: ");
                        String nip = input.nextLine();

                        System.out.print("Masukkan Nama: ");
                        String nama = input.nextLine();

                        if (nip.isEmpty() || nama.isEmpty()) {
                            System.out.println(
                                    "Data tidak boleh kosong!");

                        } else if (pengelola.cariPetugas(nip) != null) {
                            System.out.println(
                                    "NIP sudah terdaftar!");

                        } else {
                            pengelola.tambahPetugas(
                                    new Petugas(nip, nama));
                        }
                        break;

                    case 2:
                        System.out.print("Masukkan NIP: ");
                        String cariNip = input.nextLine();

                        Petugas petugas =
                                pengelola.cariPetugas(cariNip);

                        if (petugas != null) {
                            petugas.tampilkanInfo();
                        } else {
                            System.out.println(
                                    "Petugas tidak ditemukan!");
                        }
                        break;

                    case 3:
                        pengelola.lihatSemuaPetugas();
                        break;

                    case 4:
                        System.out.println(
                                "Kembali ke menu utama.");
                        break;

                    default:
                        System.out.println(
                                "Pilihan tidak tersedia.");
                }

            } catch (InputMismatchException e) {
                System.out.println("Error: Masukkan angka!");
                input.nextLine();

            } finally {
                System.out.println(
                        "Proses menu petugas selesai.");
            }

        } while (menu != 4);
    }

    public static void jalankanTransaksi(
            PengelolaPendataanBarang pengelola,
            TransaksiPenanganan transaksi) {

        if (pengelola.getJumlahBarang() == 0) {
            System.out.println("Belum ada data barang.");
            return;
        }

        pengelola.lihatSemuaBarang();

        System.out.print("\nPilih nomor barang: ");
        int nomor = input.nextInt();
        input.nextLine();

        if (nomor < 1
                || nomor > pengelola.getJumlahBarang()) {
            System.out.println("Nomor barang tidak tersedia!");
            return;
        }

        System.out.println("\n===== DAFTAR PETUGAS =====");
        pengelola.lihatSemuaPetugas();

        System.out.print("Masukkan NIP petugas: ");
        String nip = input.nextLine();

        Petugas petugas = pengelola.cariPetugas(nip);

        if (petugas == null) {
            System.out.println("Petugas tidak ditemukan!");
            return;
        }

        BarangTertinggal barang = pengelola.getBarang(nomor);

        transaksi.prosesPenanganan(petugas, barang);
        pengelola.catatAktivitas("Transaksi penanganan barang: "
                + barang.getNamaBarang() + " oleh petugas "
                + petugas.getNama() + ". Status akhir: "
                + (barang.getStatus() == 1
                        ? "Belum Diklaim" : "Sudah Dikembalikan"));
    }
}
