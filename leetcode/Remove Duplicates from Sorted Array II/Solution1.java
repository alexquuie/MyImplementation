public class Solution1 {
    public int removeDuplicates(int[] nums) {
        int n = nums.length;
        if (n <= 2) return n;
        int slow = 0, fast = 1, count = 1;
        while (fast < n) {
            System.out.println("count "+count+" fast: "+fast+
                " nums[fast]: "+nums[fast]+ " slow: "+slow+" nums[slow]: "+ nums[slow]);
            if (nums[slow] == nums[fast] && count == 0){
                ++fast;
            }else {
                if (nums[slow] == nums[fast]){
                    --count;
                }else{
                    count = 1;
                }
                nums[++slow] = nums[fast++];
            }
        }

        System.out.println("nums: ");
        for(int i=0;i<nums.length;i++){
            System.out.print(nums[i]+" ");
        }
        System.out.println();
        return slow + 1;
    }
    public static void main(String []args){
        Solution1 sl = new Solution1();
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