/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package az_aftrq7;

/**
 *
 * @author Pranav Nandan
 */
public class Func_Q87_CheckBalanceBST_better {
    //PostOrder traversal
//Left Right and Root
static class Node{
    Node l;
    Node r;
    int data;
    Node (int d){
        data = d;
    }
}

static class HeightInfo{
    int nodeH;
    boolean isTreeBalancedTillNow;
        public HeightInfo(int h, boolean b) {
            this.nodeH = h;
            isTreeBalancedTillNow = b;
        }
}

static HeightInfo postOrder(Node x){//HeighInfo is wrapper class we use to two piece of information in one return 
    //we create that wrapper class because intuitively we are returning two diff info i.e. 
    //height of that subtree node + WHEATHER TREE as a whole is balanced or not till that point
    //at first it sounds as if it is one piece of info, BUT a node balanced does not gurantee 
HeightInfo lh = new HeightInfo(0, true);
HeightInfo rh = new HeightInfo(0, true);
HeightInfo h = new HeightInfo(0, true);
if (x==null) return new HeightInfo(1, true);//lets consider leaves as 1 
else {
    if (x.l!=null) lh = postOrder(x.l);
    if (x.r!=null) rh = postOrder(x.r);
    h.isTreeBalancedTillNow = Math.abs(lh.nodeH-rh.nodeH)<=1 && 
                                                          lh.isTreeBalancedTillNow && 
                                                            rh.isTreeBalancedTillNow;//TO INTRODUCE COMPONENT
    System.out.println("Node "+x.data+" has LH="+lh.nodeH+" & RH="+ rh.nodeH +" and Balance "+ (lh.nodeH-rh.nodeH) +" balanced= "+h.isTreeBalancedTillNow);
    h.nodeH = lh.nodeH >rh.nodeH ?
            lh.nodeH+1:
            rh.nodeH+1;
    
    return h;//the balance will used by its parent
    }
}

static boolean isBalancedBST(Node x){
    return postOrder(x).isTreeBalancedTillNow;
}



public static void main(String args[]){
Node a = new Node(10);
a.l = new Node(5);
a.l.l = new Node(1);
a.l.l.r = new Node(2);
a.l.r = new Node(7);
a.l.r.r = new Node(8);
a.l.r.r.r = new Node(9);

System.out.println(isBalancedBST(a));



}






}
