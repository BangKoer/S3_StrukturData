/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modul_4;

class Link {

    public int id;
    public String nama;
    public Link next;
    public Link previous;

    public Link(int id, String nama) {
        this.id = id;
        this.nama = nama;
    }

    public void displayLink() {
         System.out.println("{"+id + ", "+nama+"}");
    }
}

class DoublyLinkedList {

    private Link first;
    private Link last;

    public DoublyLinkedList() {
        first = null;
        last = null;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public void push(int id, String nama) {
        Link newLink = new Link(id, nama);
        if (isEmpty()) {
            last = newLink;
        } else {
            first.previous = newLink;
        }
        newLink.next = first;
        first = newLink;
    }

//    public void insertLast(int id, String nama) {
//        Link newLink = new Link(id, nama);
//        if (isEmpty()) {
//            first = newLink;
//        } else {
//            last.next = newLink;
//            newLink.previous = last;
//        }
//        last = newLink;
//    }

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
        System.out.print("Stack (top --> bottom): \n");
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

public class Stack_LinkedListApp {

    public static void main(String[] args) {
        DoublyLinkedList d1 = new DoublyLinkedList();
        d1.push(1, "VCD");
        d1.push(2, "TV");
        d1.deleteFirst();
        d1.display();
    }
}
