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
public class Func_Q15_LargestBST {
    //Count the total no. of nodes in the largest subtree of BST
    
    //PostOrder traversal
//Left Right and Root
static class Node{
    Node l;
    Node r;
    int data;
    Node (int d){
        data = d;
    }
}

//we will do a post order traversal. at every return we will return whether that subtree is a BST
//also return what is the height at that BST, and what should be the range of values for upper nodes to be in BST

static class BSTInfo{
 boolean isBST = true;
 int min = Integer.MIN_VALUE;
 int max = Integer.MAX_VALUE;
 int totalSize = 0;//total no. of nodes. always remember 1 node ontribute to one path or edje
 
 BSTInfo(boolean isBST, int min, int max, int h){
     this.isBST = isBST;
     this.min = min;
     this.max = max;
     this.totalSize = h;
 }    
        public BSTInfo() {
        
        }
}

public static BSTInfo postOrder(Node x){
BSTInfo li = new BSTInfo();
BSTInfo ri = new BSTInfo();

if (x==null) return new BSTInfo();
System.out.println("visiting node "+ x.data);

if (x.l!=null) li = postOrder(x.l);
//started returning from leftmost trees

if (x.r!=null) ri = postOrder(x.r);
//started returning from righmost trees

BSTInfo cur = new BSTInfo();

if(li!=null) {cur.min = x.l!=null?x.l.data:li.min; } 
if(ri!=null) {cur.max = x.r!=null?x.r.data:li.max; }

if(x.data>cur.min && x.data<cur.max) cur.isBST=true;
else cur.isBST = false;

cur.isBST = cur.isBST && li.isBST && ri.isBST ;

if (cur.isBST) cur.totalSize = li.totalSize + ri.totalSize + 1;//total no. of nodes in binary tree
else cur.totalSize = Math.max(li.totalSize, ri.totalSize);

    System.out.println("cur at node "+ x.data +" h="+ cur.totalSize+ " min "+ cur.min + " max "+ cur.max + " isBST "+ cur.isBST);

return cur;

}

public static void main(String args[]){
    Node a = new Node(10);
    a.l = new Node(5);
    a.l.l = new Node(1);
    a.l.l.r = new Node(2);
    //a.l.r = new Node(7); uncomment to check, will reduce height by 1
    a.l.r = new Node(7);//comment if upper is uncommented.
    a.l.r.r = new Node(8);
    a.l.r.r.r = new Node(9);
    
    BSTInfo inf= postOrder(a);
    //System.out.println(""+inf.isBST+" : "+inf.totalSize);
}
    
}
