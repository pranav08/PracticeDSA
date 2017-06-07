/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package az_aftrq7;

/**
 *
 * @author pranav.nandan
 * Here we remove every 3rd element.
 * Hints always use parent pointer, otherwise you will complicate things more.
 * 
 * 
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
            ll p=r;
            for(int i = 2;i<=20;i++){
                ll tmp = new ll(i);
                p.nx = tmp;
                p=p.nx;
            }
            
            //print the elements
            p = r;
            while (p!=null){
                System.out.println(""+p.d);
                p = p.nx;
            }
            
            p = r;int c=0;int n = 3;
            
            //remove all nth element
            ll pr = p;//first node is a parent of itself and second 
            while (p!=null){
                c++;
               
                if (c%3==0) {//3rd element
                    pr.nx = p.nx;
                }
                pr = p;
                p = p.nx;
            }
            
            
            
            
          
            //print the elements
            System.out.println("prnt");
            p = r;
            while (p!=null){
                System.out.println(""+p.d);
                p = p.nx;
            }
            
            
            
        }
    
}
