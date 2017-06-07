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

//This can be done via exploration using depth first searching, and ruling out the visited nodes
//the logic is if recursive depth first ends, but we still have unvisited cells that have x, then start DFS(x)
//in this case, obviously we have more than 1 graph.
public class Q29_XTotalShapes_creativeLong {
    char[][] mat = 
    {{'O','O','O','x','O','O','O'},
    { 'O','x','x','x','x','x','O'},
    { 'O','x','O','o','O','x','O'}};
    ArrayList<N> graph = new ArrayList<N>();

    public Q29_XTotalShapes_creativeLong() {
    
        for(int i =0;i<mat.length;i++){
            for(int j =0;j<mat[0].length;j++){
                if(mat[i][j]=='x'){
                //check if to existing nodes in graph can actually connect to it, If Yes, connect
                    
                    
                }
            }
            
        }
    
    
    }
    
    class N{
        int x;
        int y;
        ArrayList <N> connected = new ArrayList <N>();

        public N(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
    

    

