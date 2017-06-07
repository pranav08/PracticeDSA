package az_aftrq7;

import java.util.Arrays;

public class Q21_LongestSuffixPrefix {
    String input = "babababa";
    
    public void Q21_LongestSuffixPrefix_test() {
        char[] a = input.toCharArray();
        int i = a.length-1;
        int j = i -1;
        //we are actually imagining we already have found the longest possible suffix and prefix
        //by that logic the last index (i) should match the 2nd to last index (j) already. THink
        //This is O(n) time algorithm, and takes O(1) space. 
        while(j>0){
            if (a[i]!=a[j]) {//if chars are not same
                j--;
                if (i!=a.length-1) i = a.length-1;//if prev was same, then reset
            }
            else {i--;j--;}//if chars are same move both together
        }
        System.out.println("Answer is: "+ input.substring(i, input.length()) );
    }
    
    public static void main(String[] args) {
         Q21_LongestSuffixPrefix lsp = new Q21_LongestSuffixPrefix();
         lsp.Q21_LongestSuffixPrefix_test();
    }
    
    
    
}
