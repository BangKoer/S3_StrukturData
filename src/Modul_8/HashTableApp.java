/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modul_8;

/**
 *
 * @author Lenovo V14
 */
class Data {
    private int data;

    public Data(int data) {
        this.data = data;
    }
    public int getKey() {
        return data;
    }
}

class HashTable {
    private Data[] hashArray;
    private int size;

    public HashTable(int size) {
        this.size = size;
        hashArray = new Data[size];
    }

    public void displayTable() {
        System.out.println("Table: ");
        for (int j = 0; j < size; j++) {
            if (hashArray[j] != null) {
                System.out.println(" | " + j + "\t | "
                        + hashArray[j].getKey() + " |");
            } else {
                System.out.println(" | " + j + "\t | -- |");
            }
        }
        System.out.println("");
    }

    public int hashFunc(int key) {
        return key % size;
    }

    public void insert(int data) {
        Data item = new Data(data);
        int key = item.getKey();
        int hashVal = hashFunc(key);
//        while (hashArray[hashVal] != null) {
//            ++hashVal;
//            hashVal %= size;
//        }
        hashArray[hashVal] = item;
    }

    public Data delete(int key) {
        int hashVal = hashFunc(key);
        while (hashArray[hashVal] != null) {
            if (hashArray[hashVal].getKey() == key) {
                Data temp = hashArray[hashVal];
                hashArray[hashVal] = null;
                return temp;
            }
            ++hashVal;
            hashVal %= size;
        }
        return null;
    }

    public Data find(int key) {
        int hashVal = hashFunc(key);
        while (hashArray[hashVal] != null) {
            if (hashArray[hashVal].getKey()
                    == key) {
                return hashArray[hashVal];
            }
            ++hashVal;
            hashVal %= size;
        }
        return null;
    }
} //akhir class HashTable

public class HashTableApp{
    public static void main(String[] args) {
        HashTable ht = new HashTable(15);
        System.out.println("Default");
        ht.insert(15);
        ht.insert(16);
        ht.insert(17);
        ht.insert(18);
        ht.insert(19);
        ht.insert(20);
        ht.insert(21);
        ht.insert(22);
        ht.insert(23);
        ht.insert(25);
        ht.displayTable();
        
        System.out.println("Setelah");
        ht.insert(25);
        ht.insert(26);
        ht.insert(27);
        ht.insert(28);
        ht.insert(29);
        ht.displayTable();
        
       
    }
}
