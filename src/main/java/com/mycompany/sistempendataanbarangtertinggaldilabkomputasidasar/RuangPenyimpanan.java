package com.mycompany.sistempendataanbarangtertinggaldilabkomputasidasar;

import java.io.Serializable;

public class RuangPenyimpanan implements Serializable {

    private static final long serialVersionUID = 1L;

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
