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
public class SubArray_SubString {
    //Lists all the possible subarrays. Subarrays or substrings are part of arrays. Or an 
    //Array that are inside another string
    //Here we list the possible subarrays of set A = {A,B,C,D}
    
    char[] a = {'a','b','c','d'};

    public SubArray_SubString(){
        for (int l=1;l<=a.length;l++){//length of the subarray
            for (int i=0;i<=a.length-1;i++){//starting index of subarray
                if (i+l+1<=a.length){//if below subarray is really posible. //look below to decide 
                    //above condition, from i to i+l is actually i+l+1 lenth, hence the same
                    for (int j=i;j<=i+l ;j++){//print subarray from starting index i of length l 
                        System.out.print(","+a[j]);
                    }
                System.out.println("");
                }
            }
        }
   }
    /**
     * 
     * 
     * 
     * /**
     */
    
}
