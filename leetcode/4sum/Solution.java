import java.util.*;
public class Solution {
    public void twoSum(int[] nums, int target, ArrayList<Integer> out, int startIdx, List<List<Integer>> res) {
        int left = startIdx, right = nums.length-1;
        while(left<right){
            if(nums[left]+nums[right] == target){
                out.add(nums[left]);
                out.add(nums[right]);
                res.add(out);
                out.remove(out.size()-1);
                out.remove(out.size()-1);
                do{
                    left++;
                }while(left < nums.length && nums[left]==nums[left+1]);
                
                do{
                    right--;
                }while(right >=0 && nums[right-1]==nums[right]);
                
            }else if(nums[left]+nums[right] < target){
                left++;
            }else{
                right--;
            }
        }
    }
    public void threeDfs(int[] nums, int target, ArrayList<Integer> out, int startIdx, List<List<Integer>> res) {
        if(startIdx>=nums.length){
            return;
        }else{
            for(int i=startIdx;i<nums.length;i++){
                out.add(nums[i]);
                twoSum(nums, target - nums[i], out, i+1, res);
                out.remove(out.size()-1);
            }
        }
    }
    public void fourDfs(int[] nums, int target, ArrayList<Integer> out, int startIdx, List<List<Integer>> res) {
        if(startIdx>=nums.length){
            return;
        }else{
            for(int i=startIdx;i<nums.length;i++){
                out.add(nums[i]);
                threeDfs(nums, target - nums[i], out, i+1, res);
                out.remove(out.size()-1);
            }
        }
    }
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        ArrayList<Integer> out = new ArrayList<Integer>();
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        fourDfs(nums, target, out, 0, res);
        return res;
    }
    public static void main(String[] args){

    }
}