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
public class Pendahuluan1 {

    /**
     * @param args the command line arguments
     */
    
    private void listcode_1(){
        int[] array = new int[10];
        array[0] = 10;
        array[1] = 20;
        array[2] = 30;
        array[3] = 40;
        array[4] = 50;
        
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] +" ");
        }
        System.out.println("");
        
        array = new int[20];
        
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]+" ");
        }
        System.out.println("");
        
        String[] array2 = new String[2];
        array2[0] = "makan";
        array2[1] = "minum";
//        array2[2] = "nongkrong";
        
        for (int i = 0; i < array2.length; i++) {
            System.out.print(array2[i] +" ");
        }
        System.out.println("");
    
    } 
    
    private void listcode_2(){
        int[] array = new int[100];
        int nElemen = 0;
        array[0] = 30;
        array[1] = 20;
        array[2] = 60;
        array[3] = 70;
        array[4] = 50;
        array[5] = 10;
        
        nElemen = 6;
        for (int i = 0; i < nElemen; i++) {
            System.out.print(array[i]+" ");
        }
        System.out.println("");
        
    }
    
    public static void main(String[] args) {
        // TODO code application logic here
        Pendahuluan1 l1 = new Pendahuluan1();
        l1.listcode_1();
//        l1.listcode_2();
    }
    
}
