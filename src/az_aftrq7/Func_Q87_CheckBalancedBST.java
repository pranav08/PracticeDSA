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
public class Func_Q87_CheckBalancedBST {

    private static int isBalancedBST(Node root) {
       int l = 0,r = 0;
       if (root.L==null && root.R==null) return 1;//lead node
       if (root.L!=null) 
           l = isBalancedBST(root.L);//calculate height for left tree first
       if (root.R!=null) 
           r = isBalancedBST(root.R);//calculate height of right tree first
       if (l==r) return l+1;
       if (l-r==1 || l-r==-1) return l>r?l+1:r+1;
    return -99;
    
}
    static class Node {
        int data;
        Node(int d){ this.data = d; }
        Node L,R;
    }
    
    public static void main(String[] args) {
//This is a balanced tree
        Node root = new Node(3);
        Node l1 = new Node(1);
        l1.L=new Node (0);
        l1.R = new Node (2);
        root.L = l1;
        root.R = new Node(5);
        root.R.L = new Node(4);
 // THe below is unbalanced tree
        Node root2 = new Node(0);
        root2.L = new Node(1);
        root2.L.L =new Node(3);
        root2.L.R = new Node(4);
        root2.L.L.R = new Node(1);
        root2.L.L.R.R = new Node(4);
        
        root2.R = new Node(2);
        root2.R.L = new Node(5);
        //Returns -99 if unbalanced
        System.out.println(""+isBalancedBST(root));
        System.out.println(""+isBalancedBST(root2));
        
    }
    
    
}
