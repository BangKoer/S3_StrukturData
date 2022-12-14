/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modul_2;

import Modul_1.*;

/**
 *
 * @author Lenovo V14
 */
public class DataArrayApp {
    public static void main(String[] args) {
        int maxSize = 100;
        DataArray arr;
        arr = new DataArray(maxSize);
        
//        for (int i = 0; i < 5; i++) {
//            arr.insert(16650020+i, "Orang"+i, "Bumi");
//        }
        
        arr.insert(1665026, "Helmi", "Madura");
        arr.insert(1665022, "Ismail", "Banyuwangi");
        arr.insert(1665023, "Sofi", "Semarang");
        arr.insert(1665020, "Jundi", "Malang");
        arr.insert(1665021, "Ahmad", "Siduoarjo");
        arr.insert(1665028, "Arina", "Malang");
        arr.insert(1665025, "Rais", "Ambon");
        arr.insert(1665024, "Dinda", "Bandung");
        arr.insert(1665027, "Agung", "Madiun");

        arr.displayArray();
        
        // Mencari
        long searchKey = 16650270;
        Mahasiswa mhs = arr.find(searchKey);
        if (mhs != null) {
            System.out.print("\n\tKetemu");
            mhs.displayMhs();
        } else {
            System.out.println("\tTidak Ketemu "+searchKey);
        }
        
        // Menghapus
        searchKey = 16650240;
        System.out.println("\n\tHapus nim "+searchKey);
        arr.delete(searchKey);
        arr.displayArray();
        System.out.println("");
        
        
        
        //BubbleSort
//        HighArrayApp harr = new HighArrayApp();
        System.out.println("====================INI BUBBLE SORT====================");
//        arr.BubbleSorting();
//        arr.displayArray();
        
        System.out.println("====================INI SELECTION SORT====================");
//        arr.SelectionSorting();
//        arr.displayArray();

        System.out.println("====================INI SELECTION SORT====================");
        arr.InsertionByName();
        arr.displayArray();
    }
}
