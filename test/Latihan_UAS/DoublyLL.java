/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Latihan_UAS;

class Link {

    public long nim;
    public double score;
    public Link next;
    public Link previous;

    public Link(long nim, double score) {
        this.nim = nim;
        this.score = score;
    }

    public void displayLink() {
         System.out.println("{"+nim + ", "+score+"}");
    }
}

class DoublyLinkedList {

    private Link first;
    private Link last;
    public double total;
    public int nElemen = 0;

    public DoublyLinkedList() {
        first = null;
        last = null;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public void insertFirst(long nim, double score) {
        Link newLink = new Link(nim, score);
        if (isEmpty()) {
            last = newLink;
        } else {
            first.previous = newLink;
        }
        newLink.next = first;
        first = newLink;
        total += newLink.score;
        nElemen++;
    }

    public void insertLast(long nim, double score) {
        Link newLink = new Link(nim, score);
        if (isEmpty()) {
            first = newLink;
        } else {
            last.next = newLink;
            newLink.previous = last;
        }
        last = newLink;
        total += newLink.score;
        nElemen++;
    }

    public Link deleteFirst() {
        Link temp = first;
        if (first.next == null) {
            last = null;
        } else {
            first.next.previous = null;
        }
        first = first.next;
        return temp;
    }

    public Link deleteLast() {
        Link temp = last;
        if (first.next == null) {
            first = null;
        } else {
            last.previous.next = null;
        }
        last = last.previous;
        return temp;
    }
    
    public double Mean(){
        return total/nElemen;
    }

//    public boolean insertAfter(int key, int Data) {
//        Link current = first;
//        while (current.Data != key) {
//            current = current.next;
//            if (current == null) {
//                return false;
//            }
//        }
//        Link newLink = new Link(Data);
//        if (current == last) {
//            newLink.next = null;
//            last = newLink;
//        } else {
//            newLink.next = current.next;
//            current.next.previous = newLink;
//        }
//        newLink.previous = current;
//        current.next = newLink;
//        return true;
//    }

//    public Link deleteKey(int key) {
//        Link current = first;
//        while (current.Data != key) {
//            current = current.next;
//            if (current == null) {
//                return null;
//            }
//        }
//        if (current == first) {
//            first = current.next;
//        } else {
//            current.previous.next
//                    = current.next;
//        }
//        if (current == last) {
//            last = current.previous;
//        } else {
//            current.next.previous
//                    = current.previous;
//        }
//        return current;
//    }

    public void displayForward() {
//        System.out.print("Stack (top --> bottom): \n");
        Link current = first;
        while (current != null) {
            current.displayLink();
            current = current.next;
        }
        System.out.println("");
    }

    public void displayBackward() {
//        System.out.print("List (last-->first): \n");
        Link current = last;
        while (current != null) {
            current.displayLink();
            current = current.previous;
        }
        System.out.println("");
    }
}

public class DoublyLL {

    public static void main(String[] args) {
        DoublyLinkedList d1 = new DoublyLinkedList();
        System.out.println("Daftar Nilai Mahasiswa :");
        d1.insertLast(1765027, 100.0);
        d1.insertLast(1765009, 95.6);
        d1.insertLast(1765019, 95.0);
        d1.insertLast(1765013, 85.5);
        d1.insertLast(1765025, 80.0);
        d1.insertLast(1765035, 75.0);
        d1.insertLast(1765010, 70.3);
        d1.insertLast(1765023, 60.5);
        d1.insertLast(1765029, 55.5);
        d1.insertLast(1765011, 52.7);
        d1.displayForward();
        System.out.println("Mean : "+d1.Mean());
        
        
        
        
//        d1.insertFirst(1, "VCD");
//        d1.insertFirst(2, "TV");
//        d1.insertFirst(3, "TV3");
//        d1.insertFirst(4, "TV4");
//        d1.deleteFirst();
//        d1.displayForward();
    }
}
