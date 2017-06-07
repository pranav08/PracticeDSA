/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package az_aftrq7;

import java.util.ArrayList;

/**
 *
 * @author pranav.nandan
 */

//We will create a node having posn x,y as data whenever one comes. 
//Then check if any right and down is connected to it as well, if yes, just connect it
//All visited nodes references are also maintained in a set?
//Take one element from a set and do a breath first, print each nodes as part of one small graph
//Remove from the set, repeat the same from remaining

public class Q29_XTotalShapes_short {
    char[][] mat = 
    {{'O','O','O','x','O','O','O'},
    { 'O','x','x','x','x','x','O'},
    { 'O','x','O','o','O','x','O'}};
    
    ArrayList<Pair> graph = new ArrayList<Pair>();
    Boolean[][] vis;
    //Maintain a to visit

    public Q29_XTotalShapes_short() {
    vis = new Boolean[mat.length][mat[0].length];
        for(int i =0;i<mat.length;i++){
            for(int j =0;j<mat[0].length;j++){
                if (vis[i][j]) continue;
                else vis[i][j] = true;
                if(mat[i][j]=='x'){
                    
                    
                    
                }
                
            }
            
        }
    }
    
    class Pair{
        int x;int y;
        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    

}
    

    

