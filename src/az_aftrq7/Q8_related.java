/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package az_aftrq7;

import java.util.Arrays;

/**
 *
 * @author Pranav.Nandan
 */
public class Q8_related {
    int arr[] = {1, 4, 7, 45, 6,9, 10, -8};

    public Q8_related() {
        Arrays.sort(arr);
        int l =0;int r=arr.length-1;
        while (l<r){
            if (arr[l]+arr[r]==16) {
                System.out.println(arr[l]+","+arr[r]);
                l++;
                r--;
            }
            else if (arr[l]+arr[r]<16) l++;
            else r--;
        }
    }
    
    
    
    
}
