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
public class Q102_MissingNRepeatedNo_Second_Part {
    static int a[] = {2, 3, 2, 4, 6};
    
    public static void main(String[] args){
        int xorAll = 0;
        int min=Integer.MAX_VALUE;
        int max=Integer.MIN_VALUE;
        for (int v: a){
            xorAll ^= v;
            if (v>max) max = v;
            if (v<min) min = v;
        }
        //now it contains the xor of non repeated no. i.e. 3^4^6. our no. set is 2,3,4,5,6
        for (int i=min;i<=max;i++){
            xorAll^=i;
        }
        //it contains xor of 2^5
        int x =0,y=0;
        int bitpos = xorAll & (-xorAll);//first right set bit
        for (int v: a){
            if ((v & bitpos)==0){
                x ^= v;
            }
            else {
                y ^= v;
            }
        }
        
         for (int i=min;i<=max;i++){
             if ((i & bitpos)==0){
                x ^= i;
            }
            else {
                y ^= i;
            }
         }
         //if you have run something through a series of no. to obtain x^y.
         //then you have to partition the set with respect to the same series of no., to get actual x, y.
         System.out.println(""+x+","+y);
        
        
        
        
        
    }
    
}
