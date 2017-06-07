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
public class TrashRecursionSketchTest {
    static int[] a= {0,1,2,3,4,5,6,7,8}; 
    
    public static void main(String[] args) {
        displayFashion(a, 0, a.length-1);
    }
    
    static void displayFashion(int[] r, int i, int j){
        if (i<j) displayFashion(r, i, j/2);
        
        System.out.println("i="+i+" j="+j);
    }
    //displayFashion
}
