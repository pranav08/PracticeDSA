package az_aftrq7;

public class Permutations {
     static int c=1;
    
    public static void main(String[] args) {
        permute("","abcxyz");
    }
    
    public static void permute(String resultSoFar, String inputRemaining){
       
        if (inputRemaining.length()==0) {
            System.out.println((c++)+" : "+resultSoFar);
        }//this is the final condition that is required, i.e. we have no inputRemaininhg. 
        else {//chose a good step from input remaining
            for (int i=0;i<=inputRemaining.length()-1;i++){
                permute(resultSoFar+Character.toString(inputRemaining.charAt(i)), inputRemaining.substring(0, i)+inputRemaining.substring(i+1));
            }
        }
    }
}
