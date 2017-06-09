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
public class Q122_RotateArray {
    
    public static void main(String[] args) {
        rotateAntiClock(a,a.length,3);
        //rotateClock(a,a.length,3);
    }
    
    static int a[] = {1,2,3,4,5,6,7,8,9,10};
    
    static void rotateAntiClock(int[] a, int size, int d){//rotate array of size n by d elements
       reverse(a,0,d-1);
       reverse(a,d,a.length-1);
       reverse(a,0,a.length-1);
       for (int val: a){
           System.out.print(""+val+", ");
       }
    }
    
    static void rotateClock(int[] a, int size, int d){//rotate array of size n by d elements
       reverse(a,0,a.length - 1 - d - 1);
       reverse(a,a.length - 1 -d,a.length -1);
       reverse(a,0,a.length-1);
       for (int val: a){
           System.out.print(""+val+", ");
       }
    }
    
    static void reverse(int[] a, int i, int j){
        int tmp;
        while (i<j){
            tmp = a[i];
            a[i] = a[j];
            a[j] = tmp;
            i++; j--;
        }
        
    }
    
    
}
