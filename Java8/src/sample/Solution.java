package sample;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

	// Complete the connectedCell function below.
	static int count(int[][] a, int i, int j) {
		int rows = a.length;
		System.out.println("rows" + rows);
		int cols = a[0].length;
		System.out.println("cols" + cols);

		if (a[i][j] == 0)
			return 0;
		if (i == rows - 1 && j == cols - 1)
			return a[i][j];
		else if (i == rows - 1)
			return a[i][j + 1];
		else if (j == cols - 1)
			return a[i + 1][j];
		else if (a[i][j] == 1)
			return count(a, i + 1, j) + count(a, i, j + 1);
		else
			return 0;
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {

		int n = scanner.nextInt();
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		int m = scanner.nextInt();
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		int[][] matrix = new int[n][m];

		for (int i = 0; i < n; i++) {
			String[] matrixRowItems = scanner.nextLine().split(" ");
			scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

			for (int j = 0; j < m; j++) {
				int matrixItem = Integer.parseInt(matrixRowItems[j]);
				matrix[i][j] = matrixItem;
			}
		}

		int result = count(matrix, n, m);

		System.out.println("result:: "+result);

		scanner.close();
	}
}
