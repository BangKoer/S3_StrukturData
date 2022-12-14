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

class HighArray{

    private int[] arr;
    private int nElemen;
    
    public HighArray(int max){
        arr = new int[max];
        nElemen = 0;
    }
    
    public void insert(int value){
        arr[nElemen] = value;
        nElemen++;
        
        
        // sort
//        for (int i = 0; i < nElemen; i++) {
//            for (int j = i+1; j < nElemen; j++) {
//                if (arr[i] > arr[j]) {
//                    int temp = arr[i];
//                    arr[i] = arr[j];
//                    arr[j] = temp;
//                }
//            }
//        }
    }
    
    public void InsertionSort(){
        int i, curIn;
        
        for (curIn = 0; curIn < nElemen; curIn++) {
            int temp = arr[curIn];
            
            i = curIn;
            while(i > 0 && arr[i-1] >= temp){
                arr[i] = arr[i-1];
                i--;
//                display();
            }
//            System.out.println("Setelah arr[i] = arr[i-1]");
            arr[i] = temp;
                display();
        }
//        System.out.println("Setelah arr[i] = temp");display();
    }
    
    public void BubbleSort(){
        int batas, i;
        
        for (batas = nElemen-1; batas > 0; batas--) {
            for (i = 0; i < batas; i++) {
                if (arr[i] > arr[i+1]) {
                    swap(i, i+1);
                    display();
                }
            }
        }
    }
    
    public void SelectionSort(){
        int awal, i, min;
        
        for (awal = 0; awal < nElemen-1; awal++) {
            min = awal;
            for (i = awal+1; i < nElemen; i++) {
                if (arr[i] < arr[min]) {
                    min = i;
                }
            }
            swap(awal,min);
            display();
        }
    }
    
    public void swap(int one, int two){
        int temp = arr[one];
        arr[one] = arr[two];
        arr[two] = temp;
    }
    
    public boolean find(int key){
        int i;
        for (i = 0; i < nElemen; i++) {
            if (arr[i] == key) {
                break;
            }
        }
        if (i == nElemen) {
            return false;
        } else {
            return true;
        }
    }
    
    public void BinaryFind(int key){
        int i;
        int mid = nElemen/2;
        boolean ketemu = false;
        
        if (key == arr[mid]) {
            System.out.println("Nilai "+key+" ketemu di "+mid);
        } else {
            if (key < arr[mid]) {
                for (i = mid-1; i > 0; i--) {
                    if (key == arr[i]) {
                        System.out.println("Nilai "+key+" ketemu di "+i);
                        ketemu = true;
                        break;
                    }
                }
            } else {
                if(key > arr[mid]){
                    for (i = mid+1; i < nElemen; i++) {
                        if (key == arr[i]) {
                            System.out.println("Nilai "+key+" ketemu di "+i);
                            ketemu = true;
                            break;
                        }
                    }
                }
            }
        } if (ketemu = false){
            System.out.println("Nilai "+key+" tidak ketemu");
        }
    }
    
    public boolean delete(int value){
        int i;
        for (i = 0; i < nElemen; i++) {
            if (value == arr[i]) {
                break;
            }
        }
        if (i == nElemen) {
            return false;
        } else {
            for (int j = i; j < nElemen; j++) {
                arr[j] = arr[j+1];
            }
            nElemen--;
            return true;
        }
    }
    
    public void display(){
        for (int i = 0; i < nElemen; i++) {
            System.out.print(arr[i]+" ");
        }
        System.out.println("");
    }
    
    
    public int size(){
        return nElemen;
    }
}

public class HighArrayApp {
    public static void main(String[] args) {
        int maxSize = 100;
        HighArray arr;
        arr = new HighArray(maxSize);
        
        arr.insert(70);
        arr.insert(80);
        arr.insert(75);
        arr.insert(55);
        arr.insert(85);
        arr.insert(25);
//        arr.insert(30);
//        arr.insert(00);
//        arr.insert(90);
//        arr.insert(40);
        
        arr.display();
        
        int key = 25;
        if (arr.find(key)) {
            System.out.println(key + " ditemukan");
        } else {
            System.out.println(key + " ditemukan");
        }
        
        System.out.println(arr.size());
        
//        System.out.println("=======================Ini Binnary Find=======================");
//        arr.BinaryFind(key);
        
//        arr.delete(00);
//        arr.delete(80);
//        arr.delete(55);
//        arr.display();    
        System.out.println("=======================Ini BubbleSort=======================");
//        arr.BubbleSort(); 
        
        System.out.println("=======================Ini SelectionSort=======================");
//        arr.SelectionSort();
        
        System.out.println("=======================Ini InsertionSort=======================");
        arr.InsertionSort();
    }
}


