/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package az_aftrq7;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;

/**
 *
 * @author pranav.nandan
 */

//TODO: Check for different cases if implemented correctly
public class Dijkstra_algo {
    
    static int nodeCount = 5;
    int[] dist = new int[nodeCount];
//all node will have its individual "Parcha" (piece of paper). Remember the video in youtube
    int[] pred = new int[nodeCount];
     static Vertex[]  vertices = new Vertex[nodeCount];
    
    public Dijkstra_algo(int src, int dest) {
        Comparator<Integer> cmp = new ParchaComparator();
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>(new ParchaComparator()); 
        //this will maintain the node index, 
        //the comparator will compare its distances and return the closest
        
        for (int i =1;i<nodeCount;i++) {
            dist[i] = 9999;//infinite distance from S
            pred[i] = -1;//not explored so no predessesor
        }
        dist[0] = 0;//source
        pred[0] = 0;//coz source
        pq.add(src);
        
        while(!pq.isEmpty()){
            int cur = pq.remove();
           
            System.out.println("Visiting node: "+cur);
            vertices[cur].visited = true;
            
            //if (cur.visited) continue;
            for (edge e: vertices[cur].edges){
               if (dist[e.v]>e.wgt+dist[cur]) {//if the newly discovered edge decreases dist to certain vertex than previosly known
                   dist[e.v]=e.wgt+dist[cur];//update the distance
                   pred[e.v] = cur;//predecessor to that should be current
               }
               if (!vertices[e.v].visited) pq.add(e.v);//add the explored vertex in TODO explore list i.e. PQ (Priority queue)
            }
        }
        int indx = pred[dest];
        StringBuilder path = new StringBuilder();
        path.insert(0, indx);//insert the path in reverse order
        path.insert(0, "->");
        while(indx!=src){
            indx = pred[indx];
            path.insert(0, indx);
            path.insert(0, "->");
        }
        System.out.println("The shortest path is "+path.toString()+ " and wght is "+ dist[dest]);
               
        
    }
    
   
    
    public static void main(String[] args) {
         
        for (int i=0;i<vertices.length;i++) vertices[i]= new Vertex();
        System.out.println("Initializing node... ");
         //this is directed graph
         vertices[0].addEdge(2, 1);
         vertices[0].addEdge(4, 3);
         vertices[1].addEdge(3, 2);
         vertices[2].addEdge(1, 4);
         vertices[2].addEdge(5, 3);
         vertices[3].addEdge(8, 0);
         vertices[4].addEdge(7, 3);
         
         Dijkstra_algo dalgo = new Dijkstra_algo(0,4);//find shortest path from vertex 0 to vertex 4
         
         
         System.out.println("complete");
         
         
         
    }

    private class ParchaComparator implements Comparator<Integer>{


        @Override
        public int compare(Integer o1, Integer o2) {
            return dist[o2]-dist[o1]; //02 - o1 because we want to return the smaller distance
        }
    }

    
    
    
}



class Vertex{
    ArrayList<edge> edges = new ArrayList<edge>();
    Boolean visited = false;
    int label;

    public Vertex() {
    }
    
    
    
    
    void addEdge(int w, int v){
        edges.add(new edge(w,v));
    }
}


    class edge{
        int wgt;
        int v;

        public edge(int wgt, int v) {
            this.wgt = wgt;
            this.v = v;
        }
        
    }
