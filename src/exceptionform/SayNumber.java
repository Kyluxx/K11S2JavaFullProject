/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package exceptionform;

/**
 *
 * @author Rosita_Nesya
 */
public class SayNumber {
    private String[] satuan = {"", "Satu", "Dua", "Tiga", "Empat", "Lima",
                              "Enam", "Tujuh", "Delapan", "Sembilan", "Sepuluh", "Sebelas"};

    public String konversiAngka(long angka) {
        if (angka < 12) 
            return satuan[(int) angka];
        if (angka >= 12 && angka <= 19) 
            return satuan[(int) (angka % 10)] + " Belas";
        if (angka >= 20 && angka <= 99) 
            return konversiAngka(angka / 10) + " Puluh " + konversiAngka(angka % 10);
        if (angka >= 100 && angka <= 199) 
            return "Seratus " + konversiAngka(angka % 100);
        if (angka >= 200 && angka <= 999) 
            return konversiAngka(angka / 100) + " Ratus " + konversiAngka(angka % 100);
        if (angka >= 1000 && angka <= 1999) 
            return "Seribu " + konversiAngka(angka % 1000);
        if (angka >= 2000 && angka <= 999999) 
            return konversiAngka(angka / 1000) + " Ribu " + konversiAngka(angka % 1000);
        if (angka >= 1000000 && angka <= 999999999) 
            return konversiAngka(angka / 1000000) + " Juta " + konversiAngka(angka % 1000000);
        if (angka >= 1000000000 && angka <= 999999999999L) 
            return konversiAngka(angka / 1000000000) + " Miliar " + konversiAngka(angka % 1000000000);
        return "Angka terlalu besar";
    }
}

