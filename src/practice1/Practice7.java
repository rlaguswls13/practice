package practice1;

import java.util.Scanner;

public class Practice7 {
	public static void main(String[] args) {
		try(Scanner sc = new Scanner(System.in)) {
			// method1(sc);
			// method2(sc);
			// method3(sc);
			// method3_1(sc);
			// method4();
			// method4_1(sc);
			// method5(sc);
			// method6(sc);
			// method6_1(sc);
			// method7();
			// method8(sc);
			// method8_1(sc);
			// method8_2(sc);
			method8_3(sc);
		}
	}
	
	/*
	 * 정수 `N(1 ≤ N ≤ 9)`이 주어졌을 때, **`N` 단 구구단을 1부터 9까지 출력**하는 프로그램을 작성하세요.
	 * 출력 형식은 `N * i = 결과`이며, 각 줄마다 i가 1부터 9까지 하나씩 증가합니다. 공백과 기호 표현에 주의하세요
	 */
	private static void method1(Scanner sc) {
		System.out.print("단수를 입력해주세요 (1~9단) : ");
		int inputValue = sc.nextInt();
		if(inputValue < 1 || inputValue > 9) {
			System.out.println("1 ~ 9 범위를 벗어났습니다. 다시 실행하여 입력해주세요.");
			return;
		} else {
			for(int i=1; i<=9; i++) {
				int valued = inputValue * i;
				System.out.printf("%d * %d = %d \n", inputValue, i, valued);
			}
		}
	}
	
	
	/*
	 * 영수증에 적힌 **총 구매 금액**이 실제 구매한 각 물건의 **가격 × 개수 합계**와 일치하는지 확인하는 프로그램을 작성하세요. 총액이
	 * 정확하면 `"Yes"`, 그렇지 않으면 `"No"`를 출력합니다.
	 */
	private static void method2(Scanner sc) {
		System.out.print("구매예상 금액을 입력해주세요 : ");
		int expectedTotalprice = sc.nextInt();
		System.out.print("구매항목의 개수를 입력해주세요 : ");
		int listSize = sc.nextInt();
		
		System.out.print("가격 -> 개수 순으로 입력해주세요. : ");
		
		int calculatedTotalprice = 0;
		for(int i=0; i < listSize; i++) {
			int price = sc.nextInt();
			int counts = sc.nextInt();
			calculatedTotalprice += price*counts;
		}
			
		if(expectedTotalprice == calculatedTotalprice) System.out.println("YES");
		else System.out.println("NO");	
	}
	
	private static void method3(Scanner sc) {
		System.out.println("테스트 진행할 개수를 입력해주세요 :");
		int testCaseCounts = sc.nextInt();
		
		System.out.printf("총 %d개를 입력하실 수 있습니다. 테스트 진행할 정수 A,B를 입력해주세요. \n", testCaseCounts);
		for(int i=1; i <= testCaseCounts; i++) {
			int inputA = sc.nextInt();
			int inputB = sc.nextInt();
			int sumAB = inputA + inputB;
			System.out.printf("Case #%d :%d + %d = %d\n", i , inputA, inputB, sumAB);
		}
	}
	
	private static void method3_1(Scanner sc) {
		System.out.println("테스트 진행할 개수를 입력해주세요 :");
		int testCaseCounts = sc.nextInt();
		int[] inputA = new int[testCaseCounts];
		int[] inputB = new int[testCaseCounts];
		System.out.printf("총 %d개를 입력하실 수 있습니다. 테스트 진행할 정수 A,B를 입력해주세요. \n", testCaseCounts);
		for(int i=0; i <= testCaseCounts-1; i++) {
			inputA[i] = sc.nextInt();
			inputB[i] = sc.nextInt();
			if(i == testCaseCounts-1) {
				for(int j = 0; j < inputA.length; j++) {
					System.out.printf("Case #%d :%d + %d = %d\n", j+1, inputA[j], inputB[j], inputA[j] + inputB[j]);
				}
			}
			
		}
	}
	
	/*
	 * 1부터 100 사이의 숫자 중에서 **7의 배수만 출력하는 프로그램**을 작성하세요.
	 * 단, **짝수인 7의 배수는 건너뛰고**, 출력에서 제외하세요.
	 */
	private static void method4() {
		for(int i=1; i <=100; i++) {
			if(i % 7 == 0 && i % 2 != 0) System.out.printf("%d ", i);
		}
		System.out.println();
	}
	
	private static void method4_1(Scanner sc) {
		System.out.print("출력할 배수의 값 n(정수)를 입력해주세요. : ");
		int inputValue = sc.nextInt();
		for(int i=1; i <= 100; i++) {
			if(i % inputValue == 0) System.out.printf("%d ", i);
		}
	}
	
	/*
	 * 사용자에게 정수를 반복 입력받아 **총합을 누적 계산**하는 프로그램을 작성하세요.
	 * 단, **음수를 입력하면 입력을 종료**하고, 마지막에 누적된 총합을 출력하세요.
	 */
	private static void method5(Scanner sc) {
		boolean flag = true;
		int totalValue = 0;
		while(flag) {
			System.out.print("숫자입력 : ");
			int inputValue = sc.nextInt();
			if(inputValue < 0) flag = false;
			else totalValue += inputValue;
		}
		System.out.println("총합 : "+totalValue);
	}
	
	
	/*
	 * 사용자로부터 10개의 정수를 입력받아, **짝수일 경우에만 제곱을 출력**하는 프로그램을 작성하세요.
     *  홀수는 건너뛰고 출력하지 않습니다.
	 */
	private static void method6(Scanner sc) {		
		for(int i = 0; i < 10; i++) {
			System.out.print("숫자 입력 : ");
			int inputValue = sc.nextInt();
			if(inputValue % 2 == 0) System.out.printf("짝수 %d의 제곱은 %d입니다.\n", inputValue, inputValue*inputValue);
		}
	}
	
	private static void method6_1(Scanner sc) {
		System.out.println("제곱근을 출력할 정수 10개를 입력해주세요. (단, 홀수는 제외하고 출력됩니다.)");
		int arraySize = 10;
		int[] inputValueArray = new int[arraySize];
		for(int i = 0; i < arraySize; i++) {
			System.out.print("숫자 입력 : ");
			inputValueArray[i] = sc.nextInt();
		}
		
		for(int i = 0; i < arraySize; i++) {
			int value = inputValueArray[i];
			if(value % 2 == 0) {
				System.out.printf("짝수 %d의 제곱은 %d입니다.\n", value, value*value);
			}
		}
	}
	
	private static void method7() {
		for(int i = 2; i <=9; i++) {
			System.out.println(i+" 단");
			for(int j = 1; j <=9; j++) {
				System.out.printf("%d * %d = %d\n", i, j, i*j);
			}
		}
	}
	
	// 사용자로부터 정수 N(1 ≤ N ≤ 20)을 입력받아, N층의 왼쪽 정렬된 별 피라미드를 출력하세요.
	private static void method8(Scanner sc) {
		int floor = sc.nextInt();
		String starFlag = "";
		for(int i=0; i < floor; i++) {
			starFlag += "*";
			System.out.println(starFlag);
		}
	}
	
	// 으론쪽 정렬
	private static void method8_1(Scanner sc) {
		int floor = sc.nextInt();
		for(int i=0; i < floor; i++) {
			String starFlag = "";
			for(int j = floor-1; 0<=j; j--) {
				if(i < j) starFlag += " ";
				else starFlag += "*";
			}
			System.out.println(starFlag);
		}
	}
	
	// 역피라미드 왼쪽정렬
	private static void method8_2(Scanner sc) {
		int floor = sc.nextInt();
		for(int i=0; i < floor; i++) {
			String starFlag = "";
			for(int j = floor-1; 0<=j; j--) {
				if(i < j) starFlag += "*";
				else starFlag += " ";
			}
			System.out.println(starFlag);
		}
	}
	
	// 역피라미드 오른족정렬
	private static void method8_3(Scanner sc) {
		int floor = sc.nextInt();
		for(int i=0; i < floor; i++) {
			String starFlag = "";
			for(int j = 0; j < floor; j++) {
				if(i > j) starFlag += " ";
				else starFlag += "*";
			}
			System.out.println(starFlag);
		}
	}
}
