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
import java.util.Stack;
public class Func_Q1_StackSort {
    

static Stack<Integer> src = new Stack<Integer>();
static Stack<Integer> aux = new Stack<Integer>();

static int[] input = {5,2,3,1,4};
static int tmp,t;
public static void main(String args[]){
for (int v: input){
	src.push(v);
}


int toPopCnt = src.size();
while(toPopCnt>0){
	tmp = src.pop();
	while(!src.isEmpty() && toPopCnt>0){
		t = src.pop();
		if (t>tmp) {aux.push(tmp); tmp = t;}
		else aux.push(t);
	}
	src.push(tmp);//as it is the smallest
	--toPopCnt;//next time pop one less, because smallest is already in place
	while(!aux.isEmpty()) src.push(aux.pop());//push all back into src
}

while(!src.isEmpty()) System.out.println(src.pop());

}//main

    
}
