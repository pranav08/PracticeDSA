package az_aftrq7;

public class SubSets {

    char[] a = {'a','b','c','d'};
    public SubSets() {
        //no. of subsets is 2^4 = 16 (including null set)
        int no = (int) Math.pow(2,a.length);
        for(int i=0;i<=no - 1;i++){
            for(int c=0;c<4;c++){
                if (((1<<c)&i)!=0){//bit is set
                    System.out.print(a[c]+",");
                }
            }
            System.out.println("");
        }
    }
    
    public static void main(String[] args) {
        
    }
    
    
    
    
}
