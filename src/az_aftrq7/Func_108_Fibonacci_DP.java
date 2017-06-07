package az_aftrq7;

/**
 *
 * @author pranav.nandan
 */

//DP is nothing but recursion with intelligent storage. Draw the tree for fiboDP and you will understand
public class Func_108_Fibonacci_DP {
    static int[] f;
    static int count;
    
    public static void main(String[] args) {
        int n = 10;
        f = new int[n+1];
        System.out.println("Fibo    "+fibo(n)+","+count);//this is O(177) actually 2^n
        clear();
        System.out.println("Fibo (DP)"+fiboDP(n)+","+count);// this is O(25)
        clear();
        System.out.println("Fibo (DP)"+fiboDP2(n)+","+count);//it is surprising how it decreased the complexity to O(12)
        
    }
    
    public static void clear(){//just to clear count of calls n array
        f = new int[f.length];
        count=0;
    }
    
    static int fibo(int n){//this is a 2^n solution, as it have all the combination, and a perfect binary tree
        ++count;
        if (n==0) return 0;
        if (n==1) return 1;
        return fibo(n-1)+fibo(n-2);
    }
    
    
    static int fiboDP(int n){//note the runtime calls got reduced to 25 from 177 due to caching. 
         ++count;
        if (n==0) return 0;
        if (n==1) return 1;
        if (f[n-1]!=0 && f[n-2]!=0) 
            return (f[n-1] + f[n-2]);
        else {
            f[n] = fiboDP(n-1)+fiboDP(n-2);
            return f[n];
        }
       
    }
    
        static int fiboDP2(int n){//this was just an experiment
         ++count;
        if (n==0) return 0;
        if (n==1) return 1;
        int f1, f2;
        
        if (f[n-1]!=0)
            f1 = f[n-1]; 
        else 
            f1 = fiboDP2(n-1);
       
        if (f[n-2]!=0)
            f2 = f[n-2];
        else 
            f2 = fiboDP2(n-2);
            
            
        f[n] = f1 + f2;
        return f[n];
        
        
       
    }
            
    
}
