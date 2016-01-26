import java.util.*;
public class Solution {
	public double findMedian(int[] nums1, int beg1, int end1, 
		int[] nums2, int beg2, int end2) {
        int len1 = end1-beg1+1;
        int len2 = end2-beg2+1;
        double mid1 = 0.0, mid2 = 0.0;        
        int midUpIdx1 = 0, midLowIdx1 = 0, midUpIdx2 = 0, midLowIdx2 = 0;
        if(len1!=0){
        	if(len1%2==0){
        		mid1 = (double)(nums1[(end1+beg1)/2] + 
        			nums1[(end1+beg1)/2+1])/2;        	
        		midUpIdx1 = (end1+beg1)/2+1;
         		midLowIdx1 = (end1+beg1)/2;
        	}else{
        		mid1 = (double)(nums1[(end1+beg1)/2]);
        		midUpIdx1 = (end1+beg1)/2;
         		midLowIdx1 = (end1+beg1)/2;
        	}
        }
        
        if(len2!=0){
        	if(len2%2==0){
        		mid2 = (double)(nums2[(end2+beg2)/2] + 
        			nums2[(end2+beg2)/2+1])/2;  	
        		midUpIdx2 = (end2+beg2)/2+1;
         		midLowIdx2 = (end2+beg2)/2;
        	}else{
        		mid2 = (double)(nums2[(end2+beg2)/2]);
        		midUpIdx2 = (end2+beg2)/2;
         		midLowIdx2 = (end2+beg2)/2;
        	}
        }

        if(nums1.length==0){
        	return mid2;
        }else if(nums2.length==0){
        	return mid1;
        }else if(len1==2&&len2==1){
        	PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
        	pq.offer(nums1[beg1]);
        	pq.offer(nums1[end1]);
        	pq.offer(nums2[beg2]);
        	pq.poll();
        	return pq.poll();
        }else if(len1==1&&len2==2){
        	PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
			pq.offer(nums1[beg1]);
        	pq.offer(nums2[beg2]);
        	pq.offer(nums2[end2]);
        	pq.poll();
        	return pq.poll();
        }else if(len1==1&&len2==1){
        	return (double)(nums1[beg1]+nums2[beg2])/2;
        }

        if(mid1<mid2){
        	return findMedian(nums1, midUpIdx1, end1, nums2, beg2, midLowIdx2);
        }else if(mid1==mid2){
        	return mid1;
        }else{
        	return findMedian(nums1, beg1, midLowIdx1, nums2, midUpIdx2, end2);
        }
    }
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if(nums1.length==0&&nums2.length==0){
        	return 0;
        }else{
        	return findMedian(nums1, 0, nums1.length-1, nums2, 0, nums2.length-1);
        }
    }
    public static void main(String [] args){
    	Solution sl = new Solution();
    	int []arr1 = {1,3,5,7,9};
    	int []arr2 = {2,4,6,8};
    	System.out.println(sl.findMedianSortedArrays(arr1, arr2)); 
    }
}