package az_aftrq7;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
public class Q8_FindSumOf4_optimized {
    //since this is just 4 sums, we try to optimize this by making pais of two first.
    //And then trying to figure out the pairs among them that sums up to a desired number.
    //For solving duplicates just keep the answers in sets and compare the new answer
    static int arr[] = {10,2,3,4,5,9,7,8};
    static int sumAll = 23;
    
    class pair{
        int x;int y;
        int sum;

        public pair(int x, int y, int sum) {
            this.x = x;
            this.y = y;
            this.sum = sum;
        }
    }

    public Q8_FindSumOf4_optimized(){
        Arrays.sort(arr);
        int pairSize = ((arr.length-1)*arr.length)/2;
        pair[] pairs = new pair[pairSize];
        int x =0;
        for (int i=0;i<=arr.length-1;i++){
            for (int j=i+1;j<=arr.length-1;j++){
                //System.out.println(""+i+","+j);
                pairs[x++]=new pair(i,j,arr[i]+arr[j]);
            }
        }
        System.out.println("Pairsize"+pairSize);
        for (int i=0;i<=pairSize-1;i++){
            for (int j=i+1;j<=pairSize-1;j++){
                //System.out.println(pairs[i].x+","+pairs[i].y+","+pairs[j].x+","+pairs[j].y+",");
                haveAllUniqueWithCorrectSum(pairs[i], pairs[j]);
            }
        }
    }
    
    void haveAllUniqueWithCorrectSum(pair p1, pair p2){
        //TODO: filter out common indexes
//      s.stream().forEach(i->System.out.print(""+i+":"));
//      System.out.println("");

        //s.stream().forEach(i->System.out.print(i+"-"));
        //System.out.println("");
        
        //s.stream().mapToInt(i->i).sum()
        if (haveAllUnique(p1, p2)){
            //System.out.println("Unique Found");
            if ((p1.sum + p2.sum)==sumAll){
                //System.out.println("SUM OK");
                System.out.println(""+arr[p1.x]+","+arr[p1.y]+","+arr[p2.x]+","+arr[p2.y]+"\t\t=>"+p1.x+","+p1.y+","+p2.x+","+p2.y);
            }
        }
    }
    
        boolean haveAllUnique(pair p1, pair p2){
            HashSet<Integer> s = new HashSet<Integer>();
            s.add(p1.x);s.add(p1.y);s.add(p2.x);s.add(p2.y);
            if (s.size()==4) return true;
            else return false;
        }
    
}
