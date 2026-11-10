package com.mycompany.sistempendataanbarangtertinggaldilabkomputasidasar;

public class TransaksiPenanganan {
    public void prosesPenanganan(
            Petugas petugas, BarangTertinggal barang) {

        System.out.println("\n===== TRANSAKSI PENANGANAN BARANG =====");
        System.out.println("Petugas yang menangani:");
        petugas.tampilkanInfo();

        System.out.println("\nBarang yang ditangani:");
        barang.tampilkanInfo();
        barang.prosesBarang();

        if (barang instanceof DapatDikembalikan) {
            DapatDikembalikan data =
                    (DapatDikembalikan) barang;

            data.prosesPengembalian();

            System.out.println(
                    "Status transaksi: Barang berhasil dikembalikan.");
        } else {
            System.out.println(
                    "Barang perlu diverifikasi sebelum dapat dikembalikan.");
        }

        if (barang instanceof DapatDiverifikasi) {
            DapatDiverifikasi data =
                    (DapatDiverifikasi) barang;

            data.verifikasiBarang();
        }

        System.out.println("Transaksi penanganan selesai.");
    }
}
