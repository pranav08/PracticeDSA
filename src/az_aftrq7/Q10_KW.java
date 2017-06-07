package az_aftrq7;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

/**
 *
 * @author pranav.nandan
 */
public class Q10_KW {
    //Perfect example of learning from mistake
    
    
   //8x8
   //from 2,8 to 3,4
   //This algorithm is based on the fact that if a node does not takes 
    //to destination, it will never take to destn even if we cross
    //path with the node from other pathways, hence once a node
    //is visited (sooner or laer), it is never reset to not visited
    
    //Also another assumption is the order of visit
    //of nodes does not kill a possible pathway from src to dest
    
    //As you can see, from my assumptions and algorithm, i never have made a choice based on 
    //shorter path or anything, hence i got a long path in answer, which is not optimum
    //there is excel file chess.xls whih visualizes that
    //thus we can see recursion has solved the problem but it only solves if 
    //solution can be divided into smaller solutions. i have exploited the fact
    //that any move can lead to possible solution and rigorously came through it.
    //this is good for board problems with set of configurations, but not optimization usually.
    
    //its just a slightly effective brute force
    //we will now design a grap based solution for this to find the effective
    
    
   boolean[][] board = new boolean[9][9];
   ArrayList<posn> path = new ArrayList<posn>();
   posn dest = new posn(3,4);
   ArrayList<posn> horseJumps = new ArrayList<posn>();
   

    public Q10_KW() {
        initHorseJumps();
        path.add(new posn(2, 8));//src posn
        recur(path);
    }
   
   void recur(ArrayList<posn> path){
       posn cur = path.get(path.size()-1);
       board[cur.x][cur.y] = true;//node is visited
       System.out.println(""+cur.x+","+cur.y);
       if(cur.x==dest.x && cur.y==dest.y){
           System.out.println("Found found found");
       }
       for (posn relative : horseJumps) {//all possible relative posns for horse
           posn tmp = cur.add(relative);//validity check will return null
           if (tmp!=null && !board[tmp.x][tmp.y]){//if not visited
               path.add(tmp);
               recur(path);
           }
        }
       System.out.println("Backtrackked!");
   }
   
   void initHorseJumps(){
       horseJumps.add(new posn(-2,-1));
        horseJumps.add(new posn(-2,1));
        horseJumps.add(new posn(-1,-2));
        horseJumps.add(new posn(-1,2));
        horseJumps.add(new posn(1,-2));
        horseJumps.add(new posn(1,2));
        horseJumps.add(new posn(2,-1));
        horseJumps.add(new posn(2,1));
   }
   
           class posn{
               int x,y;
                public posn(int x, int y) {
                    this.x = x;
                    this.y = y;
                }
                
                public posn add(posn p){
                    //System.out.println("Adding "+p.x+" and "+this.x);
                    posn r = new posn(this.x+p.x,this.y+p.y);
                    if(isValidPosn(r)) return r;
                    else return null;
                }
           }
   
   boolean isValidPosn(posn p){
       return (p.x>=1 && p.x<=8 && p.y>=1 && p.y<=8);
   } 
}
