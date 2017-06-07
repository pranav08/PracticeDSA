/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package az_aftrq7;

/**
 *
 * 1 3 4 2 6
//first pass put all in hashset, and find min
//second pass, check if we can retrive value, the //first fail is misisng no.

time O(2n) space O(n + 1)

Alternate way
//first pass, find min and max, also get the xor value of all, say x
//iterate from min to max, and xor it to x
//the value in x now is our missing value as every double elements have cancel them
//thus XOR it once to find the value
 *
 */


public class Q102_MissingNumber {
    static int[] a =  {1, 3, 4, 2, 6};
    
    public static void main(String[] args) {
        System.out.println("Missing no.");
        int xorValue = 0, min = Integer.MAX_VALUE, max= Integer.MIN_VALUE;
        for(int v: a){
            xorValue ^= v;
            if (v>max) max = v;
            if (v<min) min = v;
        }
        for (int i = min;i<=max;i++){
            xorValue ^= i;
        }
        //at this point xorValue has inverse of misisng value
        System.out.println("missing value is "+ xorValue);
    }
    
    
}
