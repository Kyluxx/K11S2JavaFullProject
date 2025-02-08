/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package exceptionform;

/**
 *
 * @author Rosita_Nesya
 */
public class KonversiAngka {
    private String[] satuan = {"", "One", "Two", "Three", "Four", "Five",
                              "Six", "Seven", "Eight", "Nine", "Ten", "Eleven",
                              "Twelve", "Thirteen", "Fourteen", "Fifteen",
                              "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
    private String[] puluhan = {"", "", "Twenty", "Thirty", "Forty",
                               "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};

    public String konversiNumber(Long angka) {
        if (angka < 20) 
            return satuan[angka.intValue()];
        if (angka <= 99) 
            return puluhan[angka.intValue() / 10] + " " + konversiNumber(angka % 10);
        if (angka <= 999) 
            return konversiNumber(angka / 100) + " Hundred " + konversiNumber(angka % 100);
        if (angka <= 999999) 
            return konversiNumber(angka / 1000) + " Thousand " + konversiNumber(angka % 1000);
        if (angka <= 999999999) 
            return konversiNumber(angka / 1000000) + " Million " + konversiNumber(angka % 1000000);
        if (angka <= 999999999999L) 
            return konversiNumber(angka / 1000000000) + " Billion " + konversiNumber(angka % 1000000000);
        if (angka <= 999999999999999L) 
            return konversiNumber(angka / 1000000000000L) + " Trillion " + konversiNumber(angka % 1000000000000L);
        return "Number is too large";
    }
}