package practice1;

import java.util.Scanner;

public class Practice6 {
	public static void main(String[] args) {
		// sumEvenNumberByFor();
		// sumNumberUntilRandomLimitByFor();
		sumNumberUntilRandomLimitByWhile();
		// extractEvenChar();
	}
	
	
	private static void sumEvenNumberByFor() {
		int sumNum = 0;
		for(int i = 1; i <= 100; i++) {
			if(i % 2 == 0) sumNum += i;
		}
		System.out.println("짝수의 합은 : " + sumNum);
	}

	private static void sumNumberUntilRandomLimitByFor() {
		int sumNum = 0;
		int randomNum = (int)(Math.random() * 100);
		
		for(int i = 1; i <= randomNum; i++) {
			sumNum += i;
		}
		System.out.println("n은  : " + randomNum);
		System.out.println("1~n 합은 : " + sumNum);
	}
	
	
	private static void sumNumberUntilRandomLimitByWhile() {
		int sumNum = 0;
		int limitCounts = 0;
		int randomNum = (int)(Math.random() * 100);
		
		while(limitCounts <= randomNum) {
			sumNum += limitCounts ;
			limitCounts++;
		}
		System.out.println("n은  : " + randomNum);
		System.out.println("1~n 합은 : " + sumNum);
	}
	
	private static void extractEvenChar() {
		try(Scanner sc = new Scanner(System.in)) {
			System.out.print("문자열을 입력해 주세요 : ");
			String inputValue = sc.next();
			
			
			int valueLength = inputValue.length();
			String evenChar = "";
			for(int i = 0; i < valueLength; i++) {
				if(i % 2 == 0 && valueLength != i+1) evenChar += inputValue.charAt(i+1);
			}
			System.out.println(evenChar);
	
		} catch (Exception e) {
			System.err.println("작업중 문제가 발생했습니다. 다시 실행 해주세요.");
		}
	}
}
