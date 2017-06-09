/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package az_aftrq7;

import static az_aftrq7.Func8_AVLTreeInsertion.insert;

/**
 *
 * @author pranav.nandan
 */
public class Func8_AVLTreeInsertion {
    static N root;
    static class N{int d;N l;N r;
        N(int d){ this.d = d; }
    }
    
    static N insert(N r, int val){
        if (r==null) return new N(val);
        else {
            if (r.d>val) r.l = insert(r.l,val);
            else r.r = insert(r.r,val);
        }
        return r;//original root unchanged after backtrackked
    }
    
    static void insert(int val){
        if (root==null) {//no node yet in tree
            root = new N(val);  return;}
        else 
            insert(root, val);//TODO : Fix
    }
    
    static void inorder(N r){
        if (r.l!=null) inorder(r.l);
        System.out.println(""+r.d);
        if (r.r!=null) inorder(r.r);
    }
    
    static N search(N r, int key){
        if (r==null){
            System.out.println("Not found: "+ key);
            return null;
        }
        else if (key==r.d) {
            System.out.println("Found key: "+r.d);
            return r;
        }
        else if (key<r.d) return search(r.l, key);//key should be on left
        else if (key>r.d) return search(r.r, key);
        System.out.println("IT SHOULD NEVER COME HERE");
        return null;//should never come here
    }
    
    /** 
     * if leaf => del node
     * if one child => child of child becomes new child of parent
     * if two child => left most node in right child replaces the node
     * 
     * **/
    
     static void del(N r, int key){
        N p = searchParent(root, key);
        N k = (p.l!=null && p.l.d==key)?p.l:p.r;//key to delete
        boolean isLeft = (p.l!=null && p.l.d==key);
        if (p==null){//if not found
            System.out.println("No Node found to delete ");
        }
        else {//parent node found
            if (k.l==null && k.r==null){//key have no left and right child
                if (isLeft) p.l =null;//it is safe to delete the key straightaway
                else p.r=null;
            }
            else if (k.l==null){//key have only right child
                if(isLeft) {
                    p.l = k.r;
                }
                else {
                    p.r = k.r;
                }
            }
            else if (k.r==null){//key has only left child
                 if(isLeft){
                    p.l = k.l;
                }
                else {
                    p.r = k.l;
                }
            }
            else{//both child of the key to delete exists
                N pLM = ParentOfLeftMost(k);//only right can exist as we are on far left
                if(isLeft){
                    p.l = pLM.r;
                }
                else {
                    p.r = pLM.r;
                    
                }
            }
        }
    }
    
    static N ParentOfLeftMost(N root){
        if (root.l.l==null) return root;
        else return ParentOfLeftMost(root.l);
    }
     
      
    static N searchParent(N r, int key){//be careful about the null nodes when dealing with parents
        if (r==null){
            return null;
        }
        else if (r.l!=null && key==r.l.d ){
            return r;
        }
        else if (r.r!=null && key==r.r.d ){
            return r;
        }
        else if (r.l!=null && key<r.d) return searchParent(r.l, key);//key should be on left
        else if (r.r!=null && key>r.d) return searchParent(r.r, key);
        System.out.println("IT SHOULD NEVER COME HERE");
        return null;
    }
     
    public static void main(String[] args) {
        insert(5);
        insert(1);
        insert(2);
        insert(6);
        insert(15);
        insert(50);
        insert(33);
        insert(17);
        inorder(root);
        search(root, 15);
        search(root, 16);
        searchParent(root,6);
        System.out.println("Parent of Node 6 is "+ searchParent(root, 6).d + "");
        System.out.println("Parent of Node 17 is "+ searchParent(root, 17).d + "");
         
        del(root, 17);
        System.out.println("After deletion of 17 ");
        inorder(root);
        
        del(root, 33);
        System.out.println("After deletion of 33 ");
        inorder(root);
        
        del(root, 15);
        System.out.println("After deletion of 15 ");
        inorder(root);
        
    }
    
}
