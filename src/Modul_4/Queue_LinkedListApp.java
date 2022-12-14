/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modul_4;

/**
 *
 * @author LAB PROGRAMMING 1
 */
class QueueLink {

    public int nim;
    public String nama;
    public Link next;
    public Link previous;

    public QueueLink(int nim, String nama) {
        this.nim = nim;
        this.nama = nama;
    }

    public void displayLink() {
         System.out.println("{"+nim + ", "+nama+"}");
    }
}

class DoublyLinkList_Queue{
    private Link first;
    private Link last;

    public DoublyLinkList_Queue() {
        first = null;
        last = null;
    }

    public boolean isEmpty() {
        return first == null;
    }

//    public void push(int id, String nama) {
//        Link newLink = new Link(id, nama);
//        if (isEmpty()) {
//            last = newLink;
//        } else {
//            first.previous = newLink;
//        }
//        newLink.next = first;
//        first = newLink;
//    }

    public void insert(int nim, String nama) {
        Link newLink = new Link(nim, nama);
        if (isEmpty()) {
            first = newLink;
        } else {
            last.next = newLink;
            newLink.previous = last;
        }
        last = newLink;
    }

    public Link remove() {
        Link temp = first;
        if (first.next == null) {
            last = null;
        } else {
            first.next.previous = null;
        }
        first = first.next;
        return temp;
    }

//    public Link deleteLast() {
//        Link temp = last;
//        if (first.next == null) {
//            first = null;
//        } else {
//            last.previous.next = null;
//        }
//        last = last.previous;
//        return temp;
//    }

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

    public void display() {
        System.out.print("Queue (top --> bottom): \n");
        Link current = first;
        while (current != null) {
            current.displayLink();
            current = current.next;
        }
        System.out.println("");
    }

//    public void displayBackward() {
//        System.out.print("List (last-->first): \n");
//        Link current = last;
//        while (current != null) {
//            current.displayLink();
//            current = current.previous;
//        }
//        System.out.println("");
//    }
}

public class Queue_LinkedListApp {

    public static void main(String[] args) {
        DoublyLinkList_Queue d2 = new DoublyLinkList_Queue();
        d2.insert(1665100, "Dee");
        d2.insert(1665200, "Deaja");
        d2.insert(1665300, "Ami");
        d2.insert(1665400, "Haya");
        d2.insert(1665500, "Yati");
        d2.display();
        d2.remove();
        d2.display();
        
    }
}


