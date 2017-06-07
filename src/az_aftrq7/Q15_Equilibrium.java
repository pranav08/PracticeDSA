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
public class Q15_Equilibrium {
    int[] arr = {1, 3, 5, 2, 2,1,0, 13 };
    int l = 0;int r= arr.length-1;
    
    public Q15_Equilibrium() {
        System.out.println("Process");
        int lS,rS;
        lS=arr[l];
        rS=arr[r];
        while (l<r){
            if(lS==rS && r-l==2) {
                System.out.println("Index:"+(l+1)+" , Value="+arr[l+1]);//return
                return;
            }
            else if (lS<rS) {
                lS=lS+arr[++l];
            }
            else {
                rS=rS+arr[--r];
            }
        }//while
        System.out.println("-1");//return
        return;

    }
    

    
}
