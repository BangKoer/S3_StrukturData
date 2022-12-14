/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Teori;

/**
 *
 * @author Lenovo V14
 */
public class Recursive {
    
    
    public int factorial(int input){
        if (input == 1) {
            return 1;
        } else {
            return input * factorial(input - 1);
        }
    }
    
    
    public static void main(String[] args) {
        Recursive recfactorial = new Recursive();
        System.out.println(recfactorial.factorial(4));
    }
}
