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
//The time complexity is O(n), but space is O(n*n (for recursion stack) + n (for so far)) or O(n^2)
//to be precise it is (n+1)n/2 remainints[]
public class MinimumUsingRecursion {
    static int a[] = {4,5,2,3,1,89};
    
    public static void main(String[] args) {
        int min = process(Integer.MAX_VALUE,a);
        System.out.println(min);
}

    static public int process(int soFar, int[] remaining){
	if (remaining.length==0) return soFar;
	else {
		return process(soFar>remaining[remaining.length-1]?remaining[remaining.length-1]:soFar, Arrays.copyOf(remaining, remaining.length-1));
	}

}



    
}
