/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modul_1;

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
        
        arr.insert(16650200, "Jundi", "Malang");
        arr.insert(16650210, "Ahmad", "Siduoarjo");
        arr.insert(16650220, "Ismail", "Banyuwangi");
        arr.insert(16650230, "Sofi", "Semarang");
        arr.insert(16650240, "Dinda", "Bandung");
        arr.insert(16650250, "Rais", "Ambon");
        arr.insert(16650260, "Helmi", "Madura");
        arr.insert(16650270, "Agung", "Madiun");
        arr.insert(16650280, "Arina", "Malang");

        arr.displayArray();
        
        // Mencari
        long searchKey = 16650280;
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
        
    }
}
