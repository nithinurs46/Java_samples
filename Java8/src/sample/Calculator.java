package sample;

public class Calculator {

	static int count(int a[][], int i, int j) {
		int rows = a.length;
		System.out.println("rows" + rows);
		int cols = a[0].length;
		System.out.println("cols" + cols);

		if (i == rows - 1 && j == cols - 1)
			return a[i][j];
		else if (i == rows - 1)
			return a[i][j + 1];
		else if (j == cols - 1)
			return a[i + 1][j];

		else if (a[i-1][j-1] == 1)
			return count(a, i + 1, j) + count(a, i, j + 1);

		else
			return 0;
	}

	public static void main(String[] args) {
		int a[][] = new int[3][4];
		// a = { { 1, 0, 0, 1 }, { 0, 1, 1, 1 }, { 1, 0, 0, 1 } };
		a[0][0] = 1;
		a[0][1] = 0;
		a[0][2] = 0;
		a[0][3] = 1;

		a[1][0] = 0;
		a[1][1] = 1;
		a[1][2] = 1;
		a[1][3] = 1;

		a[2][0] = 1;
		a[2][1] = 0;
		a[2][2] = 0;
		a[2][3] = 1;
		int i = 3;
		int j = 3;
		System.out.println(count(a, i, j));
	}
}
