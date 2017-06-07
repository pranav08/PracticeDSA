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
public class GCD {
    //Best case O(n)
    //Worst case is two fibonacci number i.e. O(logn)
    static int count;
    public static void main(String[] args) {
        System.out.println(""+gcd(1313137, 131)+""+" count"+count);
    }
    
    static int gcd(int m,int n){
        count++;
        if (m%n==0) return n;
        else {
            return gcd(n,m%n);
        }
    }
    
}
