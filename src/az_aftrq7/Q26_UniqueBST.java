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
public class Q26_UniqueBST {
        
    public static void main(String[] args) {
    int[] T = {1,1,0,0,0};//Array for DP
    int n = 4;//Find for n=4, i.e. how many unique paths can exist in BST for 4 ndoes    
        for (int i=2;i<=n;i++){//no. of nodes
            for (int j=i;j>=1;j--){//root node
                T[i] += T[j-1] * T[i-(j-1)-1];// i.e. onRight = total - onLeft - root
            }
        }
        System.out.println(""+T[n]);
    }
}
