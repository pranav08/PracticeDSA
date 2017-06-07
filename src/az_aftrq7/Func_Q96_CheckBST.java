/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package az_aftrq7;

/**
 *
 * @author pranav.nandan
 */
public class Func_Q96_CheckBST {
    
    static class Node {
        int data;
        Node(int d){ this.data = d; }
        Node L,R;
    }
    
    public static void main(String[] args) {
        Node root = new Node(5);
        Node l1 = new Node(2);
        l1.L=new Node (1);
        l1.R = new Node (3);
        root.L = new Node(4);
        root.L.L = l1;
        root.R = new Node(6);
        root.R.R = new Node (7);
        //inOrder(root);
        System.out.println(""+isBST(root, -999,999));
        root.L.R = new Node(8);
        System.out.println(""+isBST(root, -999,999));
        
        //
        
        
    }
    
    public static boolean isBST(Node root, int min, int max){
        if (root==null) return true;
        
        if (root.data<=min || root.data>=max) return false;
        if (root.L!=null && root.L.data>=root.data) return false;
        if (root.R!=null && root.R.data<=root.data) return false;
        
        boolean lb = true, rb =true;
        if (root.L!=null) lb = isBST(root.L, min, root.data);//the maxim no. in left subtree should never exceed the current node value.
        if (root.R!=null) rb = isBST(root.R, root.data, max);//the minm in right sub tree should always be 
        return lb & rb;
        
    }
    
    public static void inOrder(Node r){
        if (r.L!=null) { inOrder(r.L );}
        System.out.println(""+r.data);
        if (r.R!=null) { inOrder(r.R);}
    }
    
    
}
