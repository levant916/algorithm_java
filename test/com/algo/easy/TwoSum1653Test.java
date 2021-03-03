package com.algo.easy;

import java.net.BindException;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;
import java.util.TreeMap;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.junit.jupiter.api.Test;


import com.apple.eawt.AppEvent;
import sun.jvm.hotspot.debugger.linux.LinuxDebugger;

class TwoSum1653Test {

	@Test
	void findTarget() {
		int[][] arr = new int[][] {{0, 1}, {1, 0}};
		flipMatrix(arr, 0);
		int a = 3;
	}

	void flipMatrix(int[][] matrix, int col) {
		for (int i = 0; i < matrix[0].length; i++) {
			if (matrix[i][col] == 0) {
				matrix[i][col] = 1;
			} else {
				matrix[i][col] = 0;
			}
		}
	}

	@Test
	public void tet() {
		decompressRLElist(new int[] {1, 2, 3, 4});

	}

	public void smallerNumbersThanCurrent(int[] nums) {
		int[] sort = new int[nums.length];
		System.arraycopy(nums, 0, sort, 0, nums.length);
		nums.clone();
		Arrays.sort(sort);
		Map<Integer, Integer> sortMap = new HashMap<>();
		int rank = 0;
		for (int i : sort) {
			sortMap.putIfAbsent(i, rank++);
		}

		int[] ans = new int[nums.length];
		for (int i = 0; i < nums.length; i++) {
			ans[i] = sortMap.get(nums[i]);
			System.out.println(ans[i]);
		}
	}

	public int[] decompressRLElist(int[] nums) {
		List<Integer> ans = new ArrayList<>();
		for (int i = 0; i < nums.length / 2; i += 2) {
			int freq = nums[i];
			int val = nums[i + 1];
			for (int j = 0; j < freq; j++) {
				ans.add(val);
			}
		}
		int[] ans2 = new int[ans.size()];
		for (int i = 0; i < ans.size(); i++) {
			ans2[i] = ans.get(i);
			System.out.println(ans2[i]);
		}
		return ans2;
	}

	public int findNumbers(int[] nums) {
		int ans = 0;
		for (int num : nums) {
			if (Integer.toString(num).length() % 2 == 0)
				ans++;
		}
		return ans;
	}

	@Test
	public void t() {
		createTargetArray(new int[] {0, 1, 2, 3, 4}, new int[] {0, 1, 2, 2, 1});
	}
	//Input: nums = [0,1,2,3,4], index = [0,1,2,2,1]
	// 0, 1, 2, 3, 4, 5

	public int[] createTargetArray(int[] nums, int[] index) {
		int[] target = new int[nums.length];
		Arrays.fill(target, -1);
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] != -1) {
				if (index.length - 1 - index[i] >= 0)
					System.arraycopy(target, index[i], target, index[i] + 1, index.length - 1 - index[i]);
			}
			Arrays.fill(target, index[i], index[i] + 1, nums[i]);
		}
		String c;
		char bc = '2';
		return target;
	}

	@Test
	public void sf() {
		System.out.println(balancedStringSplit("LLLLRRRR"));
	}

	public int balancedStringSplit(String s) {
		int ans = 0;
		int b = 0;
		char pivot = 'x'; // just init
		for (Character c : s.toCharArray()) {
			if (b == 0) {
				pivot = c;
			}
			if (c == pivot) {
				b++;
			} else {
				b--;
			}
			if (b == 0) {
				ans++;
			}
		}
		return ans;
	}

	public int minTimeToVisitAllPoints(int[][] points) {
		int[] start = points[0];
		int ans = 0;
		// 두 점 사이의 거리 = x축의 차, y축의 차 중 더 큰값
		for (int i = 1; i < points.length; i++) {
			int[] target = points[i];
			ans += Math.max(Math.abs(target[0] - start[0]), Math.abs(target[1] - start[1]));
			start = target;
		}
		return ans;
	}

	public int maximum69Number(int num) {
		String strN = Integer.toString(num);
		StringBuilder sb = new StringBuilder();
		for (char c : strN.toCharArray()) {
			if (c == '6') {
				c = '9';
			}
			sb.append(c);
		}
		return Integer.parseInt(sb.toString());
	}

	public int oddCells(int n, int m, int[][] indices) {
		int[][] matrix = new int[n][m];
		for (int[] indice : indices) {
			for (int c = 0; c < m; c++) {
				matrix[indice[0]][c] += 1;
			}
			for (int r = 0; r < n; r++) {
				matrix[r][indice[1]] += 1;
			}
		}
		int ans = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (matrix[i][j] % 2 == 1)
					ans++;
			}
		}
		return ans;
	}

	public int countNegatives(int[][] grid) {
		int ans = 0;
		for (int[] sub : grid) {
			for (int i = 0; i < sub.length; i++) {
				if (sub[i] < 0) {
					ans += (sub.length - i + 1);
					System.out.println(sub[i]);
					break;
				}
			}
		}
		return ans;
	}

	@Test
	public void d() {
		System.out.println(sortString("aaaabbbbcccc"));
	}

	public String sortString(String s) {
		char[] ar = s.toCharArray();
		Arrays.sort(ar);    //aaabbbccc
		int[] flags = new int[ar.length];
		StringBuilder sb = new StringBuilder();

		// increasing

		while (sb.length() < ar.length) {
			char inc = 'a' - 1, dec = 'z' + 1;
			for (int i = 0; i < ar.length; i++) {
				if (flags[i] == 0 && ar[i] > inc) {
					flags[i] = 1;
					sb.append(ar[i]);
					inc = ar[i];
				}
			}
			for (int i = ar.length - 1; i >= 0; i--) {
				if (flags[i] == 0 && ar[i] < dec) {
					flags[i] = 1;
					sb.append(ar[i]);
					dec = ar[i];
				}
			}
		}

		return sb.toString();
	}

	@Test
	public void z() {
		System.out.println(Integer.reverse(1));
	}

	public int[] sumZero(int n) {
		int[] ans = new int[n];

		if (n % 2 == 0) {
			int start = -(n / 2);
			for (int i = 0; i < n; i++) {
				if (start == 0) {
					start++;
					i--;
				} else {
					ans[i] = start++;
				}
			}
		} else {
			int start = -((n - 1) / 2);
			for (int i = 0; i < n; i++) {
				ans[i] = start++;
			}
		}
		// 짝수 : -1 1, -2 -1 1 2
		// 홀수 : 0, -1 0 1, -2 -1 0 1 2
		return ans;
	}

	public int uniqueMorseRepresentations(String[] words) {
		String[] mos = new String[] {".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---", "-.-",
			".-..", "--", "-.", "---", ".--.", "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--.."};
		Set<String> ans = new HashSet<>();
		for (String word : words) {
			StringBuilder sb = new StringBuilder();
			for (Character c : word.toCharArray()) {
				sb.append(mos[c - 'a']);
			}
			ans.add(sb.toString());
		}
		return ans.size();
	}

	public String generateTheString(int n) {
		StringBuilder sb = new StringBuilder();

		if (n % 2 == 0) {
			for (int i = 0; i < n - 1; i++) {
				sb.append("a");
			}
			sb.append("b");
		} else {
			for (int i = 0; i < n; i++) {
				sb.append("a");
			}
		}
		return sb.toString();
	}

	public int[][] flipAndInvertImage(int[][] A) {
		for (int[] row : A) {
			int left = 0, right = row.length - 1;
			for (int i = 0; i < row.length; i++) {
				if (left < right) {
					int temp = row[left];
					row[left] = row[right] ^ 1;
					row[right] = temp ^ 1;
					left++;
					right--;
				} else {
					if (left == right) {
						row[left] = row[left] ^ 1;
					}
					break;
				}
			}
		}
		return A;
	}

	public int[] sortArrayByParity(int[] A) {
		int[] visit = new int[A.length];
		int[] ans = new int[A.length];
		int ansIndex = 0;
		for (int i = 0; i < A.length; i++) {
			if (visit[ansIndex] == 0 && ((A[i] % 2) == 0)) {
				ans[ansIndex] = A[i];
				visit[ansIndex++] = 1;
			}
		}
		for (int i = 0; i < A.length; i++) {
			if (ansIndex < A.length && visit[ansIndex] == 0 && ((A[i] % 2) == 1)) {
				ans[ansIndex] = A[i];
				visit[ansIndex++] = 1;
			}
		}
		return ans;
	}

	public List<Integer> luckyNumbers(int[][] matrix) {
		List<Integer> ans = new ArrayList<>();
		for (int[] row : matrix) {
			int min = 100001;
			int minIndex = 0;
			boolean flag = true;
			for (int i = 0; i < row.length; i++) {
				if (row[i] < min) {
					min = row[i];
					minIndex = i;
				}
			}
			int max = min;
			for (int j = 0; j < matrix.length; j++) {
				if (max < matrix[j][minIndex]) {
					flag = false;
					break;
				}
			}
			if (flag) {
				ans.add(max);
			}
		}
		return ans;
	}

	public int[] sortedSquares(int[] A) {
		int[] ans = new int[A.length];
		for(int i=0; i<A.length; i++) {
			ans[i] = A[i] * 2;
		}
		Arrays.sort(ans);
		return ans;
	}

	public int[] diStringMatch(String S) {
		int[] ans = new int[S.length() + 1];
		int max = S.length();
		int min = 0;

		int i = 0;
		for(char s : S.toCharArray()) {
			if(s == 'I') {
				ans[i++] = min++;
			} else {
				ans[i++] = max--;
			}
		}

		if(S.charAt(S.length() - 1) == 'I') {
			ans[i] = max;
		} else {
			ans[i] = min;
		}
		return ans;
	}

	public List<Integer> minSubsequence(int[] nums) {
		List<Integer> ans = new ArrayList<>();
		Arrays.sort(nums);
		int sum = 0;
		for(int n : nums){
			sum += n;
		}

		int subSum = 0;
		for(int i=nums.length - 1; i>=0; i--) {
			subSum += nums[i];
			ans.add(nums[i]);
			if(subSum > sum - subSum) {
				break;
			}
		}
		return ans;
	}

	public int hammingDistance(int x, int y) {
		int xor = x ^ y;
		int dis = 0;
		for(char n : Integer.toBinaryString(xor).toCharArray()) {
			if(n == '1') {
				dis++;
			}
		}
		return dis;
	}

	@Test
	public void t23sdxcv() {
		uniqueOccurrences(new int[]{1,2,2,1,1,3});
	}

	public boolean uniqueOccurrences(int[] arr) {
		Map<Integer, Integer> map = new HashMap<>();
		for(int a : arr) {
			if(map.containsKey(a)) {
				map.put(a, map.get(a) + 1);
			} else {
				map.put(a, 1);
			}
		}
		Set<Integer> cntSet = new HashSet<>();
		for(Integer cnt : map.values()) {
			if(cntSet.contains(cnt)){
				return false;
			} else {
				cntSet.add(cnt);
			}
		}
		return true;
	}

	public int peakIndexInMountainArray(int[] A) {
		int before = A[0];
		for(int i=1; i<A.length; i++) {
			if(A[i] < before) {
				return i;
			}
			before = A[i];
		}
		return 0;
	}

	//["5","2","C","D","+"]
	public int calPoints(String[] ops) {
		int[] arr = new int[ops.length];
		int i = 0;
		for (String s : ops) {
			switch (s) {
				case "C" :
					arr[i - 1] = 0; i--; break;
				case "D" :
					arr[i] = (arr[i - 1] * 2); i++; break;
				case "+" :
					arr[i] = arr[i - 1] + arr[i - 2]; i++; break;
				default :
					arr[i++] = (Integer.parseInt(s));
			}
		}
		int sum = 0;
		for (int p : arr) {
			sum += p;
		}
		return sum;
	}

	public int islandPerimeter(int[][] grid) {
		// copy
		int[][] cpy = new int[grid.length + 2][grid[0].length + 2];
		for(int i=0; i<grid.length; i++) {
			for(int j=0; j<grid[i].length; j++) {
				cpy[i+1][j+1] = grid[i][j];
			}
		}

		int ans = 0;
		for(int i=1; i<cpy.length - 1; i++) {
			for(int j=1; j<cpy[i].length - 1; j++) {
				if(cpy[i][j] == 1) {
					if(cpy[i][j-1] == 0) ans++;// 왼쪽
					if(cpy[i-1][j] == 0) ans++;// 위
					if(cpy[i][j+1] == 0) ans++;// 오른쪽
					if(cpy[i+1][j] == 0) ans++;// 아래
				}
			}
		}
		return ans;
	}

	public String[] findWords(String[] words) {
		String t1 = "QWERTYUIOPqwertyuiop";
		String t2 = "ASDFGHJKLasdfghjkl";
		String t3 = "ZXCVBNMzxcvbnm";
		Set<Character> s1 = toSet(t1);
		Set<Character> s2 = toSet(t2);
		Set<Character> s3 = toSet(t3);

		List<String> ans = new ArrayList<>();
		for(String w : words) {
			boolean flag = true;
			if(s1.contains(w.charAt(0))) {
				for(Character wc : w.toCharArray()) {
					if(!s1.contains(wc)) {
						flag = false; break;
					}
				}
			}
			if(s2.contains(w.charAt(0)) & flag) {
				for(Character wc : w.toCharArray()) {
					if(!s2.contains(wc)) {
						flag = false; break;
					}
				}
			}
			if(s3.contains(w.charAt(0)) & flag) {
				for(Character wc : w.toCharArray()) {
					if(!s3.contains(wc)) {
						flag = false;
					}
				}
			}
			if(flag) {
				ans.add(w);
			}
		}
		return ans.toArray(new String[ans.size()]);
	}

	private Set<Character> toSet(String word) {
		Set<Character> set = new HashSet<>();
		for(Character c : word.toCharArray()) {
			set.add(c);
		}
		return set;
	}

	// arr2의 모든 원소들과의 차가 d보다 큰 arr1의 원소 수
	public int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
		int ans = 0;
		for(int a1 : arr1) {
			boolean flag = true;
			for(int a2 : arr2) {
				if(Math.abs(a2 - a1) <= d) {
					flag = false; break;
				}
			}
			if(flag) {
				ans++;
			}
		}
		return ans;
	}

	@Test
	public void asf() {
		sortByBits(new int[]{10000,10000});
	}

	public int[] sortByBits(int[] arr) {
		// 2진수로 1의 갯수로 오름차순 정렬
		// 똑같으면 그냥 오름차순
		Data[] data = new Data[arr.length];
		for(int i=0; i<arr.length; i++) {
			String bn = Integer.toBinaryString(arr[i]);
			data[i] = new Data(arr[i], bn, getOneNum(bn));
		}
		Arrays.sort(data);
		return Arrays.stream(data).map(e -> e.n).mapToInt(e -> e).toArray();
	}

	class Data implements Comparable<Data> {
		public Data(int n, String bn, int cnt) {
			this.n = n;
			this.bn = bn;
			this.cnt = cnt;
		}

		int n;
		String bn;
		int cnt;

		@Override
		public int compareTo(Data o) {
			if(this.cnt == o.cnt) {
				return this.n - o.n;
			}
			return this.cnt - o.cnt;
		}
	}

	private int getOneNum(String bn) {
		int n=0;
		for(char c : bn.toCharArray()) {
			if(c == '1') n++;
		}
		return n;
	}


	public int[] kWeakestRows(int[][] mat, int k) {
		//row 별 1의 갯수 오름차순, 갯수가 같다면 index 오름차순
		Power[] powers = new Power[mat.length];

		for(int i=0; i<mat.length; i++) {
			int power = 0;
			for(int j=0; j<mat[i].length; j++) {
				if(mat[i][j] == 1) {
					power++;
				} else {
					break;
				}
			}
			powers[i] = new Power(power, i);
		}
		Arrays.sort(powers);
		return Arrays.stream(powers).map(e -> e.index).limit(k).mapToInt(e -> e).toArray();
	}

	class Power implements Comparable<Power> {

		int power;
		int index;

		public Power(int power, int index) {
			this.power = power;
			this.index = index;
		}

		@Override
		public int compareTo(Power o) {
			if(this.power == o.power) {
				return this.index - o.index;
			}
			return this.power - o.power;
		}
	}

	// 1 -> 2 -> 3 -> 4 -> 5
	// 1 -> 2 -> 3 -> 4 -> 5 -> 6
	public ListNode middleNode(ListNode head) {
		int size = 1;
		ListNode next = head;
		while(next.next != null) {
			size++;
			next = next.next;
		}
		int index = 0;
		next = head;
		while(index++ < (size / 2)) {
			next = next.next;
		}
		return next;
	}


	public void reverseString(char[] s) {
		int start = 0;
		int end = s.length - 1;
		while(start < end) {
			char t = s[start];
			s[start] = s[end];
			s[end] = t;
		}
	}

	public int singleNumber(int[] nums) {
		Arrays.sort(nums);
		for(int i=0; i<nums.length - 1; i+=2) {
			if(nums[i] != nums[i + 1]) {
				return nums[i];
			}
		}
		return nums[nums.length - 1];
	}




	//[1,0,1,0,1,0,1]
	@Test
	public void aef() {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(0);
		root.right = new TreeNode(1);
		root.left.left = new TreeNode(0);
		root.left.right = new TreeNode(1);
		root.right.left = new TreeNode(0);
		root.right.right = new TreeNode(1);
		sumRootToLeaf(root);
	}


	List<String> bsArray = new ArrayList<>();
	public int sumRootToLeaf(TreeNode root) {
		StringBuilder sb = new StringBuilder();
		sum(root, sb);
		int ans = 0;
		for(String s : bsArray) {
			ans += Integer.parseInt(s, 2);
		}
		return ans;
	}

	void sum(TreeNode node, StringBuilder bs) {
		if(node != null) {
			bs.append(node.val);
			if(node.left == null & node.right == null) {
				bsArray.add(bs.toString());
			}
			sum(node.left, bs);
			sum(node.right, bs);
			if(bs.length() > 0) {
				bs.deleteCharAt(bs.length() - 1);
			}
		}
	}

	//[[1,2,3],[4,5,6]]
	//[[1,4],[2,5],[3,6]]
	public int[][] transpose(int[][] A) {
		int row = A.length;
		int col = A[0].length;
		int[][] ans = new int[col][row];

		for(int i = 0; i < A.length; i++) {
			for(int j = 0; j < A[i].length; j++) {
				ans[j][i] = A[i][j];
			}
		}
		return A;
	}


	public int numUniqueEmails(String[] emails) {
		Set<String> ans = new HashSet<>();
		for(String email : emails) {
			String[] s = email.split("@");
			String local = localFilter(s[0]);
			String domain = s[1];
			ans.add(local + "@" + domain);
		}
		return ans.size();
	}

	public String localFilter(String local) {
		StringBuilder sb = new StringBuilder();
		for(char c : local.toCharArray()) {
			if(c == '+') {
				break;
			}
			if(c != '.') {
				sb.append(c);
			}
		}
		return sb.toString();
	}

	int max = 0;
	public int maxDepth(TreeNode root) {
		dfs(root, 0);
		return max;
	}

	public void dfs(TreeNode node, int depth) {
		if(node != null) {
			depth++;
			if(depth > max) max = depth;
			dfs(node.left, depth);
			dfs(node.right, depth);
		}
	}

	public int maxDepth(Node root) {
		if (root == null) return 0;
		int max = 0;
		for(Node n : root.children) {
			int temp = maxDepth(n);
			if(temp > max) max = temp;
		}
		return max + 1;
	}

	public List<String> commonChars(String[] A) {
		int[][] map = new int[A.length][26];
		for(int i=0; i<A.length; i++) {
			for(char c : A[i].toCharArray()) {
				map[i][c-'a']++;
			}
		}

		List<String> ans = new ArrayList<>();
		for(int i=0; i<26; i++) {
			int min = 9999;
			for(int j=0; j<A.length; j++) {
				if(map[j][i] < min) min = map[j][i];
			}
			while(min-- > 0) {
				ans.add(String.valueOf((char)('a' + i)));
			}
		}
		return ans;
	}

	@Test
	public void fsd() {
		sortArrayByParityII(new int[]{4,2,5,7});
	}

	public int[] sortArrayByParityII(int[] A) {
		// 절반 짝수, 절반 홀수
		// 짝수 i에는 짝수를, 홀수 i에는 홀수가 오도록 정렬

		//. . . . . .
		int[] odd = new int[A.length/2];
		int[] even = new int[A.length/2];
		int oddi = 0, eveni=0;
		for(int i=0; i<A.length; i++) {
			if(A[i] % 2 == 0) {
				even[eveni++] = A[i];
			} else {
				odd[oddi++] = A[i];
			}
		}
		int[] ans = new int[A.length];
		oddi = 0; eveni = 0;
		for(int i=0; i<A.length; i += 2) {
			ans[i] = even[eveni++];
			ans[i+1] = odd[oddi++];
		}
		return ans;
	}


	public int findLucky(int[] arr) {
		int[] cnt = new int[501];
		for(int n : arr) {
			cnt[n]++;
		}
		int ans = -1;
		for(int i=0; i<arr.length; i++) { // you can loop cnt from behind
			if(arr[i] == cnt[arr[i]]) { // lucky number
				if(arr[i] > ans) ans = arr[i];
			}
		}
		return ans;
	}


	// TODO : https://leetcode.com/problems/next-greater-element-i/
	public int[] nextGreaterElement(int[] nums1, int[] nums2) {
		int[] ans = new int[nums1.length];
		int ansIndex = 0;
		for(int i = 0; i < nums1.length; i++) {
			boolean flag = false;
			for(int j = i; j < nums2.length; j++) {
				if(nums2[j] > nums1[i]) {
					ans[ansIndex++] = nums2[j];
					flag = true;
					break;
				}
			}
			if(!flag) {
				ans[ansIndex++] = -1;
			}
		}
		return ans;
	}

	public ListNode reverseList(ListNode head) {
		if(head == null) return null;
		Stack<ListNode> st = new Stack<>();
		while(head != null) {
			st.push(head);
			head = head.next;
		}

		ListNode ans = st.pop();
		ListNode pivot = ans;
		while(!st.isEmpty()) {
			pivot.next = st.pop();
			pivot = pivot.next;
		}
		pivot.next = null;
		return ans;
	}

	@Test
	public void asdfasd() {
		duplicateZeros(new int[]{1,0,2,3,0,4,5,0});
	}

	public void duplicateZeros(int[] arr) {
		for(int i=0; i<arr.length; i++) {
			if(arr[i] == 0) {
				for(int j = arr.length - 1; j > i + 1; j--) {
					arr[j] = arr[j-1];
				}
				if(i < arr.length - 1) {
					arr[i + 1] = 0;
				}
				i++;
			}
		}
	}

	public List<String> fizzBuzz(int n) {
		List<String> ans = new ArrayList<>();
		for(int i = 1; i<=n; i++) {
			if(n%3 == 0 & n%5 == 0) {
				ans.add("FizzBuzz");
			} else if(n%3 == 0) {
				ans.add("Fizz");
			} else if(n%5 == 0) {
				ans.add("Buzz");
			} else {
				ans.add(String.valueOf(i));
			}
		}
		return ans;
	}

	@Test
	public void sdf2() {
		//Input: A = [1,2,3,4], queries = [[1,0],[-3,1],[-4,0],[2,3]]
		sumEvenAfterQueries(new int[]{1,2,3,4}, new int[][]{{1, 0}, {-3,1},{-4,0},{2,3}});
	}

	public int[] sumEvenAfterQueries(int[] A, int[][] queries) {
		int[] ans = new int[queries.length];
		int sum = 0;
		for(int n : A) {
			if(n%2 == 0) {
				sum += n;
			}
		}
		for(int i=0; i<queries.length; i++) {
			int val = queries[i][0];
			int index = queries[i][1];
			// 더하고 짝수 -> 원래 짝수 : +value, 원래 홀수 : +A[index]
			// 더하고 홀수 -> 원래 짝수 : -A[index]
			if((A[index] + val) % 2 == 0) {
				if(A[index] % 2 == 0) {
					sum += val;
				} else {
					sum += (A[index] + val);
				}
			} else {
				if(A[index] % 2 == 0) {
					sum -= A[index];
				}
			}
			A[index] += val;
			ans[i] = sum;
		}
		return ans;
	}

	public TreeNode invertTree(TreeNode root) {
		TreeNode temp = root.left;
		root.left = root.right;
		root.right = temp;
		invertTree(root.left);
		invertTree(root.right);
		return root;
	}

	/*
	Input: "Test1ng-Leet=code-Q!"
	Output: "Qedo1ct-eeLg=ntse-T!"
	 */
	public String reverseOnlyLetters(String S) {
		StringBuilder sb = new StringBuilder();
		char [] chars = S.toCharArray();
		int letteri = chars.length - 1;
		for(int i=0; i<chars.length; i++) {
			if(!check(chars[i])) {	// 현재 포지션이 문자가 아니면
				sb.append(chars[i]); // 기존 문자 추가
			} else {
				while(!check(chars[letteri])) {
					letteri--;
				}
				sb.append(chars[letteri--]);    // 문자면 추가
			}
		}
		return sb.toString();
	}
	boolean check(char c) {
		return ('a' <= c && c <= 'z') || ('A' <= c && c <= 'Z');
	}

	// https://leetcode.com/problems/monotonic-array/
	public boolean isMonotonic(int[] A) {
		if(A.length <= 1) return  true;
		int diff = A[1] - A[0];
		for(int i=0; i<A.length - 1; i++) {
			if(A[i] != A[i+1]) {
				if(diff * (A[i + 1] - A[i]) < 0) {
					return false;
				}
				diff = (A[i + 1] - A[i]);
			}
		}
		return true;
	}

	@Test
	public void fasdf() {
		System.out.println(isHappy(19));
	}
	//https://leetcode.com/problems/happy-number/
	public boolean isHappy(int n) {
		Set<Integer> set = new HashSet<>();
		int temp = n;
		while(true) {
			temp = happy(temp);
			if(temp == 1) return true;
			if(set.contains(temp)) {
				return false;
			} else {
				set.add(temp);
			}
		}
	}

	private int happy(int n) {
		String strN = Integer.toString(n);
		int ans = 0;
		for(char c : strN.toCharArray()) {
			ans += ((c - '0') * (c - '0'));
		}
		return ans;
	}

	//https://leetcode.com/problems/move-zeroes/
	/*
	Input: [0,1,0,3,12]
	Output: [1,3,12,0,0]
	 */
	public void moveZeroes(int[] nums) {
		int zero = 0;
		while(zero < nums.length) {
			if (nums[zero] == 0) { // 여기에 뒤에 있는 값을 끌어서 넣어야됨
				for(int i=zero; i<nums.length; i++) {
					if(nums[i] != 0) {
						nums[zero] = nums[i];
						nums[i] = 0;
						break;
					}
				}
			}
			zero++;
		}
	}

	//	https://leetcode.com/problems/shortest-distance-to-a-character/
	// C의 인덱스를 구한다.
	// S를 돌면서 가장 가까운 C를 찾는다.
	public int[] shortestToChar(String S, char C) {
		Set<Integer> cset = new HashSet<>();
		for(int i=0; i<S.length(); i++) {
			if(S.charAt(i) == C) {
				cset.add(i);
			}
		}
		int[] ans = new int[S.length()];
		for(int i=0; i<S.length(); i++) {
			if(cset.contains(i)) {
				ans[i] = 0;
			} else {
				int min = S.length();
				for (Integer set : cset) {
					if(Math.abs(set - i) < min) min = Math.abs(set - i);
				}
				ans[i] = min;
			}
		}
		return ans;
	}

	@Test
	public void xzcv() {
		System.out.println(reverseWords("Let's take LeetCode contest"));
	}

	// https://leetcode.com/problems/reverse-words-in-a-string-iii/
	//Input: "Let's take LeetCode contest"
	//Output: "s'teL ekat edoCteeL tsetnoc"
	public String reverseWords(String s) {
		StringBuilder sb = new StringBuilder();
		String[] sp = s.split(" ");
		for(String s2 : sp) {
			sb.append(new StringBuilder(s2).reverse().toString());
			sb.append(' ');
		}
		return sb.toString().trim();
	}

	//https://leetcode.com/problems/univalued-binary-tree/
	public boolean isUnivalTree(TreeNode root) {
		return check(root, root.val);
	}

	private boolean check(TreeNode node, int val) {
		if(node == null) return true;
		if(node.val != val) return false;
		return check(node.left, val) & check(node.right, val) ;
	}

	//https://leetcode.com/problems/distribute-candies/
	// 3 4 2 3 2 4
	public int distributeCandies(int[] candies) {
		Set<Integer> set = new HashSet<>();
		for(int candy : candies) {
			if(!set.contains(candy)) {
				set.add(candy);
			}
		}
		return Math.min(set.size(), candies.length / 2);
	}

	//https://leetcode.com/problems/binary-gap/
	public int binaryGap(int N) {
		String bN = Integer.toBinaryString(N); // 연속한 1 max 거리
		int max = 0;
		for(int i = 0; i < bN.length(); i++) {
			for(int j = i + 1; j < bN.length(); j++) {
				if((bN.charAt(i)) == '1' && (bN.charAt(j) == '1')) {
					if(Math.abs(i - j) > max) {
						max = Math.abs(i - j);
					}
					break;
				}
			}
		}
		return max;
	}

	//https://leetcode.com/problems/distribute-candies-to-people/
	public int[] distributeCandies(int candies, int num_people) {
		// 사람 별 캔디 수
		// 1번째 -> 1 --- loop 1
		// N번째 -> N
		// 1번째 -> 1 + N --- loop 2
		// N번째 -> N + N
		int[] ans = new int[num_people];

		for(int l = 0; candies > 0; l++) {
			for(int i = 0; i < num_people; i++) {
				int cnt = (i + 1) + l * num_people;
				if(candies >= cnt) {
					ans[i] += cnt;
					candies -= cnt;
				} else {
					ans[i] += candies;
					candies -= candies;
				}
			}
		}
		return ans;
	}

	//https://leetcode.com/problems/reshape-the-matrix/
	public int[][] matrixReshape(int[][] nums, int r, int c) {
		if(nums.length * nums[0].length != r * c) return nums;
		int[][] ans = new int[r][c];
		int ri = 0, ci = 0;
		for(int[] row : nums) {
			for(int col : row) {
				ans[ri][ci++] = col;
				if(ci == c) {
					ci = 0;
					ri++;
				}
			}
		}
		return ans;
	}

	//https://leetcode.com/problems/find-pivot-index/
	public int pivotIndex(int[] nums) {
		int sum = 0;
		for(int num : nums) {
			sum += num;
		}
		int leftSum = 0;
		for(int p = 0; p < nums.length; p++){
			if(p > 0) {
				leftSum += nums[p - 1];
			}
			if(leftSum == (sum - leftSum - nums[p])) {
				return p;
			}
		}
		return -1;
	}

	//https://leetcode.com/problems/maximum-number-of-balloons/
	public int maxNumberOfBalloons(String text) {
		int[] arr = new int[5];
		for(char c : text.toCharArray()) {
			switch (c) {
				case 'b' : arr[0]++; break;
				case 'a' : arr[1]++; break;
				case 'n' : arr[2]++; break;
				case 'l' : arr[3]++; break;
				case 'o' : arr[4]++; break;
			}
		}
		int min1 = Math.min(Math.min(arr[0], arr[1]), arr[2]);
		int min2 = Math.min(arr[3], arr[4]);
		return Math.min(min1, min2 / 2);
	}

	//https://leetcode.com/problems/intersection-of-two-arrays/
	public int[] intersection(int[] nums1, int[] nums2) {
		Set<Integer> set = new HashSet<>();
		for(int num : nums1) {
			set.add(num);
		}
		Set<Integer> intersec = new HashSet<>();
		for(int num : nums2) {
			if(set.contains(num)) {
				intersec.add(num);
			}
		}
		return intersec.stream().mapToInt(e -> e).toArray();
	}

	// TODO : https://leetcode.com/problems/trim-a-binary-search-tree/
	public TreeNode trimBST(TreeNode root, int L, int R) {
		// L <= root.val <= R
		if(root == null) return null;
		if(root.val < L) {
			return trimBST(root.right, L, R);
		}
		if(root.val > R) {
			return trimBST(root.left, L, R);
		}
		root.left = trimBST(root.left, L, R);
		root.right = trimBST(root.right, L, R);
		return root;
	}

	//https://leetcode.com/problems/uncommon-words-from-two-sentences/
	public String[] uncommonFromSentences(String A, String B) {
		// uncommon : 한번만 나타나고, 다른 문장에 안나타남
		Map<String, Integer> mapA = new HashMap<>();
		Map<String, Integer> mapB = new HashMap<>();
		Set<String> ans = new HashSet<>();
		for(String str : A.split(" ")) {
			mapA.put(str, mapA.getOrDefault(str, 0) + 1);
		}
		for(String str : B.split(" ")) {
			mapA.put(str, mapB.getOrDefault(str, 0) + 1);
		}
		for(String key : mapA.keySet()) {
			if(mapA.get(key) == 1 && !mapB.containsKey(key)) {
				ans.add(key);
			}
		}
		for(String key : mapB.keySet()) {
			if(mapB.get(key) == 1 && !mapA.containsKey(key)) {
				ans.add(key);
			}
		}
		return ans.toArray(new String[ans.size()]);
	}

	//https://leetcode.com/problems/prime-number-of-set-bits-in-binary-representation/
	// L, R 사이의 숫자중 2진수 표현에 1의 개숫가 소수인 수의 갯수 리턴
	public int countPrimeSetBits(int L, int R) {
		int ans = 0;
		for(int i=L; i<=R; i++) {
			if(isPrime(Integer.bitCount(i))) ans++;
		}
		return ans;
	}
	private boolean isPrime(int num) {
		if(num == 1) return false;
		for (int i = 2; i < num; i++) {
			if (num % i == 0) {
				return false;
			}
		}
		return true;
	}

	// https://leetcode.com/problems/element-appearing-more-than-25-in-sorted-array/
	// 더 좋은 방법 있음...
	public int findSpecialInteger(int[] arr) {
		Map<Integer, Integer> map = new HashMap();
		for(int n : arr) {
			map.put(n, map.getOrDefault(n, 0) + 1);
		}
		int ans = 0;
		int max = -1;
		for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
			if(entry.getValue() > max) {
				max = entry.getValue();
				ans = entry.getKey();
			}
		}
		return ans;
	}

	//https://leetcode.com/problems/distance-between-bus-stops/
	public int distanceBetweenBusStops(int[] distance, int start, int destination) {
		// distanct[i] : cost of i ~ (i+1)%n
		// min(total(distance), start~dest)
		int sum = 0;
		for(int n : distance) sum += n;
		int cost = 0;
		for(int i=start; i<destination; i++) {
			cost += distance[i];
		}
		return Math.min(cost, sum - cost);
	}

	@Test
	public void asdf() {
		Long stfds = null;
		System.out.println(Long.toString(stfds));
	}

	// TODO : https://leetcode.com/problems/design-hashmap/
}