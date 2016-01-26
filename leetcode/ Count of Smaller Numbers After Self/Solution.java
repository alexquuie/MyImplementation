import java.util.*;

public class Solution {
    public static class Unit{
        public int val = 0;
        public int idx = -1;
        public int cnt = 0;
        public Unit(int v, int i){
            val = v;
            idx = i;
        }
    }
    public List<Integer> countSmaller(int[] nums) {
        if(nums.length<1){
            return new ArrayList<Integer>();
        }
        if(nums.length==1){
            ArrayList<Integer> res = new ArrayList<Integer>();
            res.add(0);
            return res;
        }
        Unit []arr = new Unit[nums.length];
        Unit []sorted = new Unit[nums.length];
        ArrayList<Integer> res = new ArrayList<Integer>();
        for(int i=0;i<nums.length;i++){
            arr[i] = new Unit(nums[i],i);
            sorted[i] = new Unit(0,-1);
            res.add(0);
        }
        mergeSort(arr, 0, nums.length-1, sorted);
        for (int i = 0; i < sorted.length; i++){
            res.set(sorted[i].idx, sorted[i].cnt);  
        } 
        return res;  
    }
    public void mergeSort(Unit[] arr, int l, int r, Unit[] sorted){
        if (l < r) {  
            int m = (l + r)>> 1;  
            mergeSort(arr, l, m, sorted);  
            mergeSort(arr, m + 1, r, sorted);  
            merge(arr, l, m, r, sorted);  
        }  
    }
    public void merge(Unit[] arr, int lbegin, int lend, int rend, Unit[] sorted){
        int rbegin = lend + 1;  
        int Tpos = lbegin;  
        int n = rend - lbegin + 1;  
        int t = rbegin;  
        while (lbegin <= lend && rbegin <= rend) {  
            if (arr[lbegin].val <= arr[rbegin].val) {  
                sorted[Tpos] = arr[lbegin];  
                sorted[Tpos].cnt += rbegin - t ;  
                Tpos++; lbegin++;  
            }  
            else {  
                sorted[Tpos++] = arr[rbegin++];  
            }  
        }  
  
        while (lbegin <= lend) {  
            sorted[Tpos] = arr[lbegin];  
            sorted[Tpos].cnt += rbegin - t;  
            Tpos++; lbegin++;  
        }  
  
        while (rbegin <= rend)   
            sorted[Tpos++] = arr[rbegin++];  
  
        for (int i = 0; i< n; i++, rend--){
            arr[rend] = sorted[rend]; 
        }    
    }
    public static void main(String [] args){
        Solution sl = new Solution();
        int [] arr1 = {-1};
        System.out.println(sl.countSmaller(arr1));
        int [] arr2 = {5,2,6,1};
        System.out.println(sl.countSmaller(arr2));
    }
}