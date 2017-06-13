package az_aftrq7;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author pranav.nandan
 */
public class Func_Q19_RemoveLoop_LinkList {
    
//Given a input linked list, detect presence of a loop, and if present, eliminate the loop.
//
//sample :  3 -> 4 -> 5 -> 6 -> 7 -> 5
//
//Write a function for the above.


static void detectLoopAndFix(Node x){
    Node p1; Node p2;
    p1 = x;
    p2 = x;//STRANGELY ENOUGH, YES THIS HAS TO START WITH X, AND NOT X.NEXT
    //otherwise it will fail for cases where no. of elements in loop is larger than elements before it
    while (true){
         System.out.println("Comparing "+p1.data+ " = "+ p2.data);
        if (p1==p2 && x!=p1) break;
        
        p1 = p1.next;
        p2 = p2.next.next;//fast pointer
       
    }
    System.out.println("Node is "+ p2.data);//always REMEMBER, this is not the collision point of link list, it may be any point in the common loop
    //BUT if we move this point forward, parallely with the actual head. We will reach at the starting of loop at same time.
    //That is INTERESTING mathematical property which can be proven.
    
    Node p3 = x;
    while(p3.next!=p1.next){
        p3=p3.next;
        p1=p1.next;
    }
    System.out.println("next is"+ p1.next.data);
    p1.next = null;
}

static class Node{
    int data;
    Node next;
    Node (int x){ this.data = x;}
}

static void print(Node x) {
    while(x!=null) {
        System.out.println(" Data is "+ x.data);
        x =x.next;
    }
}

    public static void main(String[] args) {
        Node root =new Node(3);
        root.next = new Node(4);
        root.next.next = new Node(5);
        root.next.next.next = new Node(6);
        root.next.next.next.next = new Node(7);
        root.next.next.next.next.next = root.next.next;
        //print(root);should be infinite loop
        detectLoopAndFix(root);
        
        print(root);
        
        //
        
//        root.next = new Node(4);
//        root.next.next = new Node(5);
//        root.next.next.next = new Node(6);
//        root.next.next.next.next = new Node(7);
//        root.next.next.next.next.next =  root.next.next.next.next;
//         detectLoopAndFix(root);
//        //print(root);
//         
//        root.next = new Node(4);
//        root.next.next = new Node(5);
//        root.next.next.next = new Node(6);
//        root.next.next.next.next = new Node(7);
//        root.next.next.next.next.next = new Node(8);
//        root.next.next.next.next.next.next = new Node(18);
//        root.next.next.next.next.next.next.next =  root.next.next.next.next.next;
//         detectLoopAndFix(root);
        
        
        
        
    }




}
