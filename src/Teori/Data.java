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

public class Data {
    String id, nama, alamat;
    Data Next;
    Data Prev;
    
    public Data(String id, String nama, String alamat){
        this.id = id;
        this.nama = nama;
        this.alamat = alamat;
    }
    
    public static void main(String[] args) {
        Data dt1 = new Data("P01","Budi","Malaysia");
        Data dt2 = new Data("P02","Ali","Surabaya");
        Data dt3 = new Data("P03","Cari","Blitar");
        
        Queue ll = new Queue();
        ll.Push(dt1);
        ll.Push(dt2);
        ll.Push(dt3);
        
        System.out.println(ll.toString());
        System.out.println("\n");
        
        Data dtTemp = ll.Pop();
        System.out.println("Data Diambil : "+dtTemp.nama);
        System.out.println(ll.toString());
        System.out.println("");
        
        dtTemp = ll.Pop();
        System.out.println("Data Diambil : "+dtTemp.nama);
        System.out.println(ll.toString());
        System.out.println("");
        
        dtTemp = ll.Pop();
        System.out.println("Data Diambil : "+dtTemp.nama);
        System.out.println(ll.toString());
        System.out.println("");
        
//        dtTemp = ll.Pop();
//        System.out.println("Data Diambil : "+dtTemp.nama);
//        System.out.print(ll.toString());
//        System.out.println("");
    }
}

class Queue{
    Data Head = null;
    Data Tail = null;
    
    public void Push(Data Node){
        if (Head == null && Tail == null) {
            Head = Node;
            Tail = Node;
        } else {
            Tail.Next = Node;
            Tail = Node;
        }
    }
    
    @Override
    public String toString(){
        String strData = "";
        Data temp = Head;
        
        while (temp != null){
            strData += temp.nama+", ";
            temp = temp.Next;
        }
        return strData;
    }
    
    public Data Pop(){
        if (Head == null) 
            return null;
        Data temp = Head;
        Head = Head.Next;
        return temp;
    }
}

class Stack{
    Data Head = null;
    Data Tail = null;
    
    public void Push(Data Node){
        if (Head == null && Tail == null) {
            Head = Node;
            Tail = Node;
        } else {
            Head.Prev = Node;
            Head = Node;
        }
    }
    
    @Override
    public String toString(){
        String strData = "";
        Data temp = Head;
        
        while (temp != null){
            strData += temp.nama+", ";
            temp = temp.Next;
        }
        return strData;
    }
    
    public Data Pop(){
        if (Head == null) 
            return null;
        Data temp = Head;
        Head = Head.Next;
        return temp;
    }
}