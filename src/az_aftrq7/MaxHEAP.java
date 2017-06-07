/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package az_aftrq7;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

/**
 *
 * @author pranav.nandan
 */


public class MaxHEAP {
ArrayList<Integer> arr = new ArrayList<Integer>();

    public MaxHEAP() {
        insert(11);
        insert(9);
        insert(6);
        insert(2);
        insert(10);
        insert(5);
        insert(7);
        insert(23);
        insert(3);
        insert(8);
        insert(55);
        insert(32);
        insert(23);
        insert(122);
        
        for (Iterator<Integer> iterator = arr.iterator(); iterator.hasNext();) {
            Integer next = iterator.next();
            System.out.println(","+next);
        }
        
        System.out.println(remove());
        System.out.println(remove());
        System.out.println(remove());
        System.out.println(remove());
        System.out.println(remove());
        System.out.println(remove());
        System.out.println(remove());
        System.out.println(remove());
        
//            122
//        23       55(2)    
//      10   11  23(5)  32(6)
//    2  3 8  9 5  7 6
        
    }

    void insert(int n){
        arr.add(n);
        heapifyUp(arr.size()-1);
    }

    private void heapifyUp(int index) {
        
        while (index>0){//only heapifyUp if not a root child
            int max;
            //find the greater sibling
            if ((Integer)arr.get(index)>(Integer)arr.get(index-1))
                max = index;
            else 
                max = index-1;

            if (arr.get((max-1)/2)<arr.get(max)){//if parent is smaller than greater
                int tmp = arr.get(max);
                arr.set(max, arr.get((max-1)/2));
                arr.set((max-1)/2, tmp);
                index = (max-1)/2;
            }
            else {//if parent is greater than the larger child
                break;
            }
        }
    }

    private int remove() {
        int toRet = arr.get(0);
        arr.set(0,arr.size()-1);
        arr.remove(arr.size()-1);//remove the last element
        heapifyDown(0);
        return toRet;
    }

    private void heapifyDown(int i) {
        //see if the parent is smaller than any of the child
        //smaller than 1 child => put the other child at top
        //smaller than both child => put the bigger child at top
        
        //logic can be to find the greater child among both
        //if parent is greater than greater child. fine
        //if parent is smaller than greater child. swap
        
        while((i*2+1)<=arr.size()-1){//heapify down till atleast one chid exist
            int max;
            if (arr.size()-1>=i*2+2){//we have right child too
                if (arr.get(i*2+1)>arr.get(i*2+2)){
                    max = i*2+1;
                }
                else {
                    max = i*2+2;
                 }
            }
            else {//only left child
                max = i*2+1;
            }
            if (arr.get(i)<arr.get(max)){//if parent is smaller than greater
                int tmp = arr.get(max);
                arr.set(max, arr.get(i));
                arr.set(i, tmp);
                i = max;
            }
            else {//if parent is greater than the larger child
                break;
            }
        }//while
    }
    
    
    
    
}
