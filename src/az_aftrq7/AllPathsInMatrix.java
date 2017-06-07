/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package az_aftrq7;

import java.util.LinkedList;

public class AllPathsInMatrix {
static LinkedList<Tuple> path;
static int[][] m = {{1,2,3,4},
                    {5,6,7,8},
                    {9,10,11,12},
                    {13,14,15,16}};

static void go(int x,int y){
//go either right or bottom
if (x==3 && y==3){
	//System.out.println("End");
        System.out.println("STRT");
        for (Tuple v: path)
            System.out.println(""+v.getX()+" , "+v.getY());
        System.out.println("END");
	return;
}
else
{
	if (x+1<=3){
                //System.out.println(""+(x+1)+", "+y);
		path.add(new Tuple(x+1,y));
		go(x+1,y);
                path.removeLast();//I chose to remove this here after much thought, thinking in terms of the state during the scope of the object
                //I mean the path where we moved (x+1,y), will only be a part of solutions that goes through it. If it has reached this line, this means
                //the processing or the visit to that has ended.
                
	}
	if (y+1<=3){
               // System.out.println(""+x+", "+(y+1));
		path.add(new Tuple(x+1,y));
		go(x,y+1);
                path.removeLast();
	}
    
	//when it backtracks, the value of x is still the same, and will continue from der
	//thus, we print the list to print upto common track, and then let another begin
}

}//go

public static class Tuple{
    private int x;
    private int y;

        public Tuple(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }
    
}

    public static void main(String[] args) {
        path = new LinkedList<Tuple>();
        //System.out.println(""+(0)+", "+0);
        path.add(new Tuple(0,0));
        go(0,0);
    }
    
}
