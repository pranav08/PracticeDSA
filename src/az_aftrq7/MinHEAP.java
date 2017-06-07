package az_aftrq7;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

public class MinHEAP {
ArrayList<Integer> arr = new ArrayList<Integer>();
    public MinHEAP() {
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
        insert(1);
        
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
        System.out.println(remove());
        System.out.println(remove());
        System.out.println(remove());
        System.out.println(remove());

        
//               1
//         3            2    
//       6   8     9(5)  5(6)
//   23   11 10 55 32  23  7 
//      
        
    }

    void insert(int n){
        arr.add(n);
        heapifyUp(arr.size()-1);
    }

    private void heapifyUp(int index) {
        while(index>0){//only heapifyUp if not a root child
            int min;
            //find the smaller sibling
            if ((index%2==0) && (Integer)arr.get(index)>(Integer)arr.get(index-1))//if has sibling and smaller
                min = index-1;
            else 
                min = index;

            if (arr.get((min-1)/2)>arr.get(min)){//if parent is larger than min index sibling
                int tmp = arr.get(min);
                arr.set(min, arr.get((min-1)/2));
                arr.set((min-1)/2, tmp);
                index = (min-1)/2;
            }
            else {//if parent is smaller than the smaller child
                break;
            }
        }
    }

    private int remove() {
        int toRet = arr.get(0);
        arr.set(0,arr.get(arr.size()-1));
        arr.remove(arr.size()-1);//remove the last element
        heapifyDown(0);
        return toRet;
    }

    private void heapifyDown(int i) {
        //logic can be to find the smaller child among both
        //if parent is smaller than smaller child. fine
        //if parent is greater than smaller child. swap
        
        while((i*2+1)<=arr.size()-1){//heapify down till atleast one chid exist
            int min;
            if(arr.size()-1>=i*2+2){//we have right child too
                if (arr.get(i*2+1)<arr.get(i*2+2)){
                    min = i*2+1;
                }
                else {
                    min = i*2+2;
                 }
            }
            else {//only left child
                min = i*2+1;
            }
            if (arr.get(i)>arr.get(min)){//if parent is greater than smaller
                int tmp = arr.get(min);
                arr.set(min, arr.get(i));
                arr.set(i, tmp);
                i = min;
            }
            else {//if parent is smaller than the smaller child
                break;
            }
        }//while
    }
    
    
    
    
}
