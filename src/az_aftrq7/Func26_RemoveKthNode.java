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
public class Func26_RemoveKthNode {
    static class ll {
        ll nx;
        int d;

        public ll(int d) {
            this.d=d;
        }
        
        
    }
    
    public static void main(String[] args) {
            ll r = new ll(1);
            for(int i = 2;i<=20;i++)
                r.nx = new ll(i);
            ll p = r;int c=1;int n = 3;
            //remove all nth element
            while(p!=null){
                p=p.nx;
                c++;
                if((c+1)%n==0 && p.nx!=null) p.nx = p.nx.nx;
            }
            //
            
            
        }
    
}
