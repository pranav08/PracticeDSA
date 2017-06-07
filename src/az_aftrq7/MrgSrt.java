package az_aftrq7;
import java.util.Arrays;
public class MrgSrt {
    //how beautifully i wrote this from scratch, without referring anywhere since last year
    //all i remember was the tree diagram that i did in b.tech, and permutation recursion
    //i feel happy
    //first use divide n conquer using recursion and then will convert to loop
    
    //my thoughts are evolving, i don't see this solution beautiful anymore. there is lots of copy
    //lots of space requirement, see the MrgSrt.java to see a better solution, I did after a lot of pain without seeing anytihng at all.
    //merge sort is O(n) space as it requires an auxillary array to copy back.

    public MrgSrt() {
        int[] input = {1,3,2,5,4,3,9,6};
        int mid = (input.length - 1 )/2 ;
        System.out.println("Mid is at index: "+ mid);
//        int[] out = srt(Arrays.copyOfRange(input, 0,mid + 1),Arrays.copyOfRange(input, mid + 1, input.length));
        int[] out = srt(input);
        prnt("out",out);
    }
    
//sort(a)
//if a has 1 element return a
//divide a into 2 halves
//b = sort(1st half)
//c = sort(2nd half)
//combine b+c properly
//return combined
    
    private int[] srt(int[] input){
        int[] b; 
        int[] c;
        if (input.length<=1) 
            return input;
        else {
            int mid = (input.length - 1 )/2 ;
            b = srt(Arrays.copyOfRange(input, 0,mid + 1));
            c = srt(Arrays.copyOfRange(input, mid + 1, input.length));
        }
            //it comes here when we have 2 arrays both of size greater than 1 and sorted
            int[] d = new int[b.length + c.length];
            int y=0,z=0;int x=0;
            
            for (x=0;x<d.length && y<b.length && z<c.length;){
                if(b[y]<=c[z]) d[x++]=b[y++];
                else d[x++]=c[z++];
            }
            if (x==d.length) return d;
            if (y==b.length) while(z!=c.length) d[x++]=c[z++];
            if (z==c.length) while(y!=b.length) d[x++]=b[y++];
            return d;
    }
    
    void prnt (String n,int[] out){
        System.out.print(""+n+"=");
        for (int p : out){
            System.out.print(p+",");
        }
            System.out.println("");
    }
    
    public static void main(String[] args) {
        MrgSrt ms = new MrgSrt();
    }
    
    
    
    
}
