package az_aftrq7;

// package whatever; // don't place package name!

import java.io.*;

class QuickSort
{
    static int[] array = {5,1,3,9,2,4,8,6};
    public static void main (String[] args) throws java.lang.Exception
    {
        
        
        quicksort(array,0,array.length-1);
        for (int v: array) System.out.println(""+v);
        
    }//main
    
    static public void quicksort(int[] a, int i, int j){
        if (i>j) return;//done
        int x = partition(a,a[(i+j)/2],i,j );//patition array a with pivot as mid element where i and j are the boundary indexes
        quicksort(a,i,x-1);
        quicksort(a,x+1,j);
        //the idea is after partition  whatever value was in (i+j)/2 position or pivot 
        //comes to its correct position, which is nothing but the i that returns
        //then we simply parition the 2 halfs seperately.
    }
    
    static public int partition(int[] a, int pivot, int i, int j){
        //partition by x
        while (i<j){
            while (a[i]<pivot) i++;
            while (a[j]>pivot) j--;
            
            if(i<=j){
            //now swap a[i] and a[j]
            int tmp = a[j];
            a[j] = a[i];
            a[i] = tmp;
            
            i++;
            j--;
            }
            
            
        }//while
        return i;//as index i is in place
    }//parition ends
        
        
}//class