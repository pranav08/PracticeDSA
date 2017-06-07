/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package az_aftrq7;

import java.util.Arrays;

/**
 *
 * @author pranav.nandan
 */
public class MergeSort {
    static int[] a= {3,2,4,5,3,3,3,4,45,6,6,4,34,3,4}; 
    
    public static void main(String[] args) {
        MergeSort(a,0,a.length-1);
        for (int v: a){
            System.out.println(""+v);
        }
    }
    
    static void MergeSort(int[] r,int i, int j){
        if (i>=j) return ;//only 1 element is always sorted
        int mid = (i+j)/2;
        MergeSort(r, i, mid);
        MergeSort(r, mid+1, j);
        Merge(r,i,j);
    }//displayFashion

    private static void Merge(int[] r, int start, int end) {
        //we already have 2 partitions inside i to j. Those are merge. Just combine them properly
        int[] ha = Arrays.copyOfRange(r,0,r.length);//helper array
        int orig_i = start;//index to modify original array
        
        int i = start;
        int mid = (start+end)/2;
        int j = mid + 1; 
        
        while (i<=mid && j<=end){
        //find lower of ha[i] and ha[j], copy it into original array, and increment i or j accordingly
            if (ha[i]<ha[j]){
                r[orig_i++] = ha[i];
                i++;//for the copy array
            }
            else if (ha[i]>=ha[j]) {//for clarity we keep condn, if j index is smaller or equal
                //copy j
                r[orig_i++] = ha[j];
                j++;
            }
        }
        while (i<=mid) r[orig_i++] = ha[i++];
        while (j<=end) r[orig_i++] = ha[j++];
        
    }
}
