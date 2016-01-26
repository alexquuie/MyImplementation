public class Solution {
    public int removeDuplicates(int[] nums) {
        int fast = 1;
        int slow = 0;
        int twice = 0;
        while(fast<nums.length){
            System.out.println("twice "+twice+" fast: "+fast+" nums[fast]: "+nums[fast]+ " slow: "+slow+" nums[slow]: "+ nums[slow]);
            if(nums[fast] == nums[slow] && twice==1){
                fast++;
            }else{
                if(nums[slow] == nums[fast]){
                    twice++;
                }else{
                    twice = 0;
                }
                slow++;
                nums[slow] = nums[fast];
                System.out.println("After switch, slow: "+slow+" nums[slow] "+nums[slow]+ " fast: "+fast+" nums[fast] "+nums[fast]);
                fast++;
            }
        }
        System.out.println("nums: ");
        for(int i=0;i<nums.length;i++){
            System.out.print(nums[i]+" ");
        }
        System.out.println();
        return slow+1;
    }
    public static void main(String []args){
        Solution sl = new Solution();
        int [] arr1 = {1,1,1,2,2,3};
        int res1 = sl.removeDuplicates(arr1);
        System.out.println("arr length: "+ res1);
        System.out.println();

        int [] arr2 = {1,2,2};
        int res2 = sl.removeDuplicates(arr2);
        System.out.println("arr length: "+ res2);
        System.out.println();

        int [] arr3 = {1,1,2};
        int res3 = sl.removeDuplicates(arr3);
        System.out.println("arr length: "+ res3);
        System.out.println();
    }
}