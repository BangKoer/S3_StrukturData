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
class data {

    int id;
    String nama;
    data left_child;
    data right_child;
    data parrent;

    public data(String nama, int id) {
        this.nama = nama;
        this.id = id;
    }
}


public class Binary_tree {
    data root = null;

    public void add_tree(data data) {
        if (root == null) {
            root = data;
            data.parrent = root;
        } else {
            boolean stop = false;
            data temp = root;
            while (!stop) {
                if (data.id < temp.id) {
                    if (temp.left_child == null) {
                        temp.left_child = data;
                        data.parrent = temp;
                        stop = true;
                    } else {
                        temp = temp.left_child;
                    }
                } else {
                    if (temp.right_child == null) {
                        temp.right_child = data;
                    } else {
                        temp = temp.right_child;
                    }
                }
            }
        }
        
//        else {
//            data temp = root;
//            if (temp.left_child == null) {
//                if (node.tinggi < temp.tinggi) {
//                    temp.left_child = node;
//                    temp = temp.left_child;
//                }
//            } else if (temp.right_child == null) {
//                if (node.tinggi > temp.tinggi) {
//                    temp.right_child = node;
//                    temp = temp.right_child;
//                }
//            }
//        }
    }
    
    String str;
    public void display(){
        ShowAll(root);
        System.out.println(str);
    }
    public void ShowAll(data dt){
        if (dt.left_child != null)
            ShowAll(dt.left_child);        
         if (dt.right_child != null) 
             ShowAll(dt.right_child);
    }

    public data search(int key) {
        data temp = root;
        while (temp != null) {
            if (key == temp.id) {
                return temp;
            } else if (key < temp.id) {
                temp = temp.left_child;
            } else {
                temp = temp.right_child;
            }

        }
//           while(current.id != key){
//               if (key < current.id) {
//                   current = current.left_child;
//               } else {
//                   current = current.right_child;
//               }
//           }
        return temp;
    }
    
    public data delete(int delKey){
        data tempDel = search(delKey);
        if (tempDel != null) {
            if (tempDel.right_child == null) {
                if (tempDel.left_child != null) {
                    tempDel.parrent.left_child = null;
                    tempDel.parrent = null;
                } else {
                    tempDel.parrent.left_child = tempDel.left_child;
                    tempDel.left_child.parrent = tempDel.parrent;
                    tempDel.left_child = null;
                }
            } else {
                
            }
            data tempData = tempDel.right_child;
            tempData.parrent = tempDel.parrent;
            tempDel.parrent.left_child = tempData;
            
            tempDel.right_child = null;
            
            data tempLData  = tempData.left_child;
            tempData.left_child = null;
            if (tempData.left_child == null) {
                tempData.left_child = tempLData;
                tempLData.parrent = tempData;
            }
        } 
        
        return tempDel;
    }
    
    
        
    public static void main(String[] args) {
        data dt1 = new data("Ahmad",  1);
        data dt2 = new data("Ahmad2", 2);
        data dt3 = new data("Ahmad3", 3);
        data dt4 = new data("Ahmad4", 4);
        
        Binary_tree btree = new Binary_tree();
        btree.add_tree(dt1);
        btree.add_tree(dt2);
        btree.add_tree(dt3);
        btree.add_tree(dt4);
        
        btree.ShowAll(btree.root);
        btree.display();
        
    }
}
