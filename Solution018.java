public class Solution018{
    public static void main(String[] args) {

    }
}

class FourSum{
    // Approach #1 (HashSet)
    public List<List<Integer>> fourSum(int[] nums, int target){
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        HashSet<List<Integer>> set = new HashSet<List<Integer>>();
        Arrays.sort(nums); // 数组排序
        for (int i = 0; i < nums.length - 3; i++) {
            for (int j = i + 1; j < nums.length - 2; j++) {
                int low = j + 1;
                int high = nums.length - 1;
                while(low < high){
                    int sum = nums[i] + nums[j] + nums[low] + nums[high];
                    if (sum == target) {
                        List<Integer> list = new ArrayList<Integer>();
                        list.add(nums[i]);
                        list.add(nums[j]);
                        list.add(nums[low]);
                        list.add(nums[high]);
                        if (!set.contains(list)) { // 利用hashset处理重复元素
                            set.add(list);
                            result.add(list);
                        }
                        low++; // 结果不唯一，low和high指针应该继续移动
                        high--;
                    }else if (sum > target) {
                        high--;
                    }else
                        low++;
                }
            }
        }
        return result;
    }

    // Approach #2 (Sorting With Two Pointers)
    public List<List<Integer>> fourSum(int[] nums, int target){
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 3; i++) {
            if(i > 0 && nums[i] == nums[i - 1]) // 处理nums[i]的重复
                continue;
            for (int j = i + 1; j < nums.length - 2; j++) {
                if(j > i + 1 && nums[j] == nums[j - 1]) // 处理nums[j]的重复
                        continue;
                int low = j + 1;
                int high = nums.length - 1;
                while(low < high){
                    int sum = nums[i] + nums[j] + nums[low] + nums[high];
                    if (sum == target) {
                        List<Integer> list = new ArrayList<Integer>();
                        list.add(nums[i]);
                        list.add(nums[j]);
                        list.add(nums[low]);
                        list.add(nums[high]);
                        result.add(list);
                        low++;
                        high--;
                        while (low < high && nums[low] == nums[low - 1]) { // 处理nums[low]的重复
                            low++;
                        }
                        while (low < high && nums[high] == nums[high + 1]) { // 处理nums[high]的重复
                            high--;
                        }
                    }else if (sum > target) {
                        high--;
                    }else
                        low++;
                }
            }
        }
        return result;
    }
}
