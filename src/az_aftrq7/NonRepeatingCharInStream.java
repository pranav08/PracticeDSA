/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package az_aftrq7;

import java.util.HashSet;
import java.util.LinkedList;
/**
 *
 * @author pranav.nandan
 */
public class NonRepeatingCharInStream {
//Always return the first non repeating character in the stream
//My logic: remember to keep the non repeating characters in a queue
//Keep the stream logic in the hashset
char[] arr = {'a','a','c'};
HashSet<Character> hs = new HashSet<>();
LinkedList<Character> neverRepeated = new LinkedList<Character>(); 

    public NonRepeatingCharInStream() {
        
        for (Character c: arr){
            if (hs.contains(c)){//repeating
                if (neverRepeated.contains(c)) neverRepeated.remove(c);
                
            }
            else {//non repeated
                
                neverRepeated.add(c);
                hs.add(c);
            }
        if (neverRepeated.size()>0) System.out.println("=>"+neverRepeated.get(0));
        else System.out.println("-1");
        }
        
    }//method
    
}
