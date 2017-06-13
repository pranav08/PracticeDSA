package az_aftrq7;

/**
 *
 * @author pranav.nandan
 */
public class ReverseList {
    
static class LL{
N r;//head root
N t;//tail


public void insrt(int v){
if (r==null){
r = new N(v);
t = r;
}
else if(r.nxt==null){
r.nxt=new N(v);
t = r.nxt;
}
else{
t.nxt = new N(v);
t =t.nxt;
}
}



}    

static void print(N x){
while(x!=null) { System.out.print(x.d+","); x=x.nxt; }
System.out.println("");
}
     
static class N{int d;N nxt;
N(int x){this.d = x;}

}

//static N reverse(N x){
//    N newroot = x;
//    N tmp;
//    if (x==null) return null;
//    if (x.nxt==null) return x;
//    tmp = reverse(x.nxt);
//    newroot.nxt =tmp;
//    return newroot;
//}
// 
static N reverse(N head){
    N prev = null;N cur = head;N nextNode = null;
    while(cur!=null){
        nextNode = cur.nxt;
        cur.nxt = prev;//Remember, first next is going to be null
        prev = cur;
        cur = nextNode;
    }        
    return prev;
}


    public static void main(String[] args) {
        LL r = new LL();// r is root here
        r.insrt(17);
        r.insrt(47);
        r.insrt(1);
        r.insrt(20);
        r.insrt(22);
        r.insrt(7);
        r.insrt(70);
        print(r.r);
        r.r = reverse(r.r);
        print(r.r);
        
    }

}


