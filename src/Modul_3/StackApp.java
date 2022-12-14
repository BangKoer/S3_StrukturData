/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modul_3;

/**
 *
 * @author Lenovo V14
 */
class Stack{
    private int maxSize;
    private long[] stackArray;
    private int top;
    
    public Stack(int size){
        maxSize = size;
        stackArray = new long[maxSize];
        top = -1;
    }
    
    public void push(long item){
        stackArray[++top] = item;
    }
    
    public long pop(){
        return stackArray[top--];
    }
    
    public long peek(){
        return stackArray[top];
    }
    
    public boolean isEmpty(){
        return (top == -1);
    }
    
    public boolean isFull(){
        return (top == maxSize -1);
    }
}

public class StackApp {
    public static void main(String[] args) {
        Stack theStack = new Stack(10);
        System.out.println(">> Push some items");
        theStack.push(20);
        theStack.push(40);
        theStack.push(60);
        theStack.push(80);
        
        System.out.println("\n>> Pop items in the stack");
        while(!theStack.isEmpty()){
            long value = theStack.pop();
            System.out.print(value + " ");
        }
        System.out.println("");
    }
}
