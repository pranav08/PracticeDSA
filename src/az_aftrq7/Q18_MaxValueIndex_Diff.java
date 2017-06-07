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
public class Q18_MaxValueIndex_Diff {
    int[] arr = {9, 15, 4, 12, 13};

    public Q18_MaxValueIndex_Diff() {
    int[] a = new int[arr.length];
    for (int i=0;i<arr.length;i++){
        a[i]=arr[i]-i;
    }
    //Now problem reduces to find two element with maximum difference in arryFixed
    //Max diff will obviously be Max Value - Min value
    int maxIndex =0, minIndex =0;//we suppose both index are 0
    for (int i=0;i<arr.length;i++){
        if (a[maxIndex]<a[i]) maxIndex = i;
        if (a[minIndex]>a[i]) minIndex = i;
        
    }
        System.out.println("Numbers are "+arr[maxIndex]+","+arr[minIndex]);
System.out.println("Difference is "+((arr[maxIndex]-maxIndex)-(arr[minIndex]-minIndex)));
    
    
    }
    
    
    
    
}
