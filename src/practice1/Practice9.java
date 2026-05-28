package practice1;

import java.util.Arrays;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class Practice9 {
	public static void main(String[] args) {
		try(Scanner sc = new Scanner(System.in)) {
			//method1(sc);
		    method2(sc);
			// method3(sc);
		}
	}
	
	// M*N 행열의 덧셈
	private static void method1(Scanner sc) {
		System.out.printf("형렬의 크기를 작성해주세요(M N): ");
		int xAxisSize = sc.nextInt();
		int yAxixSize = sc.nextInt();
		
		int[][] matrix1 = makeRandomMatrix(xAxisSize, yAxixSize);
		int[][] matrix2 = makeRandomMatrix(xAxisSize, yAxixSize);
		int[][] sumMatrix = sumMatrix(matrix1, matrix2, xAxisSize, yAxixSize);
		printMatirx(sumMatrix);
	}
	
	private static int[][] makeRandomMatrix(int xSize, int ySize) {
		int[][] matrix = new int[xSize][ySize];
		for (int i = 0; i < xSize; i++) {
	        for (int j = 0; j < ySize; j++) {
	        	matrix[i][j] = ThreadLocalRandom.current().nextInt(-100, 101);
	        }
	    }
		printMatirx(matrix);
		return matrix;
	}
	
	private static int[][] sumMatrix(int[][] matrix1, int[][] matrix2, int xSize, int ySize) {
		int[][] matrix3 = new int[xSize][ySize];
		for(int i = 0; i < xSize; i++) {
			for(int j = 0; j < ySize; j++) {
				matrix3[i][j] = matrix1[i][j] + matrix2[i][j];
			}
		}
		return matrix3;
	}
	
	private static void printMatirx(int[][] matrix) {
		System.out.println("===============");
		for (int[] row : matrix) {
		    System.out.println(Arrays.toString(row));
		}
	}
	
	// 2차원 배열의 최댓값 찾기
	private static void method2(Scanner sc) {
		System.out.printf("형렬의 크기를 작성해주세요(M N): ");
		int xAxisSize = sc.nextInt();
		int yAxixSize = sc.nextInt();
		
		int[][] matrix1 = makeRandomMatrix(xAxisSize, yAxixSize);
		findBiggestNumberInMatix(matrix1);
	}
	
	// 위에서 입력받은 값을 직접 method에 넣었다면, 이번엔 임이의 matrix라고 할때, 사이즈 검증을 통해
	// for을 구현하는 방법 채택
	private static void findBiggestNumberInMatix(int[][] matrix) {
		int biggestNumber = Integer.MIN_VALUE;
		int xAxisSize = matrix.length;
		int yAxisSize = matrix[0].length;
		for(int i=0; i < xAxisSize; i++) {
			for(int j=0; j <yAxisSize; j++) {
				if(biggestNumber < matrix[i][j]) biggestNumber = matrix[i][j];
			}
		}
		System.out.println(biggestNumber);
	}
	

}
