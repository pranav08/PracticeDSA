package az_aftrq7;
/**
 *
 * @author pranav.nandan
 */
public class FrontBackSplit{

static class LL{
N r;//head or root
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


static class N{int d;N nxt;
N(int x){this.d = x;}

}

static N MergeSort(N inp){
    //split the LL into 2 half, end case is till unit element
    //combine in a sorted order both list
    if (inp==null || inp.nxt==null) return inp;//single element or no element
    //LL a = MergeSort()
    N a = findMid(inp);
    N b = a.nxt;
    a.nxt = null;
    a = inp; //rewind the pointer back from mid to first       
    //always remember object attributes can be changed via copy of pointer, but not object itself. Here b is the copy of actual node.
    //also we have set it to null so that our findMid works correctly on next reuruse. Don't worry baby, we will merge that missing part anyway, right? Hehe
    return Merge(MergeSort(a),MergeSort(b));
      
}

static N Merge(N a, N b){
    N c = new N(a.d<b.d?a.d:b.d);//aux array
    N copyOfCRoot = c;
    //at this point a and b are already sorted array
    if (a.d<b.d) a=a.nxt; else b=b.nxt;
    while(a!=null && b!=null){
        if (a.d<b.d) {c.nxt = new N(a.d); a = a.nxt;}
        else {c.nxt = new N(b.d); b = b.nxt;}
        c=c.nxt;
    }
    while(a!=null) {c.nxt = new N(a.d); a = a.nxt;c=c.nxt;}
    while(b!=null) {c.nxt = new N(b.d); b = b.nxt;c=c.nxt;}
    
    return copyOfCRoot;
}

static N findMid(N inp){
    N s = inp;//slow pointer
    N f = inp.nxt;//fast pointer
    while (f!=null && f.nxt!=null){
        f=f.nxt;
        s=s.nxt;
        if (f!=null) f=f.nxt;
    }
    return s;
}



static void print(N x){
while(x!=null) { System.out.print(x.d+","); x=x.nxt; }
System.out.println("");
}

public static void main(String[] args){

LL r = new LL();// r is root here
r.insrt(17);
r.insrt(47);
r.insrt(1);
r.insrt(20);
r.insrt(22);
r.insrt(7);
r.insrt(70);
print(r.r);
System.out.println("Mid is "+findMid(r.r).d);
print(MergeSort(r.r));
    

}

}


