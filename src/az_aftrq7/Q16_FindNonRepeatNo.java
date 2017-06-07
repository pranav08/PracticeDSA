package az_aftrq7;

/**
 *
 * @author pranav.nandan
 * SUCH AN EFFECTIVE AN ELEGANT SOLUTION
 * TIME 2*O(N), Space O(1)
 */
public class Q16_FindNonRepeatNo {
//in an array where all no. are repeated twice, two no. are unique, find them
    int[] arr = {1, 2, 983, 2, 1, 467, 12, 12, 43, 34, 34, 43, 7, 7, 99, 99};
    
    public Q16_FindNonRepeatNo() {
        int xorAll = 0;
        for (int v:arr){
            xorAll = xorAll^v;
        }
        //xorAll will be equal to x^y, where x and y are unique no. as all other no. cancels each other out
        //all the bits set in xorAll, will point the difference between x and y
        //if we sepeate the current arr wrt some bit set(say rightmost in xorAll), x and y will be in differnt set
        //note that the duplicates no. will be in same set after division of set
        //if we do xorALL of the seperate sets, we will get x and y
        int rightMostBitSet = xorAll & ~(xorAll-1);
        int x = 0, y = 0;
        for (int v:arr){
            if ((v&rightMostBitSet)!=0){//bit is set
               x = x^v; 
            } else {//bit not set
               y = y^v;
            }
        }
        System.out.println("Unique no. are: "+x+" , "+y);
        
        
    }
    
    public static void main(String[] args) {
        Q16_FindNonRepeatNo o = new Q16_FindNonRepeatNo();
    }
    
    
    
}
