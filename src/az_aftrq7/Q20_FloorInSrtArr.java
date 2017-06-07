package az_aftrq7;

public class Q20_FloorInSrtArr {
    int arr[] = {1,2,3,5,6};
    //This can be done in o(n) using simple iteration and keeping the index with min diff
    //But we do it in binary search for as it is more efficient and takes o(logn)
    
    public Q20_FloorInSrtArr(){
        BinSrch(4, 0, arr.length-1);
    }
    
    void BinSrch(int value, int l, int r){
        //mid for 1,2,3,4 is index 1, but division gives 2 
        //and 1,2,3,4,5,6 is 3 but division gives 2
        int mid = (l+r)/2;
        System.out.println("searching between "+ l + " and " + r + " and mid is "+mid);
        if (l>r) {System.out.println("Closest at "+mid);return;}
        if (arr[mid]<value) BinSrch(value, mid+1, r);
        else if (arr[mid]>value) BinSrch(value, l, mid-1);
        else System.out.println("Value at index "+mid);
    }
    
    

}
