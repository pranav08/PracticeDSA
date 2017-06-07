/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package az_aftrq7;

import java.util.Arrays;
import java.util.LinkedList;
class Func_Q3_GreyCodes{

static LinkedList<StringBuffer> gc = new LinkedList<StringBuffer>();
static LinkedList<StringBuffer> oneBit = new LinkedList<StringBuffer>();
static int required = 8;

public static void main(String args[]){

oneBit.add(new StringBuffer("0"));
oneBit.add(new StringBuffer("1"));

LinkedList<StringBuffer> ans = generate(1, oneBit);
for (StringBuffer v: ans){
	System.out.println(v.toString());
}
}

static LinkedList<StringBuffer> generate(int bits, LinkedList<StringBuffer> current){
if (bits==required) return current;
else {
	for (int i=current.size()-1;i>=0;i--){//mirror
		current.add(new StringBuffer(current.get(i)));
	}
	for (int i=0;i<current.size()/2;i++){//add 0 to first half
		current.get(i).insert(0,"0");
	}
	for (int i=current.size()/2;i<current.size();i++){//add 1 to second half
		current.get(i).insert(0,"1");
                
	}
        return generate(++bits, current);
}

}//end - generate 


}//end - class