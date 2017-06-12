/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package az_aftrq7;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import sun.awt.SunGraphicsCallback;

/**
 *
 * @author Pranav Nandan
 */
//Implement an LRU cache, Least recently used
// 3 4 2 7 8 3 1 2 3 2 4 5 1 3 2
//LRU cache of size 3
// 342 427 278 783 831 312 123 + 2 => 132
//Hash will have page no. ie. adress of the frame(page) which contains the object to be retrieved
//If hit occurs, then we return the page, and bring the page to the front of the list
//otherwise we insert into list as normal, and del the oldest if needed
class LRUCache{
int size = 3;//default size
HashMap<Integer, Node> pager;
DLL dll;

LRUCache(int size){
    this.size = size;
    pager = new HashMap<Integer, Node>();    //init hashmap
    dll = new DLL();//init list
}

    private class Node{
        Node next;
        Node prev;
        int data;
        
        Node(int a){
            this.data = a ;
        }
        
    }

private class DLL{
    Node head;
    Node tail;

    int curSize=0;
    
    DLL(){
       
    }
    
   
    void addData(int a){
    //Var a = (Image) getImageFromPath(a); //and inserts A
    //in case of miss    
    if (curSize==size-1){//store is full
        //del oldest, and put new to head
       
        tail = tail.prev;
        tail.next = null;
         pager.remove(tail.data);
        
        head.prev = new Node(a);
        head.prev.next = head;
        head = head.prev; 
        
        pager.put(a, head);
        
    }
    else if (curSize==0){//for 0 nodes yet
        head = new Node(a);
        pager.put(a, head);
        head.next = null;
        tail = head;// reqired?
        curSize++;
        
    }
    else if (curSize==1){//for 1 node yet, some fixing with tail
        Node tmp = new Node(a);
        tmp.next = head;
        head.prev = tmp;
        head = tmp;
        
        pager.put(a,head);
        
        tail = head.next;
        tail.prev = head;
        curSize++;
    }
    else{//we have space
        //add to head
        curSize++;
        head.prev = new Node(a);
        head.prev.next = head;
        head = head.prev;
        pager.put(a, head);
    }
    //update map
    
    }//end of addData
    
    void printCache(){
        System.out.print("=>");
        Node p = head;
       while(p!=null) {System.out.print(p.data+",");p=p.next;}
//        System.out.print("From tail =>");
        System.out.println("");
//        p = tail;
//       while(p!=null) {System.out.print(p.data+",");p=p.prev;}
//        System.out.println("");
//        
        
        
    }
    

}//DLL

    public int retrieve(int imgPath){
        if (pager.get(imgPath)!=null){//is available in cache
            
                //check if already, then just bring front, return
                //this part should ideally be inside DLL class
            if (dll.curSize>0){//dont try to bring to front if we have nly 1 element
            Node x = pager.get(imgPath);
                //remove from its posn
                Node a = x.prev;//when in doubt ALWAYS USE TEMPORARY VAR POINTER
                Node b = x.next!=null?x.next:null;
                a.next = b;
                if (b!=null) b.prev=a;
                
                //bring to front
                dll.head.prev = new Node(x.data);//we do not copy directly as references like prev and next will get copied too.
                dll.head.prev.next = dll.head;
                dll.head = dll.head.prev;
                                
                dll.head.prev=null;
                x=null;//kill or garbage collect reference, anyway it will happen once outside the scope
            }

            System.out.print("Hit "+pager.get(imgPath).data);
            dll.printCache();
            return pager.get(imgPath).data;//Here the hash itself converts the data into appropriate key and stores internally
        }
        else {
            
            dll.addData(imgPath);
            System.out.print("Miss "+pager.get(imgPath).data);
            dll.printCache();
            return pager.get(imgPath).data;
        }
        
    }
    
    


public static void main(String[] args){
    LRUCache c1 = new LRUCache(3);
    c1.retrieve(1);
    c1.retrieve(2);
    c1.retrieve(3);//321
    c1.retrieve(1);//132
    c1.retrieve(4);//413
    c1.retrieve(2);
    c1.retrieve(12);
    c1.retrieve(20);
    c1.retrieve(2);
    
    
}

}
