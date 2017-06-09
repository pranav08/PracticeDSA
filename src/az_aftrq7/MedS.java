/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package az_aftrq7;

import java.util.ArrayList;

/**
 *
 * @author pranav.nandan
 */
public class MedS {
    
    static class MinH{
        ArrayList<Integer> arr;
        //parent is always (n-1)/2, 
        //if left child n%2==1, for right==0
        MinH(int size){
            arr = new ArrayList<Integer>(size);
        }
        
        void printAll(){
            int c = arr.size();
            while(--c>=0){
                System.out.println(""+arr.get(c));
            }
                
        }
                
        void ins(int val){
            if (arr.size()>0){
                arr.add(val);
                heapifyUp(arr.size()-1);//its index is -1
            }
            else {
                arr.add(0, val);
            }
        }
        
        int del(){
            if(arr.size()>0){
                //swap the min(first index) with the max i.e. the last no. in the heap. delete the heap and heapifyDown the first no.
                    int tmp = arr.get(0);
                    arr.set(0,arr.get(arr.size()-1));
                    arr.remove(arr.size()-1);
                    heapifyDown(0);
                    return tmp;
            }
            else if (arr.size()==1){
                return arr.remove(0);
            }
            else {
                return -999;
            }
        }
        
        
        void heapifyUp(int index){
            if (index<=0) return;
            int sc;
            int lc = index%2==0?index-1:index;
            if (lc+1<=arr.size()-1 && arr.get(lc+1)<arr.get(lc)) sc = lc +1;
            else sc = lc;
            
            int p = (sc-1)/2;
            //Now swap if parent(i.e. index) is greater smaller child, and heaifyUp sc
            if(arr.get(sc)<arr.get(p)){//shift up and swap
                    int tmp = arr.get(p);
                    arr.set(p,arr.get(sc));
                    arr.set(sc, tmp);
                    heapifyUp(p);
            }
            
        }

         void heapifyDown(int index) {
           if (index*2+1>arr.size()-1) return;//if does not have child, it cannot be pulled down
           int lc = index*2+1;
           int rc = index*2+2;
           int sc;
           if (rc<=arr.size()-1){//right child exists too
               sc = arr.get(lc)<arr.get(rc)?lc:rc;
           }
           else {//we only have left child
               sc = lc;
           }
           if (arr.get(sc)<arr.get(index)){
           //swap parent i.e. i with sc and heapifydown
                    int tmp = arr.get(index);
                    arr.set(index,arr.get(sc));
                    arr.set(sc, tmp);
                    heapifyDown(sc);
        }
         }
      
    }//class
    

             
    public static void main(String[] args) {
        MinH mh = new MinH(20);
        mh.ins(17);
        mh.ins(11);
        mh.ins(15);
        mh.ins(4);
        mh.ins(9);
        mh.ins(2);
        mh.ins(10);
        
        
        mh.printAll();
        System.out.println("Now");
                
        System.out.println(""+mh.del());
        System.out.println(""+mh.del());
        System.out.println(""+mh.del());
        System.out.println(""+mh.del());
        System.out.println(""+mh.del());
        System.out.println(""+mh.del());
        System.out.println(""+mh.del());
        System.out.println(""+mh.del());
   }//main
            
            
}//MedS
