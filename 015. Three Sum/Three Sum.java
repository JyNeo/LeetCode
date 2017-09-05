/**************************************************************************************
 * Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0? 
 * Find all unique triplets in the array which gives the sum of zero.
 * Note: The solution set must not contain duplicate triplets.
 *
 * For example, given array S = [-1, 0, 1, 2, -1, -4],
 *
 * A solution set is:
 * [
 *  [-1, 0, 1],
 *  [-1, -1, 2]
 * ]
 *************************************************************************************/

public class Solution{

    // Approach #1 (Brute Force)
    public List<List<Integer>> threeSum(int[] nums){
        List<List<Integer>> result= new ArrayList<List<Integer>>();
        if (nums.length < 3 || nums == null) {
            return result;
        }
        Arrays.sort(nums); //数组排序
        int sum = 0;
        Map<Integer, Integer> map = new HashMap<>(); // 插入代码出错

        for (int i = 0; i < nums.length; i++) { //将数组存入hashmap
            map.put(nums[i], i);
        }
        for (int i = 0; i < nums.length - 2; i++) {
            if (i==0 || nums[i] != nums[i - 1]) { //处理第一层遍历nums[i]的重复
                for (int j = i + 1; j < nums.length - 1; j++) {
                    int complement = sum - nums[i] - nums[j];
                    if (map.containsKey(complement) && map.get(complement) > j) {
                        List<Integer> list = new ArrayList<Integer>();
                        list.add(nums[i]);
                        list.add(nums[j]);
                        list.add(complement);
                        result.add(list);
                    }
                    while(nums[j] == nums[j + 1] && j < nums.length - 2){
                        j++; //处理第二层遍历nums[j]的重复
                    }
                }
            }
        }
        return result;
    }

    // Approach #2 (Sorting With Two Pointers)
    public List<List<Integer>> threeSum(int[] nums){
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (nums.length < 3 || nums == null) {
            return result;
        }
        Arrays.sort(nums); //数组排序
        for (int i = 0; i < nums.length - 2; i++) {
            if(i == 0 || nums[i] != nums[i - 1]){ // 处理nums[i]的重复
                int low = i + 1;
                int high = nums.length - 1;
                while(low < high){
                    int sum = nums[i] + nums[low] + nums[high];
                    if (sum == 0) {
                        List<Integer> list = new ArrayList<Integer>();
                        list.add(nums[i]);
                        list.add(nums[low]);
                        list.add(nums[high]);
                        result.add(list);
                        low++;
                        high--;
                        while (low < high && nums[low] == nums[low - 1]) {
                            low++; //处理nums[low]的重复
                        }
                        while (low < high && nums[high] == nums[high + 1]) {
                            high--; //处理nums[high]的重复
                        }
                    }else if (sum > 0) {
                        high--;
                    }else
                        low++;
                }
            }
        }
        return result;
    }

    // Approach #3 (HashSet)
    public List<List<Integer>> threeSum(int[] nums){
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (nums.length < 3 || nums == null) {
            return result;
        }
        HashSet<List<Integer>> hash = new HashSet<List<Integer>>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            //这种处理重复元素的方式比较容易理解
            if(i > 0 || nums[i] == nums[i - 1])
                continue;
            int low = i + 1;
            int high = nums.length - 1;
            while(low < high){
                int sum = nums[i] + nums[low] + nums[high];
                if (sum == 0) {
                    List<Integer> list = new ArrayList<Integer>();
                    list.add(nums[i]);
                    list.add(nums[low]);
                    list.add(nums[high]);
                    if (!hash.contains(list)) {
                        hash.add(list);
                        result.add(list);
                    }
                    low++;
                    high--;
                }else if (sum < 0) {
                    low++;
                }else
                    high--;
                }
        }
        return result;
    }

    public List<List<Integer>> threeSum(int[] nums){
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (nums.length < 3 || nums == null) {
            return result;
        }
        HashSet<List<Integer>> hash = new HashSet<List<Integer>>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            //另一种处理重复元素的方法
            if(i == 0 || nums[i] != nums[i - 1]){
                int low = i + 1;
                int high = nums.length - 1;
                while(low < high){
                    int sum = nums[i] + nums[low] + nums[high];
                    if (sum == 0) {
                        List<Integer> list = new ArrayList<Integer>();
                        list.add(nums[i]);
                        list.add(nums[low]);
                        list.add(nums[high]);
                        if (!hash.contains(list)) {
                            hash.add(list);
                            result.add(list);
                        }
                        low++;
                        high--;
                    }else if (sum < 0) {
                        low++;
                    }else
                        high--;
                    }
                }
            }
        return result;
    }
}