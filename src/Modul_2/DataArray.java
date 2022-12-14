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
class Mahasiswa{
    private long nim;
    private String nama;
    private String asal;
    
    public Mahasiswa(long nim, String nama, String asal){
        this.nim = nim;
        this.nama = nama;
        this.asal = asal;
    }
    
    public void displayMhs(){
        System.out.print("\tNIM: "+nim);
        System.out.print(", Nama: "+nama);
        System.out.println(", Asal: "+asal);
    }

    public long getNim() {
        return nim;
    }

    public String getNama() {
        return nama;
    }
}

public class DataArray {
    private Mahasiswa[] mhs;
    private Mahasiswa[] temp;
    private int nElemen;
    
    public DataArray(int max){
        mhs = new Mahasiswa[max];
        nElemen = 0;
    }
    
    public Mahasiswa find(long searchNim){
        int i;
        for (i = 0; i < nElemen; i++) {
            if (mhs[i].getNim()==searchNim) {
                break;
            }
        }
        if (i == nElemen) {
            return null;
        } else {
            return mhs[i];
        }
    }
    
    public void insert(long nim, String nama, String asal){
        mhs[nElemen] = new Mahasiswa(nim, nama, asal);
        nElemen++;
    }
    
    public boolean delete(long searchNim){
        int i;
        for (i = 0; i < nElemen; i++) {
            if (mhs[i].getNim() == searchNim) {
                break;
            }
        }
        if (i == nElemen) {
            return false;
        } else {
            for (int j = i; j < nElemen; j++) {
                mhs[j] = mhs [j+1];
            }
            nElemen--;
            return true;
        }
    }
    
    public void displayArray(){
        for (int i = 0; i < nElemen; i++) {
            mhs[i].displayMhs();
        }
    }
    
    public void swap(int one, int two){
        Mahasiswa temp = mhs[one];
        mhs[one] = mhs[two];
        mhs[two] = temp;
    }
    
    //BubbleSort
    public void BubbleSorting(){
        for (int i = 0; i < nElemen; i++) {
                int batas, j;
                for (batas = nElemen-1; batas > 0; batas--) {
                    for (j = 0; j < batas; j++) {
                        if (mhs[j].getNim() > mhs[j+1].getNim()) {
                            swap(j, j+1);
                        }
                    }
                }
        }
    }
    
    
    //SelectionSort
    public void SelectionSorting(){
        int awal, i, min;
        
        for (awal = 0; awal < nElemen-1; awal++) {
            min = awal;
            for (i = awal+1; i < nElemen; i++) {
                if (mhs[i].getNim() < mhs[min].getNim()) {
                    min = i;
                }
            }
            swap(awal,min);
        }
    }
    
    //InsertionByNameSorting
    public void InsertionByName(){
        int i, curIn;
        
        for (curIn = 0; curIn < nElemen; curIn++) {
            Mahasiswa temp = mhs[curIn];
            
            i = curIn;
            while(i > 0 && mhs[i-1].getNama().compareTo(temp.getNama()) > 0){
                mhs[i] = mhs[i-1];
                i--;
            }
            mhs[i] = temp;
        }
    }
    
}
