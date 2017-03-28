import java.util.*;

class TwoSum{
	// Approach #1 (Brute Force)
	public int[] twoSum(int[] numbers, int target) {
    	int[] result = new int[2];
			for (int i=0; i<numbers.length; i++) {
				for (int j=i+1; j<numbers.length; j++) {
					if (numbers[j] == target - numbers[i]) {
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
		for (int i = 0; i < numbers.length; i++) {//复制数组
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
					if(numbers[i] == nums[right] && i != result[0])//避免查找到两个相同元素
						result[1] = i;
				}
				if (result[0] > result[1]) {//保证找到的第一个整数索引比第二个要小
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
// leetcode很好的一点就是不用考虑输入输出，只需要提交你的解决方案
// 这是我自己写的一个输入输出测试，Java语言处理输入有点烦。。
public class Solution001{
	public static void main(String[] args){
		int count = 0;
		int target;
		int[] numbers = new int[10];
		int[] temp = new int[10];
		int[] results = new int[2];

		Scanner in = new Scanner(System.in);
		System.out.println("please give an array of intergers and a target:");

		while(in.hasNextInt())
			temp[count++] = in.nextInt();

		target = temp[count-1];

		for(int i=0; i<count-1; i++)
			numbers[i] = temp[i];

		TwoSum ts = new TwoSum();
		results = ts.twoSum(numbers, target);
		System.out.print(results[0] + " " + results[1]);
		System.out.println();
	}
}
