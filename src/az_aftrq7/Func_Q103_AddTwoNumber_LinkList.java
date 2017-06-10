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
public class Func_Q103_AddTwoNumber_LinkList {
//Add two numbers represented by link list
// h1->9->3->1
// h2->7->3->9
// 1->6->7->0
//TODO: Optimize the reverse function, don't use aux link list
    class Node {

        int data;
        Node next;

        Node(int d) {
            this.data = d;
        }

        Node addNode(int d) {
            this.next = new Node(d);
            return this.next;
        }
    }
    
       Node h1 = new Node(9);
       Node h2 = new Node(7);
       Node h3 = new Node(0);

    void testSum() {
     
        h1.addNode(3).addNode(1);//thus we have 931
        h2.addNode(3).addNode(9);//thus we have 931

        h1 = reverseLL(h1);
        h2 = reverseLL(h2);
//     6321
//     32654 
        Node p1, p2, p3;
        p1 = h1;
        p2 = h2;
        
        p3 = h3;

        while (p1 != null && p2 != null){//while both digits exists
    int sum = p1.data + p2.data;
            if (sum > 9) {
                p3.data += 10 - sum;
                p3.next = new Node(1);//carry forward
            } else {
                p3.data += sum;
                p3.next = new Node(0);
            }
            p3 = p3.next;
            p2 = p2.next;
            p1 = p1.next;
        }

        while (p1 != null) {
            p3.data += p1.data;
            p1 = p1.next;
            p3.next = new Node(0);
        }
        while (p2 != null) {
            p3.data += p2.data;
            p2 = p2.next;
            p3.next = new Node(0);
        }
        
        //restore original lists
            h1 = reverseLL(h1);
            h2 = reverseLL(h2);
            
            h3 = reverseLL(h3);
       
    }
    
    void printList(Node x){
        Node p = x;
        while(p != null){
        System.out.print(p.data+"->");
        p = p.next;
        }
        System.out.println("");
    }

    Node reverseLL(Node head) {
        Node rh = new Node(head.data);
        head = head.next;
        while (head != null) {
            Node tmp = new Node(head.data);
            tmp.next = rh;
            rh = tmp;

            head = head.next;
        }
        return rh;
    }//end of method
    
    public static void main(String[] args) {
      Func_Q103_AddTwoNumber_LinkList t = new Func_Q103_AddTwoNumber_LinkList();
      t.testSum();
      t.printList(t.h1);
      t.printList(t.h2);
      t.printList(t.h3);
      
    }

}//end of class
