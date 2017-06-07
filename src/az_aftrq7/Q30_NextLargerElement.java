/*
put arr[0] into s

for i-> 1 to arr.lent - 1
while(!s.empty){
	x = pop from S 
	if arr[i]>x then print x "-> arr[i]
	else {
		push(x) push (arr[i])
		break
	}
}
if (s.empty==true) push arr[i]
next1
}
 */
package az_aftrq7;
import java.util.Stack;
public class Q30_NextLargerElement {
    static int[] arr = {6,1,8,2,7,3 };
    static Stack<Integer> stk = new Stack<Integer>();

    public static void main(String[] args) {
        stk.push(arr[0]);
        int x;int next;
        for (int i = 1;i<=arr.length-1;i++){
            while(!stk.isEmpty()){
                x = stk.pop();
                if(arr[i]>x)  System.out.println(x+"->"+arr[i]);
                else {
                    stk.push(x);
                    stk.push(arr[i]);
                    break;
                }
            }
            if (stk.isEmpty()){
                stk.push(arr[i]);//the stack got exhausted due to last arr[i], which was the greatest, so we put arr[i]
            }
            
        }//for
        while (!stk.isEmpty())
            System.out.println(stk.pop()+"->-1");
    }
        
    }
        

