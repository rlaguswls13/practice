package practice1;

import java.util.Scanner;

public class Practice2 {
	public static void main(String[] args) {
		boolean flag = true;
        // Scanner를 루프 밖에서 선언하여 프로그램 종료 시까지 스트림 유지
        try (Scanner sc = new Scanner(System.in)) {
            while (flag) {
                try {
                    System.out.print("첫 번째 정수 입력: ");
                    int a = sc.nextInt();

                    System.out.print("두 번째 정수 입력: ");
                    int b = sc.nextInt();

                    // 연산 결과 계산
                    int sum = a + b;
                    int difference = a - b;
                    int product = a * b;

                    System.out.println("\n--- 연산 결과 ---");
                    System.out.printf("더하기   : %d\n", sum);
                    System.out.printf("빼기     : %d\n", difference);
                    System.out.printf("곱하기   : %d\n", product);

                    // 0으로 나누기 예외 방지
                    if (b != 0) {
                        System.out.printf("나누기(몫): %d\n", a / b);
                        System.out.printf("나머지   : %d\n", a % b);
                        flag = false; // 정상 계산 완료 시 루프 종료
                    } else {
                        System.out.println("나누기   : 0으로 나눌 수 없습니다. 다시 시도하세요.");
                        // flag가 true이므로 자동으로 다시 입력 단계로 이동
                    }

                } catch (Exception e) {
                    System.out.println("오류: 정수만 입력 가능합니다.");
                    // 중요: 버퍼에 남은 잘못된 입력을 비워줌 (무한 루프 방지)
                    sc.next(); 
                }
                System.out.println(); // 가독성을 위한 줄바꿈
            }
        } 
        System.out.println("프로그램을 종료합니다.");
	}
}
