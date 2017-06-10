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

public class Stack_FindMin {

    int top = -1;
    int[] arr = new int[100];
    int[] min = new int[arr.length + 1];
    int minIndex = -1;

    void push(int val) {
        if ((top+1) == arr.length) {
            return;//overflow
        } else {
            arr[++top] = val;
            if (minIndex!=-1){
                if (min[minIndex] >= val) {
                    min[++minIndex] = val;
                }
            }
            else {//if no mins so far
                min[++minIndex] = val;
            }
        }
    }//end of push

    int pop() {
        if (top < 0) {
            return -999;//underflow
        } else {
            if (arr[top] == min[minIndex]) {
                --minIndex;
            }
            return arr[top--];
        }
    }

    int findMin() {
        return min[minIndex];
    }
    
    public static void main(String[] args) {
        Stack_FindMin s = new Stack_FindMin();
        s.push(4);
        s.push(14);
        s.push(2);
        s.push(1);
        s.push(40);
        s.push(49);
        for (int i=1;i<=6;i++)
            System.out.println("findMin="+s.findMin()+" popped now: "+s.pop());
    }
}
