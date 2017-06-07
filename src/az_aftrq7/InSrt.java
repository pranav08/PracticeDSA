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
public class InSrt{
    //The actual way is too decent
    int a[] = {-1,324,3,54,2,4,3,3,2,1,23,43,1,32,43,23,4,1,1,432,1};
    //So basically, in every iteration i we have i smallest no.
    public InSrt(){//THIS IS CORRECT BUT COMMENTED PRINTLN
        //TODO: Optimize
        for(int i=1;i<a.length;i++){
        
           //insert a[i] into a[0].. to a[i-1] array
           //Iterate till a[i] is greater than elements behind it
           //if a greater element is found, we will shift it and all the values behind it
           //in the new gap we, will fill our number// as simple as that 
           int tmp = a[i], j,k;
           for(j=0;j<i;j++){//compare till i-1 th index
               if (a[i]<a[j]) break;
           }
           //at this point i is index of element which is greater than a[j]
           k = j;
           for (j=i;j>k;j--){
               a[j] = a[j-1];
           }
           a[k]=tmp;
           
//            for (int b : a) {
//                   System.out.print(","+b);
//               }
//            System.out.println("");
        }
          for (int b : a) {
                   System.out.print(","+b);
               }
            System.out.println("");
        
    }
    
    public void InSrt_optimize(){
         for(int i=1;i<a.length;i++){
        
           int tmp = a[i], j,k;
           int tmp2;
           for(j=0;j<i;j++){//compare till i-1 th index
               if (a[i]>=a[j]) continue;
               else {//means a[j] is greater than a[i]
                   tmp2 = a[j];
                   a[j] = tmp;
                   tmp = a[j+1];
               }
           }
          
        }
         
            for (int b : a) {
                   System.out.print(","+b);
               }
            System.out.println("");
            
        }
    
    
        public void InSrt_3(){//I HAVE NO IDEA HOW THIS WORKS, I JUST WAS TRYING RANDOM SHIT
         for(int i=1;i<a.length;i++){
        
           int valueToPlace = a[i], j,k;
           for(j=0;j<i;j++){//compare till i-1 th index
               if (valueToPlace>=a[j]) continue;
               else {//means valueToPlace is smaller than a[j]
               //we keep the current number at a[i] as it is not being used, i mean we have it in valueToPlace
                a[i]=a[j];
                a[j]=valueToPlace;
                valueToPlace = a[j+1];
               }
           }
          
        }
         
            for (int b : a) {
                   System.out.print(","+b);
               }
            System.out.println("");
            
        }
    
    public static void main(String[] args) {
        InSrt ins = new InSrt();
        ins.InSrt_optimize();
        ins.InSrt_3();
        
    }
    
    
}
