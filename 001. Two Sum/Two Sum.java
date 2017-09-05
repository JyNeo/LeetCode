/************************************************************************************************************
* Given an array of integers, return indices of the two numbers such that they add up to a specific target.
*
* You may assume that each input would have exactly one solution, and you may not use the same element twice.
*
* Example:
* Given nums = [2, 7, 11, 15], target = 9,
*
* Because nums[0] + nums[1] = 2 + 7 = 9,
* return [0, 1].
*
*************************************************************************************************************/

class Solution {
	// Approach #1 (Brute Force)
    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        for (int i = 0; i < nums.length(); i++) {
        	for (int j = i + 1; j < nums.length; j++) {
        		if (nums[i] + nums[j] == target) {
        			result[0] = i;
        			result[1] = j;
        		}
        	}
        }
        return result;
    }

    // Approach #2 (Two-pass Hash Table)
	public int[] twoSum(int[] numbers, int target) {
		int[] result = new int[2];
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < numbers.length; i++) {
			map.put(numbers[i], i);
		}
		for (int i = 0; i < numbers.length; i++) {
			int complement = target - numbers[i];
			if (map.containsKey(complement) && map.get(complement) != i) {
				result[0] = i;
				result[1] = map.get(complement);
				return result;
			}
		}
		throw new IllegalArgumentException("No two sum solution");
	}

	// Approach #3 (One-pass Hash Table)
	public int[] twoSum(int[] numbers, int target) {
    	int[] result = new int[2];
    	Map<Integer, Integer> map = new HashMap<Integer, Integer>();
    	for (int i = 0; i < numbers.length; i++) {
    	    if (map.containsKey(target - numbers[i])) {
        	    result[1] = i;
        	    result[0] = map.get(target - numbers[i]);
            	return result;
        	}
        	map.put(numbers[i], i);
    	}
    	return result;
	}

	// Approach #4 (Sorting With Two Pointers)
	public int[] twoSum(int[] numbers, int target) {
    	int[] result = new int[2];
		int[] nums = new int[numbers.length];
		for (int i = 0; i < numbers.length; i++) { //复制数组
			nums[i] = numbers[i];
		}
    	if(nums == null || nums.length < 2)
        	return null;
    	Arrays.sort(nums);//数组排序
    	int left = 0;
    	int right = nums.length - 1;
    	while(left < right){
        	if(nums[left] + nums[right] == target){
				for (int i = 0; i < numbers.length; i++) {
					if(numbers[i] == nums[left])
						result[0] = i;
				}
				for (int i = 0; i < numbers.length; i++) {
					if(numbers[i] == nums[right] && i != result[0]) //避免查找到两个相同元素
						result[1] = i;
				}
				if (result[0] > result[1]) { //保证找到的第一个整数索引比第二个要小
					int temp = result[0];
					result[0] = result[1];
					result[1] = temp;
				}
            	return result;
        	}
        	else if(nums[left] + nums[right] > target)
            	right--;
        	else
            	left++;
    	}
    	return null;
	}
}
