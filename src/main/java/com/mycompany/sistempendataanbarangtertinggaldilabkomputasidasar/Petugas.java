package com.mycompany.sistempendataanbarangtertinggaldilabkomputasidasar;

public class Petugas {

    private String nip;
    private String nama;

    public Petugas(String nip, String nama) {
        this.nip = nip;
        this.nama = nama;
    }

    public String getNip() {
        return nip;
    }

    public String getNama() {
        return nama;
    }

    public void tampilkanInfo() {
        System.out.println("NIP  : " + nip);
        System.out.println("Nama : " + nama);
    }
}
    

