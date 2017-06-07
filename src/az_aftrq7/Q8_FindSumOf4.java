package az_aftrq7;
import java.util.Arrays;
import java.util.HashSet;
/**
 * TODO: 15 minutes
 * @author Pranav.Nandan
 */
public class Q8_FindSumOf4 {
    int arr[] = {10,2,3,4,5,9,7,8};
    int sumall = 23;
    
    //combinations are 8*7*6*5
   Q8_FindSumOf4(){
        Arrays.sort(arr);//implement a quick sort
        for (int b : arr) {
            System.out.println(""+b);
        }
        System.out.println("");
        //reverse(arr, 0, arr.length-1);
        rec(new HashSet<Integer>(),arr,0);
    }
    
    int[] reverse(int[] arr, int l, int r){//returns the reverse of the array
        if (l>=r) return arr;
        else {
            arr[l] = arr[l]^arr[r];
            arr[r] = arr[l]^arr[r];
            arr[l] = arr[l]^arr[r];
        }
        return reverse(arr, l+1,r-1);
    }
    
    void rec(HashSet<Integer> chosen,int[] remaininingInput,int curRemainIndex){
      chosen.stream().forEach(val->System.out.print(val+", "));
      System.out.println("");
      if(chosen.stream().mapToInt(val->(val)).sum()==sumall) {
            chosen.stream().forEach(val->System.out.println("Ans: "+val+", "));
      }
      else{      
      for(int i=curRemainIndex;i<=remaininingInput.length-1;i++){
          //we select next possibles in line and assume that things go positively
          if (chosen.stream().mapToInt(val->(val)).sum()<sumall){
                chosen.add(remaininingInput[i]);
                rec(chosen,remaininingInput,++i);
          }
          else {//current chosen sum is greater than expected
              break;
          }
      }
      }
        
        
    }
    
}
