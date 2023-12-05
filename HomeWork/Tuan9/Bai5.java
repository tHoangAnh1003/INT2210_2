package HomeWork.Tuan9;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;


class Node_BST 
{
    int val;
    Node_BST left, right;

    public Node_BST(int x) {
        val = x;
        left = right = null;
    }
}


class BinarySearchTree 
{
    Node_BST root;
    
    public BinarySearchTree() {
        root = null;
    }
    
    
    void insert(int key) {
        root = insertRec(root, key);
    }
    
  
    Node_BST insertRec(Node_BST root, int key) {
        
        if (root == null) {
            root = new Node_BST(key);
            return root;
        }

        
        if (key < root.val)
            root.left = insertRec(root.left, key);
       
        else if (key > root.val)
            root.right = insertRec(root.right, key);

        return root;
    }

     
    void preorder() {
        preorderRec(root);
    }

    
    void preorderRec(Node_BST root) {
        if (root != null) {
            System.out.print(root.val + " ");
            preorderRec(root.left);
            preorderRec(root.right);
        }
    }
}

public class Bai5
{
    public static void main(String[] args) 
    {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        ArrayList<Integer> arr=new ArrayList<>();
        for(int i=0;i<n;i++)
            arr.add(sc.nextInt());
        
        
        BinarySearchTree tree = new BinarySearchTree();
        for (int i = 0; i < n; i++) {
            tree.insert(arr.get(i));
        }

        tree.preorder();
    }     
}
