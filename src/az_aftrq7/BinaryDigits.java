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
public class BinaryDigits {

    public BinaryDigits() {
        int[] a = {1, 2, 3, 4};
        //no. of subsets is 2^4 = 16 (including null set)
        int no = (int) Math.pow(2, a.length);
        for (int i = 0; i <= no - 1; i++) {
            for (int c = 3; c >= 0; c--){
                if ((1<<c & i) != 0) {//bit is set
                    System.out.print("1");
                } else {
                    System.out.print("0");
                }
                if (c==0) System.out.print(" = "+i);
            }
            System.out.println();
        }
    }
    
    void test(){
        for (int i=0;i<4;i++){
            System.out.println(""+(1<<i));
        }
    }

}
