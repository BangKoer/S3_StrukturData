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
class Link {

    private int iData;
    public Link next;

    public Link(int iData) {
        this.iData = iData;
    }

    public int getKey() {
        return iData;
    }

    public void displayLink() {
        System.out.print(iData + " ");
    }
}

class SortedLinkList {

    private Link first;

    public SortedLinkList() {
        first = null;
    }

    public void insert(Link theLink) {
        int key = theLink.getKey();
        Link previous = null;
        Link current = first;
        while (current != null && key > current.getKey()) {
            previous = current;
            current = current.next;
        }
        if (previous == null) {
            first = theLink;
        } else {
            previous.next = theLink;
        }
        theLink.next = current;
    }

    public void delete(int key) {
        Link previous = null;
        Link current = first;
        while (current != null && key != current.getKey()) {
            previous = current;
            current = current.next;
        }
        if (previous == null) {
            first = first.next;
        } else {
            previous.next = current.next;
        }
    }

    public Link find(int key) {
        Link current = first;
        while (current != null && current.getKey() <= key) {
            if (current.getKey() == key) {
                return current;
            }
            current = current.next;
        }
        return null;
    }

    public void displayList() {
        System.out.print("List (first-->last): ");
        Link current = first;
        while (current != null) {
            current.displayLink();
            current = current.next;
        }
        System.out.println("");
    }
}

class HTableOpenHash {

    private SortedLinkList[] hashArray;
    private int size;

    public HTableOpenHash(int size) {
        this.size = size;
        hashArray = new SortedLinkList[size];
        for (int i = 0; i < size; i++) {
            hashArray[i] = new SortedLinkList();
        }
    }

    public void displayTable() {
        System.out.println("Table: ");
        for (int j = 0; j < size; j++) {
            System.out.print(" " + j + ". ");
            hashArray[j].displayList();
        }
    }

    public int hashFunc(int key) {
        return key % size;
    }

    public void insert(int data) {
        Link theLink = new Link(data);
        int key = theLink.getKey();
        int hashVal = hashFunc(key);
        hashArray[hashVal].insert(theLink);
    }

    public void delete(int key) {
        int hashVal = hashFunc(key);
        hashArray[hashVal].delete(key);
    }

    public Link find(int key) {
        int hashVal = hashFunc(key);
        Link theLink
                = hashArray[hashVal].find(key);
        return theLink;
    }
}

public class HTableOpenHashApp {
    public static void main(String[] args) {
        HTableOpenHash hta = new HTableOpenHash(15);
        System.out.println("Default");
        hta.insert(15);
        hta.insert(16);
        hta.insert(17);
        hta.insert(18);
        hta.insert(19);
        hta.insert(20);
        hta.insert(21);
        hta.insert(22);
        hta.insert(23);
        hta.insert(25);
        hta.displayTable();
        
        System.out.println("Setelah");
        hta.insert(24);
        hta.insert(26);
        hta.insert(27);
        hta.insert(28);
        hta.insert(29);
        hta.displayTable();
    }
}
