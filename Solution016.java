public class Solution{
    
    public int threeSumClosest(int[] nums, int target){
        int closest_target = nums[0] + nums[1] + nums[2]; // closest_target为最接近的3Sum
        int smallest_difference_value = Math.abs(closest_target - target); // 3Sum与target之间最小的差值
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            int low = i + 1;
            int high = nums.length - 1;

            while(low < high){
                int sum = nums[i] + nums[low] + nums[high];
                int temp = Math.abs(sum - target);
                if (temp < smallest_difference_value) {
                    closest_target = sum;
                    smallest_difference_value = temp;
                }
                // sum的值必须无限接近target，以此来判断low和high指针的移动
                if (sum < target) {
                    low++;
                }else
                    high--;
            }
        }
        return closest_target;
    }
}
