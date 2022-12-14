/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modul_7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/**
 *
 * @author Lenovo V14
 */
class Node {
    public int id;
    public String data;
    public Node leftChild;
    public Node rightChild;

    public void displayNode() {
        System.out.print("{ " + id + ", " + data + " } ");
    }
}

class Tree {
        Node root;

        public Tree() {
            root = null;
        }

        public Node find(int key) {
            Node current = root;
            while (current.id != key) {
                if (key < current.id) {
                    current = current.leftChild;
                } else {
                    current = current.rightChild;
                }
                if (current == null) {
                    return null;
                }
            }
            return current;
        }
        
        int findMax (Node root){
            if(root==null)
                return Integer.MIN_VALUE;
            
            int max = root.id;
            int Lmax = findMax(root.leftChild);
            int Rmax = findMax(root.rightChild);
            
            if(Lmax > max)
                max = Lmax;
            if(Rmax > max)
                max = Rmax;
            return max;
        }
        
        int findMin (Node root){
            if(root==null)
                return Integer.MAX_VALUE;
            
            int min = root.id;
            int Lmin = findMin(root.leftChild);
            int Rmin = findMin(root.rightChild);
            
            if(Lmin < min)
                min = Lmin;
            if(Rmin < min)
                min = Rmin;
            return min;
        }
        
        public boolean checkDup(int key){
            Node current = root;
            while(current.id != key){
                if(key < current.id)
                    current = current.leftChild;
                else
                    current = current.rightChild;
                if(current == null)
                    return false;
            }
            return true;
        }
        
        public void insert(int id, String data) {
            Node newNode = new Node();
            newNode.id = id;
            newNode.data = data;
            if (root == null) {
                root = newNode;
            } else {
                if (checkDup(id)){
                    System.out.println("Tidak boleh ada data yang sama");
                } else {
                Node current = root;
                Node parent;
                while (true) {
                    parent = current;
                    if (id < current.id) {
                        current = current.leftChild;
                        if (current == null) {
                            parent.leftChild = newNode;
                            return;
                        }
                    } else {
                        current = current.rightChild;
                        if (current == null) {
                            parent.rightChild = newNode;
                            return;
                        }
                    }
                }
            }
        }
    }
        public boolean delete(int key) {
            Node current = root;
            Node parent = root;
            boolean isLeftChild = true;
            while (current.id != key) {
                parent = current;
                if (key < current.id) {
                    isLeftChild = true;
                    current = current.leftChild;
                } else {
                    isLeftChild = false;
                    current = current.rightChild;
                }
                if (current == null) {
                    return false;
                }
            }
            if (current.leftChild == null
                    && current.rightChild == null) {
                if (current == root) {
                    root = null;
                } else if (isLeftChild) {
                    parent.leftChild = current.leftChild;
                } else {
                    parent.rightChild = current.leftChild;
                }
            } else if (current.rightChild == null) {
                if (current == root) {
                    root = current.leftChild;
                } else if (isLeftChild) {
                    parent.leftChild = current.leftChild;
                } else {
                    parent.rightChild = current.leftChild;
                }
            } else if (current.leftChild == null) {
                if (current == root) {
                    root = current.rightChild;
                } else if (isLeftChild) {
                    parent.leftChild = current.rightChild;
                } else {
                    parent.rightChild = current.rightChild;
                }
            } else {
                Node successor = getSuccessor(current);
                if (current == root) {
                    root = successor;
                } else if (isLeftChild) {
                    parent.leftChild = successor;
                } else {
                    parent.rightChild = successor;
                }
                successor.leftChild = current.leftChild;
            }
            return true;
        }

        private Node getSuccessor(Node delNode) {
            Node successorParent = delNode;
            Node successor = delNode;
            Node current = delNode.rightChild;
            while (current != null) {
                successorParent = successor;
                successor = current;
                current = current.leftChild;
            }
            if (successor != delNode.rightChild) {
                successorParent.leftChild = successor.rightChild;
                successor.rightChild = delNode.rightChild;
            }
            return successor;
        }

        public void traverse(int traverseType) {
            switch (traverseType) {
                case 1:
                    System.out.print("Preorder traversal: ");
                    preOrder(root);
                    break;
                case 2:
                    System.out.print("Inorder traversal: ");
                    inOrder(root);
                    break;
                case 3:
                    System.out.print("Postorder traversal: ");
                    postOrder(root);
                    break;
            }
            System.out.println();
        }

        private void preOrder(Node localRoot) {
            if (localRoot != null) {
                System.out.print(localRoot.id + " ");
                preOrder(localRoot.leftChild);
                preOrder(localRoot.rightChild);
            }
        }

        private void inOrder(Node localRoot) {
            if (localRoot != null) {
                inOrder(localRoot.leftChild);
                System.out.print(localRoot.id + " ");
                inOrder(localRoot.rightChild);
            }
        }

        private void postOrder(Node localRoot) {
            if (localRoot != null) {
                postOrder(localRoot.leftChild);
                postOrder(localRoot.rightChild);
                System.out.print(localRoot.id + " ");
            }
        }

        public void displayTree() {
            Stack globalStack = new Stack();
            globalStack.push(root);
            int nBlanks = 32;
            boolean isRowEmpty = false;
            System.out.println(
                    "............................................");
            while (isRowEmpty == false) {
                Stack localStack = new Stack();
                isRowEmpty = true;
                for (int j = 0; j < nBlanks; j++) {
                    System.out.print(' ');
                }
                while (globalStack.isEmpty() == false) {
                    Node temp = (Node) globalStack.pop();
                    if (temp != null) {
                        System.out.print(temp.id);
                        localStack.push(temp.leftChild);
                        localStack.push(temp.rightChild);
                        if (temp.leftChild != null
                                || temp.rightChild != null) {
                            isRowEmpty = false;
                        }
                    } else {
                        System.out.print("--");
                        localStack.push(null);
                        localStack.push(null);
                    }
                    for (int j = 0; j < nBlanks * 2 - 2; j++) {
                        System.out.print(' ');
                    }
                }
                System.out.println();
                nBlanks /= 2;
                while (localStack.isEmpty() == false) {
                    globalStack.push(localStack.pop());
                }
            }
            System.out.println(
                    "............................................");
        }
    }

public class TreeApp {

    public static void main(String[] args) throws IOException {
        int value;
        String data;
        Tree theTree = new Tree();
        theTree.insert(50, "Ahmad");
        theTree.insert(25, "Rosa");
        theTree.insert(75, "Raisa");
        theTree.insert(12, "Naya");
        theTree.insert(37, "Gagas");
        theTree.insert(43, "Ainun");
        theTree.insert(30, "Beri");
        theTree.insert(33, "Vivid");
        theTree.insert(87, "Orin");
        theTree.insert(93, "Wiwid");
        theTree.insert(97, "Sasa");
        while (true) {
            System.out.print("Enter first letter of show, "
                    + "insert, find, delete, Max, Min, or traverse: ");
            int choice = getChar();
            switch (choice) {
                case 's':
                    theTree.displayTree();
                    break;
                case 'i':
                    System.out.print("Enter value and data to"
                            + " insert: ");
                    value = getInt();
                    data = getString();
                    theTree.insert(value, data);
                    break;
                case 'f':
                    System.out.print("Enter value to find: ");
                    value = getInt();
                    Node found = theTree.find(value);
                    if (found != null) {
                        System.out.print("Found: ");
                        found.displayNode();
                        System.out.print("\n");
                    } else {
                        System.out.println("Could not find "
                                + value);
                    }
                    break;
                case 'd':
                    System.out.print("Enter value to delete: ");
                    value = getInt();
                    boolean didDelete = theTree.delete(value);
                    if (didDelete) {
                        System.out.println("Deleted " + value);
                    } else {
                        System.out.println("Could not delete "
                                + value);
                    }
                    break;
                case 't':
                    System.out.print("Enter type 1, 2 or 3: ");
                    value = getInt();
                    theTree.traverse(value);
                    break;
                case 'm':
                    
                    System.out.println("Max number is : "+theTree.findMax(theTree.root));
                    break;
                case 'n':
                    System.out.println("Min number is : "+theTree.findMin(theTree.root));
                    break;
                case 'z':
                    break;
                default:
                    System.out.println("Invalid entry ");
            }
        }
    }

    public static String getString() throws IOException {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        String s = br.readLine();
        return s;
    }

    public static char getChar() throws IOException {
        String s = getString();
        return s.charAt(0);
    }

    public static int getInt() throws IOException {
        String s = getString();
        return Integer.parseInt(s);
    }
}