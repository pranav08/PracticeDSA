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
class WordPalindrome{
StringBuilder sen;

String palindrome(){
int j = 0;//start index
for (int i=0;i<=sen.length()-1;i++){
    if (sen.charAt(i)==' '){
        reverse(j,i-1);//reverse individual words
        j=i+1;//update the next start index
    }//if
}//for
//Now reverse the entire string
reverse(j,sen.length()-1);//just for the last remaining word as it does not ends with ' '.
reverse(0,sen.length()-1);
return sen.toString();
}//palindrome

void reverse(int i, int j){
char tmp; 
while (i<j){
    tmp = sen.charAt(i);
    sen.setCharAt(i,sen.charAt(j));
    sen.setCharAt(j,tmp);
    j--;
    i++;
}//while
}//reverse

    public static void main(String[] args) {
        WordPalindrome w = new WordPalindrome();
        w.sen = new StringBuilder("i love programming very much");
        System.out.println(""+w.palindrome());
    }

}


