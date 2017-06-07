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
public class Q11_CheckNumIfTruePower {

    public Q11_CheckNumIfTruePower(int num) {
        int sqrt = (int) Math.sqrt(num);
        int val;int y;
        for (int x=2;x<=sqrt;x++){
            val=x;
            y=1;
            while(val<=num){
                if(val==num){
                    System.out.println("x"+x+",y"+y);
                    break;
                }
                else {
                    val=val*x;
                    y++;
                }
            }
        }
    }
    
    
    
    
}
