package com.algo.medium;

import java.util.ArrayList;
import java.util.List;

import com.algo.easy.TreeNode;

public class FlipMatrix {


	public int maxEqualRowsAfterFlips(int[][] matrix) {

		return 0;
	}


	void flipMatrix(int[][] matrix, int col) {
		for(int i=0; i<matrix[0].length; i++) {
			matrix[i][col] ^= matrix[i][col];
		}
	}

	int countSameRow(int[][] matrix) {
		int sameRowCount = 0;
		for(int i=0; i < matrix[0].length; i++) {
			if(isAllSameRow(matrix[i])) {
				sameRowCount++;
			}
		}
		return sameRowCount;
	}

	boolean isAllSameRow(int[] rows) {
		int sum=0;
		for(int i=0; i<rows.length; i++) {
			sum += rows[i];
		}
		return sum == 0 || sum == rows.length;
	}
}
