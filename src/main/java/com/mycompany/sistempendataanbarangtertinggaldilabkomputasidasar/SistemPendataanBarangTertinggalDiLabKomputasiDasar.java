package com.mycompany.sistempendataanbarangtertinggaldilabkomputasidasar;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Scanner;

public class SistemPendataanBarangTertinggalDiLabKomputasiDasar {

    static Scanner input = new Scanner(System.in);

    static ArrayList<BarangTertinggal> daftarBarang = new ArrayList<>();

    static HashMap<String, String> dataPetugas = new HashMap<>();


    public static void validasiInput(String data)
            throws KoleksiBarangTidakDitemukanException {

        if (data == null || data.isEmpty()) {
            throw new KoleksiBarangTidakDitemukanException(
                    "Input tidak boleh kosong!");
        }
    }

    // Menambahkan data barang
    public static void tambahBarang(BarangTertinggal barang) {
        daftarBarang.add(barang);
        System.out.println("Barang berhasil ditambahkan!");
    }

    
    public static void tampilkanBarang() {

        if (daftarBarang.isEmpty()) {
            System.out.println("Belum ada data barang.");
            return;
        }

        System.out.println("\n===== DAFTAR BARANG TERTINGGAL =====");

        for (int i = 0; i < daftarBarang.size(); i++) {
            System.out.println("\nNomor Barang: " + (i + 1));
            daftarBarang.get(i).tampilkanInfo();
            System.out.println("--------------------------------");
        }

        System.out.println("Jumlah Barang: " + daftarBarang.size());
    }

    
    public static BarangTertinggal cariBarang(String nama)
            throws KoleksiBarangTidakDitemukanException {

        validasiInput(nama);

        for (int i = 0; i < daftarBarang.size(); i++) {

            if (daftarBarang.get(i).getNamaBarang().equalsIgnoreCase(nama)) {
                return daftarBarang.get(i);
            }
        }

        throw new KoleksiBarangTidakDitemukanException(
                "Barang dengan nama " + nama + " tidak ditemukan!");
    }

   
    public static void jalankanProsesBarang(BarangTertinggal barang) {

        barang.prosesBarang();

        if (barang instanceof DapatDikembalikan) {
            DapatDikembalikan data = (DapatDikembalikan) barang;
            data.prosesPengembalian();
        }

        if (barang instanceof DapatDiverifikasi) {
            DapatDiverifikasi data = (DapatDiverifikasi) barang;
            data.verifikasiBarang();
        }
    }

   
    public static void menuPetugas() {

        int pilihanPetugas = 0;

        do {
            try {
                System.out.println("\n===== MENU DATA PETUGAS =====");
                System.out.println("1. Tambah Petugas");
                System.out.println("2. Cari Petugas");
                System.out.println("3. Tampilkan Semua Petugas");
                System.out.println("4. Kembali");
                System.out.print("Pilih menu: ");

                pilihanPetugas = input.nextInt();
                input.nextLine();

                switch (pilihanPetugas) {

                    case 1:
                        System.out.print("Masukkan NIP Petugas: ");
                        String nip = input.nextLine();

                        validasiInput(nip);

                        if (dataPetugas.containsKey(nip)) {
                            System.out.println("NIP sudah terdaftar!");
                        } else {
                            System.out.print("Masukkan Nama Petugas: ");
                            String nama = input.nextLine();

                            validasiInput(nama);

                            dataPetugas.put(nip, nama);
                            System.out.println("Petugas berhasil ditambahkan!");
                        }
                        break;

                    case 2:
                        System.out.print("Masukkan NIP yang dicari: ");
                        String cariNip = input.nextLine();

                        validasiInput(cariNip);

                        if (dataPetugas.containsKey(cariNip)) {
                            System.out.println("Nama Petugas: "
                                    + dataPetugas.get(cariNip));
                        } else {
                            System.out.println("Petugas tidak ditemukan!");
                        }
                        break;

                    case 3:
                        if (dataPetugas.isEmpty()) {
                            System.out.println("Belum ada data petugas.");
                        } else {
                            System.out.println("\n===== DATA SEMUA PETUGAS =====");

                            for (String kunci : dataPetugas.keySet()) {
                                System.out.println("NIP  : " + kunci);
                                System.out.println("Nama : "
                                        + dataPetugas.get(kunci));
                                System.out.println("----------------------");
                            }

                            System.out.println("Jumlah Petugas: "
                                    + dataPetugas.size());
                        }
                        break;

                    case 4:
                        System.out.println("Kembali ke menu utama.");
                        break;

                    default:
                        System.out.println("Pilihan tidak tersedia.");
                }

            } catch (InputMismatchException e) {
                System.out.println("Error: Masukkan angka untuk pilihan menu.");
                input.nextLine();

            } catch (KoleksiBarangTidakDitemukanException e) {
                System.out.println("Error: " + e.getMessage());

            } finally {
                System.out.println("Proses menu petugas selesai.");
            }

        } while (pilihanPetugas != 4);
    }

    public static void main(String[] args) {

        // Data awal ArrayList: 3 objek barang
        daftarBarang.add(new BarangElektronik(
                "Laptop", "Lab Komputer 1", "01-11-2026",
                1, "Asus", "Baik"));

        daftarBarang.add(new BarangNonElektronik(
                "Botol Minum", "Lab Komputer 2", "01-11-2026",
                1, "Hitam", "Botol"));

        daftarBarang.add(new BarangDokumen(
                "Kartu Mahasiswa", "Lab Komputer 3", "02-11-2026",
                1, "Kartu Identitas", "Mahasiswa"));

        // Data awal HashMap: 2 petugas
        dataPetugas.put("PTG001", "Andi");
        dataPetugas.put("PTG002", "Budi");

        int pilihan = 0;

        try {

            do {
                try {
                    System.out.println("\n==================================");
                    System.out.println(" SISTEM PENDATAAN BARANG TERTINGGAL");
                    System.out.println("       LAB KOMPUTASI DASAR");
                    System.out.println("==================================");
                    System.out.println("1. Tambah Barang");
                    System.out.println("2. Tampilkan Semua Barang");
                    System.out.println("3. Cari Barang");
                    System.out.println("4. Proses Barang");
                    System.out.println("5. Kelola Data Petugas");
                    System.out.println("6. Keluar");
                    System.out.print("Pilih menu: ");

                    pilihan = input.nextInt();
                    input.nextLine();

                    switch (pilihan) {

                        case 1:
                            System.out.println("\nJenis Barang:");
                            System.out.println("1. Elektronik");
                            System.out.println("2. Non-Elektronik");
                            System.out.println("3. Dokumen");
                            System.out.print("Pilih jenis: ");

                            int jenis = input.nextInt();
                            input.nextLine();

                            System.out.print("Nama Barang: ");
                            String nama = input.nextLine();
                            validasiInput(nama);

                            System.out.print("Lokasi Ditemukan: ");
                            String lokasi = input.nextLine();
                            validasiInput(lokasi);

                            System.out.print("Tanggal Ditemukan: ");
                            String tanggal = input.nextLine();
                            validasiInput(tanggal);

                            if (jenis == 1) {
                                System.out.print("Merek: ");
                                String merek = input.nextLine();
                                validasiInput(merek);

                                System.out.print("Kondisi: ");
                                String kondisi = input.nextLine();
                                validasiInput(kondisi);

                                tambahBarang(new BarangElektronik(
                                        nama, lokasi, tanggal, 1,
                                        merek, kondisi));

                            } else if (jenis == 2) {
                                System.out.print("Warna: ");
                                String warna = input.nextLine();
                                validasiInput(warna);

                                System.out.print("Jenis Barang: ");
                                String jenisBarang = input.nextLine();
                                validasiInput(jenisBarang);

                                tambahBarang(new BarangNonElektronik(
                                        nama, lokasi, tanggal, 1,
                                        warna, jenisBarang));

                            } else if (jenis == 3) {
                                System.out.print("Jenis Dokumen: ");
                                String dokumen = input.nextLine();
                                validasiInput(dokumen);

                                System.out.print("Nama Pemilik: ");
                                String pemilik = input.nextLine();
                                validasiInput(pemilik);

                                tambahBarang(new BarangDokumen(
                                        nama, lokasi, tanggal, 1,
                                        dokumen, pemilik));

                            } else {
                                System.out.println("Jenis barang tidak tersedia.");
                            }
                            break;

                        case 2:
                            tampilkanBarang();
                            break;

                        case 3:
                            System.out.print("Masukkan nama barang: ");
                            String cariNama = input.nextLine();

                            BarangTertinggal hasil = cariBarang(cariNama);
                            System.out.println("\nBarang ditemukan!");
                            hasil.tampilkanInfo();
                            break;

                        case 4:
                            tampilkanBarang();

                            if (!daftarBarang.isEmpty()) {
                                System.out.print("Masukkan nomor barang: ");
                                int nomor = input.nextInt();
                                input.nextLine();

                                if (nomor >= 1 && nomor <= daftarBarang.size()) {
                                    BarangTertinggal barang =
                                            daftarBarang.get(nomor - 1);

                                    jalankanProsesBarang(barang);
                                } else {
                                    throw new KoleksiBarangTidakDitemukanException(
                                            "Nomor barang tidak ditemukan!");
                                }
                            }
                            break;

                        case 5:
                            menuPetugas();
                            break;

                        case 6:
                            System.out.println("Terima kasih telah menggunakan program.");
                            break;

                        default:
                            System.out.println("Pilihan menu tidak tersedia.");
                    }

                } catch (InputMismatchException e) {
                    System.out.println("Error: Input harus berupa angka!");
                    input.nextLine();

                } catch (KoleksiBarangTidakDitemukanException e) {
                    System.out.println("Error: " + e.getMessage());

                } finally {
                    System.out.println("Proses menu utama selesai.");
                }

            } while (pilihan != 6);

        } finally {
            System.out.println("Program ditutup. Scanner akan ditutup.");
            input.close();
        }
    }
}