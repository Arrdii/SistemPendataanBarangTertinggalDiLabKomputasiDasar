package com.mycompany.sistempendataanbarangtertinggaldilabkomputasidasar;

public class RuangPenyimpanan {

    private String namaRuang;
    private int kapasitas;

    public RuangPenyimpanan(String namaRuang, int kapasitas) {
        this.namaRuang = namaRuang;
        this.kapasitas = kapasitas;
    }

    public void tampilkanInfo() {
        System.out.println("Nama Ruang : " + namaRuang);
        System.out.println("Kapasitas  : " + kapasitas + " barang");
    }
}