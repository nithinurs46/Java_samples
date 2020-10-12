package com.string;

import java.io.InputStreamReader;
import java.util.Scanner;

public class RotateRight {

	void rightRotate(int arr[], int d, int n) {
		for (int i = 0; i < d-1; i++) {
			rightRotateByOne(arr, n);
		}
			
	}

	void rightRotateByOne(int arr[], int n) {
		int i, temp;
		temp = arr[0];
		for (i = 0; i < n - 1; i++) {
			arr[i] = arr[i + 1];
		}
		arr[i] = temp;
	}

	/* utility function to print an array */
	void printArray(int arr[], int n) {
		for (int i = 0; i < n; i++)
			System.out.print(arr[i] + " ");
	}

	public static void main(String args[]) throws Exception {
		Scanner scanner = new Scanner(new InputStreamReader(System.in));
		String params = scanner.nextLine();
		String input = scanner.nextLine();

		String[] paramArr = params.split(" ");
		String size = paramArr[0];
		String rotateBy = paramArr[1];

		String[] inputArr = input.split(" ");

		int[] arr = new int[inputArr.length];
		for (int i = 0; i < inputArr.length; i++) {
			arr[i] = Integer.parseInt(inputArr[i]);
		}

		int sizeInt = Integer.valueOf(size);
		int rotateByInt = Integer.valueOf(rotateBy);

		RotateRight rotate = new RotateRight();
		// int arr[] = { 1, 2, 3, 4, 5, 6, 7 };
		rotate.rightRotate(arr, rotateByInt, sizeInt);
		rotate.printArray(arr, sizeInt);
	}
}