package com.algo.easy;

public class TwoSum167 {
	/**
	 * Given an array of integers that is already sorted in ascending order, find two numbers such that they add up to a specific target number.
	 *
	 * The function twoSum should return indices of the two numbers such that they add up to the target, where index1 must be less than index2.
	 *
	 * Note:
	 *
	 * Your returned answers (both index1 and index2) are not zero-based.
	 * You may assume that each input would have exactly one solution and you may not use the same element twice.
	 * Example:
	 *
	 * Input: numbers = [2,7,11,15], target = 9
	 * Output: [1,2]
	 * Explanation: The sum of 2 and 7 is 9. Therefore index1 = 1, index2 = 2.
	 */

	public int[] twoSum2(int[] numbers, int target) {
		int[] answer = new int[]{0, 0};
		for(int i = 0; i < numbers.length - 1; i++) {
			for(int j = i + 1; j < numbers.length; j++) {
				if(numbers[i] + numbers[j] > target) {
					break;
				} else if(numbers[i] + numbers[j] == target) {
					answer[0] = i + 1;
					answer[1] = j + 1;
					break;
				}
			}
		}
		return answer;
	}
}
